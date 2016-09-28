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
                    <img src="/TraerImagenes?tipo=ImagenUsuario&nombreUsuario=${nick_sesion}" style="width:100%"> <%--imagen del artista--%>
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
                            <ul>
                                <c:forEach items="${seguidores}" var="item">
                                    <li>
                                        <a class="btn-link" href="/VerPerfil?nick=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="albums" class="tab">
                            <ul>
                                <c:forEach items="${albums}" var="item">
                                    <li>
                                        <a class="btn-link" href="/VerAlbum?nick=${nick}&amp;album=${item}">${item}</a>
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




<%--
Se muestran los nickname de todos los seguidores que tiene, si es cliente con suscripción
los usuarios a los que sigue (identificando si son clientes o artistas),
las listas de reproducción que creó y las preferencias que tiene guardadas,
brindando la opción de seleccionar uno para ver su detalle como en los casos de uso Consulta de Álbum,
y Consulta de Lista de Reproducción. Si es artista se listan los nombres de cada álbum que tenga registrado
y, para cualquier álbum que el usuario quiera, se visualizan los datos de éste de la misma forma que se hace
en Consulta de Álbum.--%>