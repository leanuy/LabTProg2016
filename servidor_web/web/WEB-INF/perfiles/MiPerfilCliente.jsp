<%-- 
    Document   : MiPerfilCliente.jsp
    Created on : Sep 15, 2016, 7:47:21 PM
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
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12" style="width:150px;height:150px;overflow:hidden">
                    <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${nick_sesion}&extra=null" class="img-circle" style="width:100%"/> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                </h1>
            </div>
            <div class="horizontalgap" style="height:10px"></div>
            <div class="row">
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#datosPersonales">Datos Personales</a></li>
                        <li><a href="#seguidores">Seguidores (<c:out value="${fn:length(seguidores)}"/>)</a></li>
                        <li><a href="#siguiendo">Siguiendo (<c:out value="${fn:length(seguidos)}"/>)</a></li>
                        <li><a href="#listas">Listas (<c:out value="${fn:length(listasPub)+fn:length(listasPriv)}"/>)</a></li>
                        <li><a href="#favoritos">Favoritos</a></li>
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
                            </ul>
                        </div>
                        <div id="seguidores" class="tab">
                            <ul class="rig columns-4">
                            <c:forEach items="${seguidores}" var="item">
                                <li>
                                    <a class="btn-link" href="/VerPerfil?nick=${item}">
                                        <image src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item}&extra=null"/>
                                        <h3>${item}</h3>
                                    </a>
                                </li>
                            </c:forEach>
                            </ul>
                        </div>
                        <div id="siguiendo" class="tab">
                            <ul class="rig columns-4">
                                <c:forEach items="${seguidos}" var="item">
                                    <li>
                                        <a class="btn-link" href="/VerPerfil?nick=${item}">
                                            <image src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item}&extra=null"/>
                                            <h3>${item}</h3>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="listas" class="tab">
                            <a class="btn btn-custom pull-right" style="padding-bottom:10px" href="/crearlistaparticular">Crear lista</a>
                            <ul>
                                <c:forEach items="${listasPub}" var="item">
                                    <li>
                                        <image src="/VerImagen?tipo=ImagenLista&nombreUsuario=${nick}&extra=${item}"/>
                                        <a class="btn-link" href="/VerListaParticular?nick=${nick}&lista=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                                <c:forEach items="${listasPriv}" var="item">
                                    <li>
                                        <a class="btn-link" href="/VerListaParticular?nick=${nick}&lista=${item}">${item}
                                            <image src="/VerImagen?tipo=ImagenLista&nombreUsuario=${nick}&extra=${item}"/>
                                            <h3>${item.nombre}</h3>
                                        <i class="glyphicon glyphicon-lock"></i></a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="favoritos" class="tab">
                            <table class="table">
                                <tbody>
                                    <c:forEach items="${albumsFavoritos}" var="item">
                                        <tr>
                                            <td>
                                                <a class="btn-link" href="/VerAlbum?nick=${item.nickArtista}&amp;album=${item.nombre}">
                                                    <i class="glyphicon glyphicon-cd"></i> ${item.nickArtista} - ${item.nombre}
                                                </a>
                                            </td>
                                            <td><a class="btn-link-inverse pull-left" href="/DesFavoritear?tipo=album&artista=${item.nickArtista}&album=${item.nombre}"><i class="glyphicon glyphicon-star"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach items="${particularesFavoritas}" var="item">
                                        <tr>
                                            <td>
                                                <a class="btn-link" href="/VerListaParticular?nick=${item.nomCliente}&amp;lista=${item.nombre}">
                                                    <i class="glyphicon glyphicon-list-alt"></i> ${item.nomCliente} - ${item.nombre}
                                                </a>
                                            </td>
                                            <td><a class="btn-link-inverse pull-left" href="/DesFavoritear?tipo=particular&lista=${item.nombre}&nick=${item.nomCliente}"><i class="glyphicon glyphicon-star"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach items="${defectoFavoritas}" var="item">
                                        <tr>
                                            <td>
                                                <a class="btn-link" href="/VerListaDefecto?lista=${item.nombre}">
                                                    <i class="glyphicon glyphicon-list-alt"></i> ${item.nombre} (${item.genero})
                                                </a>
                                            </td>
                                            <td><a class="btn-link-inverse pull-left" href="/DesFavoritear?tipo=defecto&lista=${item.nombre}"><i class="glyphicon glyphicon-star"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <c:forEach items="${temasFavoritos}" var="item">
                                        <tr>
                                            <td>
                                                <a class="btn-link" href="#">
                                                    <i class="glyphicon glyphicon-music"></i> ${item.nomArtista} - ${item.album} - ${item.nombre}
                                                </a>
                                            </td>
                                            <td><a class="btn-link-inverse pull-left" href="/DesFavoritear?tipo=tema&artista=${item.nomArtista}&album=${item.album}&tema=${item.nombre}"><i class="glyphicon glyphicon-star"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:body>