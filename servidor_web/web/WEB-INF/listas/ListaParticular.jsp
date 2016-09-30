<%-- 
    Document   : ListaParticular
    Created on : Sep 16, 2016, 11:26:41 AM
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
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del album--%>
                </div>
                <%--datos basicos--%>
                <div>
                    <h1>
                        <c:out value="${nomLista}"/>
                        <c:choose>
                            <c:when test="${esPrivada and tiene_suscripcion}">                            
                                <a class="btn btn-custom" href="/publicarlista?lista=<c:out value="${nomLista}"/>"><i class="glyphicon glyphicon-lock"></i> Publicar</a>
                            </c:when>
                        </c:choose>
                    </h1>
                    <div class="pull-right">
                        <c:choose>
                            <c:when test="${empty es_favorito}">
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${es_favorito}">
                                        <a class="btn-link-inverse" href="/DesFavoritear?tipo=particular&lista=${nomLista}&nick=${nomCliente}"><i class="glyphicon glyphicon-star"></i></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn-link" href="/Favoritear?tipo=particular&lista=${nomLista}&nick=${nomCliente}"><i class="glyphicon glyphicon-star"></i></a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </div>
                        <div><i class="glyphicon glyphicon-user"></i> <c:out value="${nomCliente}"/></div>
                </div>
                <%--temas--%>
                <table class="table">
                    <thead>
                        <tr>    
                            <th class="btn-table">&nbsp;</th>
                            <th>#</th>
                            <th>Nombre</th>
                            <th class="hidden-xs"><i class="glyphicon glyphicon-time"></i></th>
                            <th class="hidden-xs"><i class="glyphicon glyphicon-star"></i></th>
                            <th class="btn-table">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${temas}" var="tema" varStatus="temaStatus">
                            <tr>
                                <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                                <td><c:out value="${temaStatus.index+1}"/></td>
                                <td><c:out value="${tema.nombre}"/></td>
                                <td class="hidden-xs"><c:out value="${tema.duracionStr}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty es_favorito}">
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${es_favorito_temas[temaStatus.index]}">
                                                    <a class="btn btn-link-inverse pull-left" href="/DesFavoritear?tipo=tema&artista=${tema.nomArtista}&album=${tema.album}&tema=${tema.nombre}"><i class="glyphicon glyphicon-star"></i></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="btn btn-link pull-left" href="/Favoritear?tipo=tema&artista=${tema.nomArtista}&album=${tema.album}&tema=${tema.nombre}"><i class="glyphicon glyphicon-star"></i></a>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><button class="btn btn-link pull-right "><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
</t:body>


<%--Luego, el sistema muestra el nombre de la lista de reproducción,
el género al que aplica o cliente que la definió, su imagen (opcional)
y la información detallada de cada una de los temas que componen la lista de reproducción,
mostrando la URL o el link al archivo de descarga. Si el Cliente tiene una suscripción
en estado “vigente” el Sistema permite descargar
el archivo de música para ser escuchado off line, si existe.


--%>

