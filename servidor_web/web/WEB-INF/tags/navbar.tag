<%-- 
    Document   : navbar
    Created on : Sep 13, 2016, 10:45:59 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="user" type="servidor.DataUsuario"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/inicio" style=" padding:5px;">
                <i class="fa fa-spotify default-color" style="font-size: 40px"></i>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left buscador" action="Buscar">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Buscar" name="busqueda">
                    <input type="text" class="hidden" value="alf" name="sort">
                </div>
                <button type="submit" class="btn btn-custom">Buscar</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty nick_sesion}">
                        <li><a href="/inicio">Iniciar sesión</a></li>
                    </c:when>    
                    <c:otherwise>
                        <li class="dropdown menu-usuario">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="padding:10px 20px">
                                <img src="/VerImagen?tipo=ImagenUsuario&nombreUsuario=${nick_sesion}&extra=null" class="image-circle" style="width:30px; height:30px;">
                                <c:out value="${nick_sesion}"/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/MiPerfil">Mi Perfil</a></li>
                                <c:choose>
                                    <c:when test="${not empty es_cliente and es_cliente}">
                                        <li><a href="/Suscripcion">Suscripción</a></li>
                                    </c:when>
                                </c:choose>
                                <li class="hidden-lg hidden-md divider" role="separator" class="divider"></li>
                                <li class="hidden-lg hidden-md"><a class="btn-link-sidebar" href="/Sugerencias">Sugerencias</a></li>
                                <li class="hidden-lg hidden-md"><a class="btn-link-sidebar" href="/VerGenero?genero=Genero">Géneros</a></li>
                                <li class="hidden-lg hidden-md"><a class="btn-link-sidebar" href="/Artistas">Artistas</a></li>
                                <li class="hidden-lg hidden-md"><a class="btn-link-sidebar" href="/Clientes">Clientes</a></li>
                                <li class="hidden-lg hidden-md"><a class="btn-link-sidebar" href="/Ranking">Ranking</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/cerrar-sesion">Cerrar sesión</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>