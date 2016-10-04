<%-- 
    Document   : Album
    Created on : Sep 15, 2016, 11:46:51 AM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery-3.1.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".btn-mas-opciones-tema").click(function() {
                $(".btn-mas-opciones-tema").show(); //muestra los botones de ... ocultos
                $(".contenedor-opciones-tema").hide(); //oculta los paneles iguales al que quiere desplegar
                var nomTema = $(this).attr("data-nomTema");
               $(this).parent().parent().after('<div class="contenedor-opciones-tema"></div>');  //crea panel
               $.ajax({
                    type: "GET",
                    url: "/OpcionesTema?artista=${nomArtista}&album=${nomAlbum}&tema="+nomTema,
                    success: function(msg) {
                        $(".contenedor-opciones-tema").html(msg);
                    }
                }); //busca datos del servlet y muestra panel
                $(this).hide(); //oculta botón de ...
            });
        });
    </script>
    
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del album--%>
                </div>
                <%--datos basicos--%>
                <div>
                    <h1><c:out value="${nomAlbum}"/></h1>
                    <div class="pull-right">
                        <c:choose>
                            <c:when test="${not empty es_favorito}">
                                <c:choose>
                                    <c:when test="${es_favorito}">
                                        <a class="btn-link-inverse" href="/DesFavoritear?tipo=album&artista=${nomArtista}&album=${nomAlbum}"><i class="glyphicon glyphicon-star"></i></a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${tiene_suscripcion}">
                                                <a class="btn-link" href="/Favoritear?tipo=album&artista=${nomArtista}&album=${nomAlbum}"><i class="glyphicon glyphicon-star"></i></a>
                                            </c:when>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </div>
                    <div><i class="glyphicon glyphicon-user"></i> <c:out value="${nomArtista}"/></div>
                    <div><i class="glyphicon glyphicon-calendar"></i> <c:out value="${anio}"/></div>
                </div>
                <%--generos--%>
                <div class="pull-right">
                    <h4>Géneros</h4>
                    <c:forEach items="${generos}" var="item">
                        <a href="/VerGenero?genero=${item}" class="btn btn-inverse btn-sm round">${item}</a>
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
                        <c:forEach items="${temas}" var="tema" varStatus="temaStatus">
                            <tr>
                                <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                                <td><c:out value="${tema.num}"/></td>
                                <td><c:out value="${tema.nombre}"/></td>
                                <td class="hidden-xs"><c:out value="${tema.duracionStr}"/></td>
                                <td>
                                    <!--favoritos-->
                                    <c:choose>
                                        <c:when test="${empty es_favorito}">
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${es_favorito_temas[temaStatus.index]}">
                                                    <a class="btn btn-link-inverse pull-left" href="#"><i class="glyphicon glyphicon-star"></i></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="btn btn-link pull-left" href="/Favoritear?tipo=tema&artista=${nomArtista}&album=${nomAlbum}&tema=${tema.nombre}"><i class="glyphicon glyphicon-star"></i></a>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <button class="btn btn-link pull-right btn-mas-opciones-tema" data-nomTema="${tema.nombre}"><i class="glyphicon glyphicon-option-horizontal"></i></button>
                                </td>
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

