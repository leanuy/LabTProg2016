<%-- 
    Document   : Album
    Created on : Sep 15, 2016, 11:46:51 AM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery-3.1.0.min.js"></script>

    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div id="caja" class="col-lg-12">
                    <form action="/CrearAlbum" method="POST" class="form-horizontal" enctype="multipart/form-data">
                        <fieldset>
                            <div class="form-group <c:if test="${not empty error_nombre}">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Nombre*:</label>
                                    <div class="col-md-4">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="form-group <c:if test="${not empty error_orden}">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Orden*:</label>
                                    <div class="col-md-4">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="form-group <c:if test="${not empty error_duracion}">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Duración*:</label>
                                    <div class="col-md-4">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="form-group <c:if test="${not empty error_nombre}">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Url:</label>
                                    <div class="col-md-4">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Archivo</label>
                                    <div class="col-md-4">
                                        <input id="archivo" name="archivo" class="input-file" type="file">
                                    </div>
                                </div>
                                <table width>
                                    <thead>
                                    <th style="width:30px">Núm</th>
                                    <th>Nombre</th>
                                    <th style="width:50px">Duración</th>
                                    <th>tipo</th>
                                    <th>&nbsp;</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input id="tema_numero" class="form-control input-md" type="text"></td>
                                            <td><input id="tema_nombre" class="form-control input-md" type="text"></td>
                                            <td><input id="tema_duracion" class="form-control input-md" type="text"></td>
                                            <td><button class="btn btn-custom btn-sm round" onclick="formTemaWeb()" type="button"><i class="fa fa-globe"></i></button>&nbsp;
                                                <button class="btn btn-custom btn-sm round" onclick="formTemaArchivo()" type="button"><i class="fa fa-file"></i></button></td>
                                            <td><button class="btn btn-custom" onclick="agregarTema()" type="button">Agregar</button></td>
                                        </tr>
                                        <tr class="form-web" hidden>
                                            <td colspan="5"><span style="color:grey">URL:</span><input id="tema_web" class="form-control input-md" type="text"></td>
                                        </tr>
                                        <tr class="form-archivo" hidden>
                                            <td colspan="5"><input id="tema_archivo" class="form-control input-md" type="text"></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="form-group">
                                    <div class="col-md-4 col-md-offset-4">
                                        <button type="submit" name="submit" class="btn btn-custom">Aceptar</button>
                                    </div>
                                </div>

                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $.post("/AltaAlbum", function (data) {
                $(".caja").html(data);
            });
        </script>


</t:body>
