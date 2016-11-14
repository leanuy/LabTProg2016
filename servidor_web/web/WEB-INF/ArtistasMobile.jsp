<%-- 
    Document   : ArtistasMobile
    Created on : Nov 15, 2016, 6:48:46 PM
    Author     : DJA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:mobile_body>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <!--<div class="panel-heading">Album</div>-->
        <div class="panel-body">
            <div class="row">
                <h1>
                    Artistas
                </h1>
                <ul class="rig columns-4">
                    <c:forEach items="${artistas}" var="item">
                        <li>
                            <a class="link-user" href="/VerAlbums?nick=${item}"/>
                                <image src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item}&extra=null" class="image-circle"/>
                                <h3>${item}</h3>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</t:mobile_body>