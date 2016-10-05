<%-- 
    Document   : Bienvenida
    Created on : Oct 5, 2016, 6:35:45 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <h1>
                    Espotify
                </h1>
            </div>
            <div class="horizontalgap" style="height:10px"></div>
            <div class="row">       
                <table class="features-table">
                    <thead>
                      <tr>
                        <td></td>
                        <td>Visitante</td>
                        <td>Registrado</td>
                        <td>Suscriptor</td>
                      </tr>
                    </thead>       
                    <tbody>
                      <tr>
                        <td>Ver Perfiles</td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Reproduce música</td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Mira tus favoritos en un solo lugar</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Agrega nuevos ítems a tus favoritos</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Listas de reproducción personalizadas</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Comparte tus listas</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Sigue a los artistas y usuarios que más te importan</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                      <tr>
                        <td>Descarga temas y escúchalos en cualquier parte*</td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-remove"></i></td>
                        <td><i class="glyphicon glyphicon-ok"></i></td>
                      </tr>
                    </tbody>
                  </table>
                (*) solo disponible para algunos temas del sitio.
            </div>
            <div class="horizontalgap" style="height:10px"></div>
        </div>
    </div>
</t:body>