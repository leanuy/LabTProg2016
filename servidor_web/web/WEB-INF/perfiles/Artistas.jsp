<%-- 
    Document   : Artistas
    Created on : Sep 17, 2016, 12:11:00 PM
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
                    Artistas
                </h1>
                <ul>
                    <c:forEach items="${artistas}" var="item">
                        <li>
                            <a class="link-user" href="/VerPerfil?nick=${item.nombre}">${item.nombre}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</t:body>