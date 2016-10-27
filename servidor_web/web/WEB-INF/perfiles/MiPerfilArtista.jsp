<%-- 
    Document   : MiPerfilArtista
    Created on : Sep 15, 2016, 8:42:07 PM
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
                    <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${nick_sesion}&extra=null" class="image-circle"/> <%--imagen del cliente--%>
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
                        <li><a href="#albums">Álbums (<c:out value="${fn:length(albums)}"/>)</a></li>
                        <li><a href="#BajaPerfil">Baja Perfil </a></li>
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
                                            <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${item}&extra=null"  class="image-circle"/>
                                            <h3>${item}</h3>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="albums" class="tab">
                            <div class="row">
                                <div class="col-lg-12">
                                    <a class="btn btn-custom pull-right" style="padding-bottom:10px" href="/AltaAlbum/paso1">Crear Álbum</a>
                                </div>
                                <div class="col-lg-12">
                                    <ul class="rig columns-4">
                                        <c:forEach items="${albums}" var="item">
                                            <li>
                                                <a class="btn-link" href="/VerAlbum?nick=${nick}&amp;album=${item}">
                                                    <image src="/VerImagen?tipo=ImagenAlbum&nombreUsuario=${$nick}&extra=${item}" class="image-square"/>
                                                    <h3>${item}</h3>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="BajaPerfil" class="tab">
                            <h5>
                                ¿Está seguro que desea dar de baja su perfil?
                            </h5>
                            <br>
                                <ul class="rig columns-2">
                                    <a class="btn btn-custom" style="padding-bottom:5px" href="/BajaArtista?nick=${nick_sesion}">Dar de Baja</a>
                                </ul>
                            </br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</t:body>




<%--
Se muestran los nickname de todos los seguidores que tiene, si es cliente con suscripción
los usuarios a los que sigue (identificando si son clientes o artistas),
las listas de reproducción que creó y las preferencias que tiene guardadas,
brindando la opción de seleccionar uno para ver su detalle como en los casos de uso Consulta de Álbum,
y Consulta de Lista de Reproducción. Si es artista se listan los nombres de cada álbum que tenga registrado
y, para cualquier álbum que el usuario quiera, se visualizan los datos de éste de la misma forma que se hace
en Consulta de Álbum.--%>