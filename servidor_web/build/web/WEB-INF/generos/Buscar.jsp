<%-- 
    Document   : buscar
    Created on : Sep 22, 2016, 7:05:57 PM
    Author     : DJA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery.js"></script>
    <link rel="stylesheet" href="assets/css/busqueda.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css'>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js'></script>
    <script src="assets/js/busqueda.js"></script>
    <script>
        jQuery(document).ready(function() {
            jQuery('.tabs .tab-links a').on('click', function(e)  {
                var currentAttrValue = jQuery(this).attr('href');

                // Show/Hide Tabs
                jQuery('.tabs ' + currentAttrValue).show().siblings().hide();

                // Change/remove current tab to active
                jQuery(this).parent('li').addClass('active').siblings().removeClass('active');

                e.preventDefault();
            });
        });
    </script>        
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row busqueda-header-container">         
                <div class="col-md-8">
                    <h1 class="busqueda-titulo">
                        Busqueda de: ${busqueda}
                    </h1>
                </div>
                    
                <div class="ordenar col-md-4">
                    <div class="ordenar-por">
                        Ordenar: 
                    </div>
                    <select class="selectpicker orden" data-url="/ordenar_busqueda">
                        <option value="alf">Alfabeticamente</option>
                        <option value="ano">Por año</option>
                    </select>
                    <div class="hidden busqueda-term" name="busqueda" value="${busqueda}"></div>
                </div>
            </div>
            <div class="row aca">             
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#tab1">Temas (<c:out value="${fn:length(temas)}"/>)</a></li>
                        <li><a href="#tab2">Albums (<c:out value="${fn:length(albums)}"/>)</a></li>
                        <li><a href="#tab3">Listas (<c:out value="${fn:length(listas)}"/>)</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab1" class="tab active">
                            <ul>
                                <c:forEach items="${temas}" var="item">
                                    <li>
                                        <a href="/VerAlbum?album=${item.item[1]}&nick=${item.item[2]}">${item.item[0]} - ${item.item[3]}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab2" class="tab">
                            <ul>
                                <c:forEach items="${albums}" var="item">
                                    <li>
                                        <a href="/VerAlbum?album=${item.getNombre()}&nick=${item.getNickArtista()}">${item.getNombre()} - ${item.getAnio()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab3" class="tab">
                            <ul>
                                <c:forEach items="${listas}" var="item">
                                    <li>
                                        <c:choose>
                                            <c:when test="${item.item[1] == 'Defecto'}">
                                                <a href="/VerListaDefecto?lista=${item.item[0]}">${item.item[0]} - ${item.item[2]}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/VerListaParticular?lista=${item.item[0]}&nick=${item.item[3]}">${item.item[0]} - ${item.item[2]}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:body>
