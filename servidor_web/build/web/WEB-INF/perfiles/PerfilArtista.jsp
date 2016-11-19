<%-- 
    Document   : PerfilArtista
    Created on : Sep 15, 2016, 11:27:27 AM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery-3.1.0.min.js"></script>
    <script src="assets/js/script_tabs.js"></script>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${nick}&extra=null" class="image-circle"/> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                    <c:choose>
                        <c:when test="${empty es_cliente or not es_cliente}">
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${siguiendo}">
                                    <a class="btn btn-custom" href="/DejarSeguirUsuario?nick=${nick}">Dejar de Seguir</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-custom" href="/SeguirUsuario?nick=${nick}">Seguir</a>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </h1>
            </div>
            <div class="horizontalgap" style="height:10px"></div>
            <div class="row">
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#datosPersonales">Datos Personales</a></li>
                        <li><a href="#seguidores">Seguidores (<c:out value="${fn:length(seguidores)}"/>)</a></li>
                        <li><a href="#albums">Álbums (<c:out value="${fn:length(albums)}"/>)</a></li>
                    </ul>
                
                    <div class="tab-content">
                        <div id="datosPersonales" class="tab active">
                            <ul>
                                <li>
                                    <i class="glyphicon glyphicon-user"></i>
                                    <c:out value="${nombre}"/> <c:out value="${apellido}"/>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-envelope"></i>
                                    <c:out value="${correo}"/>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-calendar"></i>
                                    <c:out value="${fechaNac}"/>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-globe"></i>
                                    <a class="btn-link" href="<c:out value="${url}"/>"><c:out value="${url}"/></a>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-list-alt"></i>
                                    <c:out value="${bio}"/>
                                </li>
                            </ul>
                        </div>
                        <div id="seguidores" class="tab">
                            <ul class="rig columns-4">
                            <c:forEach items="${seguidores}" var="item">
                                <li>
                                    <a class="btn-link" href="/VerPerfil?nick=${item}">
                                        <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item}&extra=null" class="image-circle"/>
                                        <h3>${item}</h3>
                                    </a>
                                </li>
                                
                            </c:forEach>
                            </ul>
                        </div>
                        <div id="albums" class="tab">
                            <ul class="rig columns-4">
                                <c:forEach items="${albums}" var="item">
                                    <li>
                                        <a class="btn-link" href="/VerAlbum?nick=${nick}&amp;album=${item}">
                                            <image src="/VerImagen?tipo=ImagenAlbum&nombreUsuario=${nick}&extra=${item}" class="image-square"/>
                                            <h3>${item}</h3>
                                        </a>
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