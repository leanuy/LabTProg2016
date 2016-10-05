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
    <script>
        $(document).ready(function () {
            $(".btn-mas-opciones-tema").click(function () {
                $(".btn-mas-opciones-tema").show(); //muestra los botones de ... ocultos
                $(".contenedor-opciones-tema").hide(); //oculta los paneles iguales al que quiere desplegar
                var nomTema = $(this).attr("data-nomTema");
                $(this).parent().parent().after('<div class="contenedor-opciones-tema"></div>');  //crea panel
                $.ajax({
                    type: "GET",
                    url: "/OpcionesTema?artista=${nomArtista}&album=${nomAlbum}&tema=" + nomTema,
                    success: function (msg) {
                        $(".contenedor-opciones-tema").html(msg);
                    }
                }); //busca datos del servlet y muestra panel
                $(this).hide(); //oculta botón de ...
            });
        });
    </script>

    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="col-"
            </div>
        </div>
    </div>

</t:body>
