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
            </div>
            <div class="row">
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#tab1">Álbums</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab1" class="tab active">
                            <ul>
                                <c:forEach items="${albums}" var="item">
                                    <li>
                                        <a href="/VerAlbum?nick=${nick}&amp;album=${item}">${item}</a>
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


<%--Este caso de uso permite al Cliente/Artista consultar los siguientes datos de su perfil:
nickname, correo electrónico, nombre, apellido, fecha de nacimiento e imagen (opcional).
Luego, el sistema muestra todos los datos del usuario, incluyendo, sí tiene, su imagen asociada.
Se muestran los nickname de todos los seguidores que tiene.
Si es artista se listan los nombres de cada álbum
que tenga registrado y, para cualquier álbum que el usuario quiera, se visualizan
los datos de éste de la misma forma que se hace en Consulta de Álbum. El usuario
visitante solo puede ver el perfil de los Artistas.--%>

