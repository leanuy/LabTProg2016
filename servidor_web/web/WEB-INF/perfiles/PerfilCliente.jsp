<%-- 
    Document   : PerfilCliente
    Created on : Sep 14, 2016, 9:41:08 PM
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
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                </h1>
                <c:choose>
                    <c:when test="${empty es_cliente or not es_cliente}">
                    </c:when>
                    <c:otherwise>
                        <a href="#">Seguir</a>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="row">             
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#tab1">Listas</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab1" class="tab active">
                            <ul>
                                <c:forEach items="${listas}" var="item">
                                    <li>
                                        <a href="#">${item}</a>
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