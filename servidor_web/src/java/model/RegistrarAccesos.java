package model;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author JavierM42
 */
public class RegistrarAccesos implements Filter {
    
    private static final boolean debug = true;

    public RegistrarAccesos() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
    }
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        HttpServletRequest req = (HttpServletRequest)request;
        String ip = req.getRemoteAddr();
        String url = req.getRequestURL().toString();
        
        //http://stackoverflow.com/questions/1326928/how-can-i-get-client-infomation-such-as-os-and-browser
        String  browserDetails  =   req.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();
        String os = "";
        String browser = "";

        //=================OS=======================
         if (userAgent.toLowerCase().contains("windows"))
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().contains("mac"))
         {
             os = "Mac";
         } else if(userAgent.toLowerCase().contains("x11"))
         {
             os = "Linux";
         } else if(userAgent.toLowerCase().contains("android"))
         {
             os = "Android";
         } else if(userAgent.toLowerCase().contains("iphone")) {
             os = "iOS";
         } else {
             os = "Desconocido";
         }
         //===============Browser===========================
        if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera"))
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            else if(user.contains("opr"))
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        } else if (user.contains("chrome"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
            browser = "Netscape-?";

        } else if (user.contains("firefox"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if(user.contains("rv"))
        {
            browser="IE";
        } else
        {
            browser = "Desconocido";
        }
        
        
        
        
        port.registrarAcceso(ip, url, browser, os);
        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        return "Filtro de registro de accesos";
    }

}
