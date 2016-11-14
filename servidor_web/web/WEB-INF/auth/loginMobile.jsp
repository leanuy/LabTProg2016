<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway" rel="stylesheet"> 
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
                    <div class="logo"><h2>Iniciar sesión</h2></div>
                    <!-- Main Form -->
                    <div class="login-form-1">
                        <form id="login-form" class="text-center" action="login_mobile" method="POST">
                            <div class="login-form-main-message"></div>
                            <div class="main-login-form">
                                <div class="login-group">
                                    <div class="form-group">
                                        <label for="lg_username" class="sr-only">Username</label>
                                        <input type="text" class="form-control" id="lg_username" name="login" placeholder="usuario">
                                    </div>
                                    <div class="form-group">
                                        <label for="lg_password" class="sr-only">Password</label>
                                        <input type="password" class="form-control" id="lg_password" name="password" placeholder="contraseña">
                                    </div>
                                </div>
                                <button class="btn btn-custom" type="button" value="Entrar" onclick="submit()">Iniciar sesión</button>
                            </div>
                        </form>
                    </div>
                    <!-- end:Main Form -->
                </div>
            </div>
        </div>
    </div>

</t:wrapper>