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
                <h2>Agregar temas a <c:out value="${album}" /></h2>
                <div id="caja" class="col-lg-12">
                    <div class="alert alert-danger" role="alert" hidden><span class="help"></span></div>
                </div>
                <div id="caja" class="col-lg-12">
                    <form id="form-tema" action="/CrearAlbum" method="POST" enctype="multipart/form-data">
                        <input id="album" name="album" value="<c:out value="${album}" />" hidden>
                        <input id="tipo" name="tipo" value="" hidden>
                        <div class="row">
                            <div class="col-md-1">
                                <div class="form-group <c:if test="${not empty error_orden}">has-error</c:if>">
                                        <input id="orden" name="orden" type="text" placeholder="#*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group <c:if test="${not empty error_nombre}">has-error</c:if>">
                                        <input id="nombre" name="nombre" type="text" placeholder="Nombre*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group <c:if test="${not empty error_duracion}">has-error</c:if>">
                                        <input id="duracion" name="duracion" type="text" placeholder="Duración*" class="form-control input-md">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <span> Tipo:</span>
                                    <button type="button" class="btn btn-custom boton-web"><i class="fa fa-globe"></i></button>
                                    <button type="button" class="btn btn-custom boton-archivo"><i class="fa fa-file"></i></button>
                                </div>
                                <div class="col-md-2">
                                    <button type="button" id="agregar" class="btn btn-custom">Agregar</button>
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
                                    <table width="100%">
                                        <thead>
                                        <th width="50px">#</th>
                                        <th>Nombre</th>
                                        <th width="100px">Duración</th>
                                        <th width="30px">tipo</th>
                                        <th width="20px">&nbsp;</th>
                                        </thead>
                                        <tbody class="temas">
                                            <tr class="tema" hidden>
                                                <td class="orden"></td>
                                                <td class="nombre"></td>
                                                <td class="duracion"></td>
                                                <td class="tipo"></td>
                                                <td class="tools"><button class="btn btn-link delete-tema" type="button"><i class="fa fa-trash"></i></button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" style="text-align:center">
                                    <button class="btn btn-custom aceptar" type="button">Aceptar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</t:body>
