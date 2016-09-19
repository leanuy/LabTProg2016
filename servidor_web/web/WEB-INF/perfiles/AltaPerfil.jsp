<%-- 
    Document   : AltaPerfil
    Created on : Sep 17, 2016, 5:30:32 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway" rel="stylesheet"> 
    <script src="/assets/js/jquery-3.1.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#formulario").hide();
            $("#elegir_cliente").hide();
            $("#elegir_artista").hide();
            $("#passnotmatch").hide();
            
            $("#elegir_cliente").click(function(event){
                $("#formulario").show();
                $("#seleccion_tipo").hide();
                $("#exclusivos_artista").hide();
            });
            $("#elegir_artista").click(function(event){
                $("#formulario").show();
                $("#seleccion_tipo").hide();
                $("#exclusivos_artista").show();
            });
            $(".rig li").hover(
                function() {
                  $( this ).css("background", "#0198AD");
                }, function() {
                  $( this ).css("background", "#393B39");
                }
              );
      
            $("#submittear").click(function() {
                pass = $("#lg_password").val();
                confirm = $("#lg_passwordconfirm").val();
                if(pass===confirm) {
                    $("#passnotmatch").hide();
                    $("#registro-form").submit();
                } else {
                    $("#passnotmatch").show();
                }
                
            });
      
        });
    </script>
    <style>
        body{
            text-align: center;
        }
    </style>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-10 col-sm-offset-1 col-xs-12">
                <div class="text-center" style="padding:50px 0">
                    <h1><i class="fa fa-spotify default-color"></i>Espotify</h1>
                    <div class="logo"><h2>Crea tu cuenta</h2></div>
                    <!-- Main Form -->
                    <form id="registro-form" class="text-center" action="Registrarme" method="POST">
                        <div id="seleccion_tipo"> 
                            <ul class="rig columns-2">
                                <li>
                                    <input class="radioImg" type="radio" id="elegir_cliente" name="tipo" value="cliente">
                                    <label for="elegir_cliente">
                                        <image src="/assets/img/profile.png"/>
                                        <h3>Cliente</h3>
                                    </label>
                                </li>
                                <li>
                                    <input class="radioImg" type="radio" id="elegir_artista" name="tipo" value="artista">
                                    <label for="elegir_artista">
                                        <image src="/assets/img/artista.png"/>
                                        <h3>Artista</h3>
                                    </label>
                                </li>
                                
                                
                                
                            </ul>
                        </div>
                        <div id="formulario" class="registro-form-1">
                                <div class="registro-form-main-message"></div>
                                <div class="registro-login-form">
                                    <div class="registro-group">
                                        <div class="form-group">
                                            <label for="lg_username" class="sr-only">Username</label>
                                            <input type="text" class="form-control" id="lg_username" name="login" placeholder="nick">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_correo" class="sr-only">Correo electrónico</label>
                                            <input type="text" class="form-control" id="lg_correo" name="correo" placeholder="correo electrónico">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_password" class="sr-only">Password</label>
                                            <input type="password" class="form-control" id="lg_password" name="password" placeholder="contraseña">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_password_confirm" class="sr-only">Confirmación de Password</label>
                                            <input type="password" class="form-control" id="lg_passwordconfirm" name="password_confirm" placeholder="confirmar contraseña">
                                        </div>
                                        <div id="passnotmatch" class="alert alert-danger" role="alert">
                                            Las contraseñas no coinciden, intente nuevamente.
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_nombre" class="sr-only">Nombre</label>
                                            <input type="text" class="form-control" id="lg_nombre" name="nombre" placeholder="nombre">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_apellido" class="sr-only">Apellido</label>
                                            <input type="text" class="form-control" id="lg_apellido" name="apellido" placeholder="apellido">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_fecha" class="sr-only">Fecha de Nacimiento</label>
                                            <input type="text" class="form-control" id="lg_fecha" name="fechaNac" placeholder="fecha de nacimiento (dd/mm/aaaa)">
                                        </div>
                                        <div class="form-group">
                                            Imagen D:
                                        </div>
                                    </div>
                                    <div id="exclusivos_artista">
                                        <div class="form-group">
                                            <label for="lg_url" class="sr-only">URL</label>
                                            <input type="text" class="form-control" id="lg_url" name="url" placeholder="sitio web (opcional)">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_bio" class="sr-only">Biografía</label>
                                            <textarea class="form-control" style="height:200px" id="lg_bio" name="bio" placeholder="Biografía (opcional)"></textarea>
                                        </div>
                                    </div>
                                    <button id="submittear" class="btn btn-custom" type="button" value="Entrar" <%--onclick="submit()"--%>>Registrarme</button>
                                </div>
                        </div>
                    <!-- end:Main Form -->
                    </form>
         
                </div>
            </div>
        </div>
    </div>
    
</t:wrapper>