<%-- 
    Document   : Album
    Created on : Sep 15, 2016, 11:46:51 AM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div id="caja" class="col-lg-12">
                    <form action="/CrearAlbum" method="POST" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-1">
                                <div class="form-group <c:if test="${not empty error_orden}">has-error</c:if>">
                                        <input id="orden" name="nombre" type="text" placeholder="#*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group <c:if test="${not empty error_nombre}">has-error</c:if>">
                                        <input id="nombre" name="nombre" type="text" placeholder="Nombre*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group <c:if test="${not empty error_duracion}">has-error</c:if>">
                                        <input id="duracion" name="nombre" type="text" placeholder="Duración*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <span> Tipo:</span>
                                    <button type="button" class="btn btn-custom boton-web"><i class="fa fa-globe"></i></button>
                                    <button type="button" class="btn btn-custom boton-archivo"><i class="fa fa-file"></i></button>
                                </div>
                                <div class="col-md-2">
                                    <button type="button" name="submit" class="btn btn-custom" onclick="agregarTema()">Aceptar</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 form-web" hidden>
                                    <div class="form-group <c:if test="${not empty error_nombre}">has-error</c:if>">
                                        <label class="control-label" for="textinput">Url:</label>
                                        <input id="url" name="url" type="text" placeholder="" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-4 form-archivo" hidden>
                                    <div class="form-group">
                                        <label class="control-label" for="filebutton">Archivo</label>
                                        <input id="archivo" name="archivo" class="input-file" type="file">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <table width>
                                        <thead>
                                        <th style="width:30px">Núm</th>
                                        <th>Nombre</th>
                                        <th style="width:50px">Duración</th>
                                        <th>tipo</th>
                                        <th>&nbsp;</th>
                                        </thead>
                                        <tbody>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4 col-md-offset-4">
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
</t:body>
