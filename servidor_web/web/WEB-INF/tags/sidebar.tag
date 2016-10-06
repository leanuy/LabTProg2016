<%-- 
    Document   : sidebar
    Created on : Sep 13, 2016, 11:00:12 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="user" type="espotify.datatypes.DataUsuario"%>

<div class="menu-izquierda col-lg-2 col-md-2 hidden-sm hidden-xs">
    <div class="row">
        <ul class="list-group">
            <li class="list-group-item"><i class="glyphicon glyphicon-cd"></i> <a class="btn-link-sidebar" href="/VerGenero?genero=Genero">Géneros</a></li>
            <li class="list-group-item"><i class="glyphicon glyphicon-user"></i> <a class="btn-link-sidebar" href="/Artistas">Artistas</a></li>
            <li class="list-group-item"><i class="glyphicon glyphicon-user"></i> <a class="btn-link-sidebar" href="/Clientes">Clientes</a></li>
        </ul>
    </div>
</div>
<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
    <div class="row reproductor">

        <div id="nowPlay" style="margin:10px 0px">
            <div id="auTitle">---</div>
        </div>
        <audio id="aurepr" preload="auto" controls onended="get_next(1)"></audio>
        <div id="auExtraControls">
            <button id="btnPrev" class="ctrlbtn" onclick="get_next(-1);">
                <i class="fa fa-step-backward fa-2x" aria-hidden="true"></i>
            </button>
            <button id="btnNext" class="ctrlbtn" onclick="get_next(1);">
                <i class="fa fa-step-forward fa-2x" aria-hidden="true"></i>
            </button>
        </div>
        
        
        <div class="col-lg-12 hidden-sm hidden-xs"><img id="trackImage" src="assets/img/cover.jpg" style="width:100%"></div>
        <div id="TemaReproduccion" class="col-lg-12">---</div>
        <div  class="col-lg-12"><span id="ArtistaReproduccion"></span> - <span id="AlbumReproduccion"></span></div>
        <!--<div class="col-lg-12">
            <div class="progress" style=" height:7px">
                <div class="progress-bar progress-bar-custom progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
                </div>
            </div>
        </div>-->
        <div class="col-lg-12">
            <div class="row">
                <div class="col-xs-4">
                    <button class="btn btn-link btn-md" onclick="get_next(-1);">
                        <i class="glyphicon glyphicon-step-backward"></i>
                    </button>
                </div>
                <div class="col-xs-4">
                    <button class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-play"></i>
                    </button>
                </div>
                <div class="col-xs-4">
                    <button class="btn btn-link  btn-md" onclick="get_next(1);">
                        <i class="glyphicon glyphicon-step-forward"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>