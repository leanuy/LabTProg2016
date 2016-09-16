<%-- 
    Document   : MiPerfilCliente.jsp
    Created on : Sep 15, 2016, 7:47:21 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <script src="assets/js/jquery-3.1.0.min.js"></script>
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
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                </h1>
            </div>
            <div class="row">
                <div class="tabs">
                    <ul class="tab-links">
                        <li class="active"><a href="#tab1">Datos Personales</a></li>
                        <li><a href="#tab2">Seguidores (<c:out value="${fn:length(seguidores)}"/>)</a></li>
                        <li><a href="#tab3">Siguiendo (<c:out value="${fn:length(seguidos)}"/>)</a></li>
                        <li><a href="#tab4">Listas</a></li>
                        <li><a href="#tab5">Favoritos</a></li>
                    </ul>
                
                    <div class="tab-content">
                        <div id="tab1" class="tab active">
                            <ul>
                                <li>
                                    <i class="glyphicon glyphicon-user"></i>
                                    <c:out value="${nombre}"/> <c:out value="${apellido}"/>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-envelope"></i>
                                    <c:out value="${correo}"/>
                                </li>
                                <li>
                                    <i class="glyphicon glyphicon-calendar"></i>
                                    <c:out value="${fechaNac}"/>
                                </li>
                            </ul>
                        </div>
                        <div id="tab2" class="tab">
                            <ul>
                            <c:forEach items="${seguidores}" var="item">
                                <li>
                                    <a class="link-user" href="/VerPerfil?nick=${item}">${item}</a>
                                </li>
                            </c:forEach>
                            </ul>
                        </div>
                        <div id="tab3" class="tab">
                            <ul>
                                <c:forEach items="${seguidos}" var="item">
                                    <li>
                                        <a class="link-user" href="/VerPerfil?nick=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab4" class="tab">
                            <ul>
                                <c:forEach items="${listasPub}" var="item">
                                    <li>
                                        <a class="" href="/VerListaParticular?nick=${nick}&lista=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                                <c:forEach items="${listasPriv}" var="item">
                                    <li>
                                        <i class="glyphicon glyphicon-lock"></i>
                                        <a class="" href="/VerListaParticular?nick=${nick}&lista=${item}">${item}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div id="tab5" class="tab">
                            No implementado D:
                            <%--<c:forEach items="${listas}" var="item">
                                ${item}<br/>
                            </c:forEach>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</t:body>




<%--
nickname, correo electrónico, nombre, apellido, fecha de nacimiento e imagen (opcional)
Se muestran los nickname de todos los seguidores que tiene, si es cliente con suscripción los usuarios a los que sigue (identificando si son clientes o artistas),
las listas de reproducción que creó y las preferencias que tiene guardadas, brindando la opción de seleccionar uno para ver su detalle como en los casos de uso Consulta de Álbum, y Consulta de Lista de Reproducción.--%>