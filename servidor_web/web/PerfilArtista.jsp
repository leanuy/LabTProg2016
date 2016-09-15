<%-- 
    Document   : PerfilArtista
    Created on : Sep 15, 2016, 11:27:27 AM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del artista--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                </h1>
                <div>
                    <h2>
                        Albums:
                    </h2>
                    <c:forEach items="${albums}" var="item">
                        ${item}<br/>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    
</t:body>


<%--Este caso de uso permite al Cliente/Artista consultar los siguientes datos de su perfil:
nickname, correo electrónico, nombre, apellido, fecha de nacimiento e imagen (opcional).
Luego, el sistema muestra todos los datos del usuario, incluyendo, sí tiene, su imagen asociada.
Se muestran los nickname de todos los seguidores que tiene.
Si es artista se listan los nombres de cada álbum
que tenga registrado y, para cualquier álbum que el usuario quiera, se visualizan
los datos de éste de la misma forma que se hace en Consulta de Álbum. El usuario
visitante solo puede ver el perfil de los Artistas.--%>

