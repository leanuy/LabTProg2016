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
                <div class="col-lg-12">
                    <form action="/AltaAlbum/paso1" method="POST" class="form-horizontal">
                        <fieldset>
                            <div class="form-group <c:if test="${not empty error_nombre}==true">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Nombre*:</label>  
                                    <div class="col-md-4">
                                        <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
                                        <!--<span class="help-block">help</span>-->  
                                    </div>
                                </div>
                            <div class="form-group <c:if test="${not empty error_anio}==true">has-error</c:if>">
                                    <label class="col-md-4 control-label" for="textinput">Año*:</label>  
                                    <div class="col-md-4">
                                        <input id="anio" name="anio" type="number" min="0" placeholder="" class="form-control input-md">
                                        <!--<span class="help-block">help</span>-->  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Imágen</label>
                                    <div class="col-md-4">
                                        <input id="imagen" name="imagen" class="input-file" type="file">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="filebutton">Géneros</label>
                                    <div class="col-md-4">
                                        <select name="generos" multiple="">
                                        <c:forEach items="${generos}" var="genero">
                                            <option value="${genero.value}">${genero.key}</option>
                                        </c:forEach>
                                        </select>
                                    </div>
                                </div>
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

</t:body>
