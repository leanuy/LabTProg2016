<%-- 
    Document   : Album
    Created on : Sep 15, 2016, 11:46:51 AM
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
                    <h1><c:out value="${nomAlbum}"/></h1>
                    <div><c:out value="${nomArtista}"/></div>
                    <div><c:out value="${anio}"/></div>
                </div>
                <%--generos--%>
                <div class="pull-right">
                    <h4>Géneros</h4>
                    <c:forEach items="${generos}" var="item">
                        <a href="#" class="btn btn-inverse btn-sm round">${item}</a>
                    </c:forEach>
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
                        <c:forEach items="${temas}" var="tema">
                            <tr>
                                <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                                <td><c:out value="${tema.num}"/></td>
                                <td><c:out value="${tema.nombre}"/></td>
                                <td class="hidden-xs"><c:out value="${tema.duracionStr}"/></td>
                                <td><button class="btn btn-link pull-left"><i class="glyphicon glyphicon-star"></i></button></td>
                                <td><button class="btn btn-link pull-right "><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
</t:body>


<%-- Luego, el sistema muestra el nombre del álbum, año de creación, 
los géneros a los que aplica, su imagen (opcional)
y la información detallada de cada una de los temas que componen el álbum,
mostrando la URL o el link al archivo de descarga.

Si el Cliente tiene una suscripción en estado “vigente”
el Sistema permite descargar el archivo de música para ser escuchado off line, si existe.



--%>
