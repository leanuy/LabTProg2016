<%-- 
    Document   : sidebar
    Created on : Sep 13, 2016, 11:00:12 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="user" type="espotify.Datatypes.DataUsuario"%>

<div class="menu-izquierda col-lg-2 col-md-2 hidden-sm hidden-xs">
    <div class="row">
        <ul class="list-group">
            <li class="list-group-item"><i class="glyphicon glyphicon-cd"></i> Géneros</li>
            <li class="list-group-item"><i class="glyphicon glyphicon-user"></i> Artistas</li>

        </ul>
    </div>
</div>
<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
    <div class="row reproductor">

        <div class="col-lg-12 hidden-sm hidden-xs"><img src="assets/img/cover.jpg" style="width:100%"></div>
        <div class="col-lg-12">nombre cancion</div>
        <div class="col-lg-12">nombre artista</div>
        <div class="col-lg-12">
            <div class="progress" style=" height:7px">
                <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="row">
                <div class="col-xs-4">
                    <button class="btn btn-link btn-md">
                        <i class="glyphicon glyphicon-step-backward"></i>
                    </button>
                </div>
                <div class="col-xs-4">
                    <button class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-play"></i>
                    </button>
                </div>
                <div class="col-xs-4">
                    <button class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-step-forward"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>