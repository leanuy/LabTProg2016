<%-- 
    Document   : navbar
    Created on : Sep 13, 2016, 10:45:59 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="user" type="espotify.datatypes.DataUsuario"%>

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
            <a class="navbar-brand" href="#" style=" padding:5px;">
                <i class="fa fa-spotify default-color" style="font-size: 40px"></i>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left buscador">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-custom">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <% if(user == null){ %>
                <li><a href="#">Iniciar sesión</a></li>
                <% } else { %>
                <li class="dropdown menu-usuario">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="padding:10px 20px"><img src="<%= user.getImgUrl()%>" class="img-circle" style="width:30px;"> <%= user.getNick() %> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Favoritos</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Cerrar sesión</a></li>
                    </ul>
                </li>
                <% } %>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>