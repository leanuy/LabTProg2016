<%-- 
    Document   : PerfilCliente
    Created on : Sep 14, 2016, 9:41:08 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12" style="width:150px;height:150px;overflow:hidden">
                    <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${nick}&extra=null" class="img-circle" style="width:100%"/> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                    <c:choose>
                        <c:when test="${not empty es_cliente and es_cliente}">
                            <c:choose>
                                <c:when test="${siguiendo}">
                                    <a class="btn btn-custom" href="/DejarSeguirUsuario?nick=${nick}">Dejar de Seguir</a>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${tiene_suscripcion}">
                                                <a class="btn btn-custom" href="/SeguirUsuario?nick=${nick}">Seguir</a>
                                        </c:when>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                    </c:choose>
                </h1>
            </div>
            <div class="horizontalgap" style="height:10px"></div>
            <div class="row">             
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a class="btn-link" href="#listas">Listas (<c:out value="${fn:length(listas)}"/>)</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="listas" class="tab active">
                            <ul class="rig columns-4">
                                <c:forEach items="${listas}" var="item">
                                    <li>
                                        <a href="/VerListaParticular?nick=${nick}&lista=${item}">
                                            <image src="/VerImagen?tipo=ImagenLista&nombreUsuario=${nick}&extra=${item}"/>
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




<%--El usuario visitante solo puede ver el perfil de los Artistas,
si selecciona un Cliente el sistema mostrará su nickname e imagen,
y sus listas de reproducción particulares públicas que son
accesibles a sus seguidores.--%>