<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="row">
        <div class="col-lg-12">
            <h2 style="text-align:center">Crear lista particular</h2>
            <c:if test="${not empty error_nombre}==true">
                <div class="alert alert-danger" role="alert">
                    <strong>El formulario no se ha completado correctamente:</strong> <br />
                    <c:out value="${error_nombre}" />
                </div>
            </c:if>
            <form action="/crearlistaparticular" method="POST" class="form-horizontal"  enctype="multipart/form-data">
                <fieldset>
                    <div class="form-group <c:if test="${not empty error_nombre}==true">has-error</c:if>">
                        <label class="col-md-4 control-label" for="textinput">Nombre*:</label>  
                        <div class="col-md-4">
                            <input id="nombre" name="nombre" type="text" placeholder="" class="form-control input-md">
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
                        <div class="col-md-4 col-md-offset-4">
                            <button type="submit" name="submit" class="btn btn-custom">Aceptar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </div>
</t:body>
