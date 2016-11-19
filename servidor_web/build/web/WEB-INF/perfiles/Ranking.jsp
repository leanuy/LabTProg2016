<%-- 
    Document   : Ranking
    Created on : Oct 24, 2016, 6:02:19 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <!--<div class="panel-heading">Album</div>-->
        <div class="panel-body">
            <div class="row">
                <h1>
                    Ranking
                </h1>
                <ul class="rig columns-4">
                    <c:forEach items="${usuarios}" var="item">
                        <li>
                            <a class="link-user" href="/VerPerfil?nick=${item.nick}"/>
                                <image src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item.nick}&extra=null" class="image-circle"/>
                                <h3>${item.nick} (${item.cantSeguidores})</h3>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</t:body>