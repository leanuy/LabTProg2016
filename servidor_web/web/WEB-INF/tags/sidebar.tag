<%-- 
    Document   : sidebar
    Created on : Sep 13, 2016, 11:00:12 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="user" type="espotify.datatypes.DataUsuario"%>

<script src="assets/js/jquery-3.1.0.min.js"></script>
<script>
    var idxTrack=0;
    var tracks = [];
    
    function ActualizarLista() {
        var content = "";
        for (i=idxTrack; i<tracks.length;i++) {
            if(i===idxTrack) {
                content+="<li><i class='glyphicon glyphicon-play'></i> "+tracks[i][0]+" - "+tracks[i][2]+"</li>";
            } else {
                content+="<li>"+tracks[i][0]+" - "+tracks[i][2]+"</li>";
            }
        }
        $("#listatemas").html(content);
    }
    
    function ReproducirTema(){
        MostrarInfoTema(idxTrack);
        ActualizarLista();
        var art = tracks[idxTrack][0];
        var alb = tracks[idxTrack][1];
        var tem = tracks[idxTrack][2];
        var repr = document.getElementById("aurepr");
        repr.pause();
        repr.currentTime=0;
        $("#aurepr").attr("src", "/Escuchar?artista="+art+"&album="+alb+"&tema="+tem);
        repr.load();
        repr.play();
    };
    
    function reproducirSiguiente() {
        if(idxTrack+1===tracks.length) {
            tracks=[];
            idxTrack=0;
            document.getElementById("aurepr").pause();
            $(".reproductor").hide();
        } else {
            idxTrack++;
            ReproducirTema();
        }
    }
    
    function MostrarInfoTema() {
        var art = tracks[idxTrack][0];
        var alb = tracks[idxTrack][1];
        var tem = tracks[idxTrack][2];
        $("#ArtistaReproduccion").html(art);
        $("#AlbumReproduccion").html(alb);
        $("#TemaReproduccion").html(tem);
        $("#trackImage").attr("src","/VerImagen?tipo=ImagenAlbum&nombreUsuario="+art+"&extra="+alb);
    }
    
    function agregarTema(art,alb,tem) {
        $(".reproductor").show();
        tracks[tracks.length]=[art,alb,tem];
        if(tracks.length===1) {
            ReproducirTema();
        } else {
            ActualizarLista();
        }
    }
    
    $(document).ready( function(){
        $(".reproductor").hide();
        //$("#aurepr").hide();
        $("#playbtn").hide();
        $("#playbtn").click(function() {
            if(idxTrack<=tracks.length) {
                $("#playbtn").hide();
                $("#pausebtn").show();
                repr = document.getElementById("aurepr");
                if(repr.paused) {
                    repr.play();
                }
            }
        });
        $("#pausebtn").click(function() {
            if(idxTrack<=tracks.length) {
                $("#pausebtn").hide();
                $("#playbtn").show();
                repr = document.getElementById("aurepr");
                if(! repr.paused) {
                    repr.pause();
                }
            }
        });
        $("#skipbtn").click( function() {reproducirSiguiente();});
                
        $(".btnTema").click(function() {
            var art = $(this).attr("data-artista");
            var alb = $(this).attr("data-album");
            var tem = $(this).attr("data-tema");
            agregarTema(art,alb,tem);
        });
        
    });    
</script>


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

        <audio id="aurepr" preload="auto" controls onended="reproducirSiguiente()"></audio>
        
        <ul id="listatemas">
            
        </ul>
        
        
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
                    <button id="playbtn" class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-play"></i>
                    </button>
                    <button id="pausebtn" class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-pause"></i>
                    </button>
                </div>
                <div class="col-xs-4">
                    <button id="skipbtn" class="btn btn-link  btn-md">
                        <i class="glyphicon glyphicon-step-forward"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>