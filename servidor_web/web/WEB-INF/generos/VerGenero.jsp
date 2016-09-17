<%-- 
    Document   : VerGenero
    Created on : Sep 17, 2016, 12:56:08 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery-3.1.0.min.js"></script>
    <script>
        jQuery(document).ready(function() {
            jQuery('.tabs .tab-links a').on('click', function(e)  {
                var currentAttrValue = jQuery(this).attr('href');

                // Show/Hide Tabs
                jQuery('.tabs ' + currentAttrValue).show().siblings().hide();

                // Change/remove current tab to active
                jQuery(this).parent('li').addClass('active').siblings().removeClass('active');

                e.preventDefault();
            });
        });
    </script>
    
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <h1>
                    <c:out value="${nombre}"/>
                </h1>
            </div>
            <div class="row">             
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#tab1">Albums (<c:out value="${fn:length(albums)}"/>)</a></li>
                        <li><a href="#tab2">Listas (<c:out value="${fn:length(listas)}"/>)</a></li>
                        <li><a href="#tab3">Subgéneros (<c:out value="${fn:length(subgeneros)}"/>)</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab1" class="tab active">
                            <ul>
                                <c:forEach items="${albums}" var="item">
                                    <li>
                                        <a class="link-user" href="/VerPerfil?nick=${item[1]}">${item[1]}</a>
                                         - 
                                        <a href="/VerAlbum?nick=${item[1]}&amp;album=${item[0]}">${item[0]}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab2" class="tab">
                            <ul>
                                <c:forEach items="${listas}" var="item">
                                    <li>
                                        <a href="/VerListaDefecto?lista=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab3" class="tab">
                            <ul>
                                <c:forEach items="${subgeneros}" var="item">
                                    <li>
                                        <a href="/VerGenero?genero=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</t:body>


