<%-- 
    Document   : ListaParticular
    Created on : Sep 16, 2016, 11:26:41 AM
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
                var nomArtista = $(this).attr("data-nomArtista");
                var nomAlbum = $(this).attr("data-nomAlbum");

               $(this).parent().parent().after('<tr class="contenedor-opciones-tema" col-span="6"></tr>');  //crea panel
               $.ajax({
                    type: "GET",
                    url: "/OpcionesTema?artista="+nomArtista+"&album="+nomAlbum+"&tema="+nomTema,
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
                    <image src="/VerImagen?tipo=ImagenLista&nombreUsuario=${nick}&extra=${nomLista}" class="image-square" style="width:100%"/> <%--imagen del album--%>
                </div>
                <%--datos basicos--%>
                <div>
                    <h1>
                        <c:out value="${nomLista}"/>
                        <c:choose>
                            <c:when test="${esPrivada}">                            
                                <c:choose>
                                    <c:when test="${tiene_suscripcion}">
                                        <a class="btn btn-custom" href="/publicarlista?lista=<c:out value="${nomLista}"/>"><i class="glyphicon glyphicon-lock"></i> Publicar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </h1>
                    <div class="pull-right">
                        <c:choose>
                            <c:when test="${not empty es_favorito}">
                                <c:choose>
                                    <c:when test="${es_favorito}">
                                        <a class="btn-link-inverse" href="/DesFavoritear?tipo=particular&lista=${nomLista}&nick=${nomCliente}"><i class="glyphicon glyphicon-star"></i></a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${tiene_suscripcion}">
                                                <a class="btn-link" href="/Favoritear?tipo=particular&lista=${nomLista}&nick=${nomCliente}"><i class="glyphicon glyphicon-star"></i></a>
                                            </c:when>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
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
                                <td>
                                    <c:choose>
                                        <c:when test="${not tema.esWeb}">
                                            <button class="btn btn-link btn-lg btnTema" data-artista="${tema.nomArtista}" data-album="${tema.album}" data-tema="${tema.nombre}">
                                                <i class="glyphicon glyphicon-play-circle"></i>
                                            </button>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td><c:out value="${temaStatus.index+1}"/></td>
                                <td><c:out value="${tema.nombre}"/></td>
                                <td class="hidden-xs"><c:out value="${tema.duracionStr}"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty es_favorito}">
                                            <c:choose>
                                                <c:when test="${es_favorito_temas[temaStatus.index]}">
                                                    <a class="btn btn-link-inverse pull-left" href="/DesFavoritear?tipo=tema&artista=${tema.nomArtista}&album=${tema.album}&tema=${tema.nombre}"><i class="glyphicon glyphicon-star"></i></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${tiene_suscripcion}">
                                                            <a class="btn btn-link pull-left" href="/Favoritear?tipo=tema&artista=${tema.nomArtista}&album=${tema.album}&tema=${tema.nombre}"><i class="glyphicon glyphicon-star"></i></a>
                                                        </c:when>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <button class="btn btn-link pull-right btn-mas-opciones-tema" data-nomArtista="${tema.nomArtista}" data-nomAlbum="${tema.album}" data-nomTema="${tema.nombre}"><i class="glyphicon glyphicon-option-horizontal"></i></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
</t:body>


