<%-- 
    Document   : Suscripciones
    Created on : Sep 19, 2016, 5:26:38 PM
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
<<<<<<< HEAD
=======
    
    <script>
        var bot = document.getElementById("botones_suscripcion");
        bot.hide();
    </script>
>>>>>>> b9b112ca6a0c64543b8e2e972e301d112bd8c99a
    <div>
        <h4>Suscripcion Actual</h4><br>
        <ul>
            <c:choose>
<<<<<<< HEAD
                <c:when test="${not empty suscvigente}">
                    <c:choose>
                        <c:when test="${not empty vigente and vigente}">
                            <li>
                                <p>Fecha creacion: ${suscvigente.fCreacionStr} Estado: ${suscvigente.estado} Tipo: ${suscvigente.tipo} Vencimiento: ${suscvigente.fVenStr}</p>
                            </li>
                        </c:when>
                        <c:when test="${not empty pendiente and pendiente}">
                            <li>
                                <p>Fecha creacion: ${suscvigente.fCreacionStr}    Estado: ${suscvigente.estado} Tipo: ${suscvigente.tipo}</p>
                            </li>
                            <p>Suscripcion pendiente de aprobacion, puede cancelarla si asi lo desea</p>
                            <form action="/CancelarSuscripcion" method="POST">
                                <button class="btn btn-custom" type="submit" name="cancelar" value="${nick_sesion}">Cancelar</button>
                            </form>
                        </c:when>
                        <c:when test="${not empty vencida and vencida}">
                            <li>
                                <p>Fecha creacion: ${suscvigente.fCreacionStr}    Estado: ${suscvigente.estado} Tipo: ${suscvigente.tipo}</p>
                            </li>
                            <p>La suscripcion se encuentra vencida, puede renovar o cancelar</p>
                            <form action="/RenovarSuscripcion" method="POST">
                                <button class="btn btn-custom" type="submit" name="renovar" value="${nick_sesion}">Renovar</button>
                            </form>
                            <form action="/CancelarSuscripcion" method="POST">
                                <button class="btn btn-custom" type="submit" name="cancelar" value="${nick_sesion}">Cancelar</button>
                            </form>
                        </c:when>                        
                    </c:choose>
                </c:when>                        
                <c:otherwise>
                    <p>No tiene suscripcion actual</p><br>
                    <p>Suscribase!</p>
                    <div>
                        <form action="/Suscripcion" method="POST">
                            <select name="tipo">
                                <option value="semanal">Semanal USD 3</option>
                                <option value="mensual">Mensual USD 10</option>
                                <option value="anual">Anual USD 100</option>
=======
                <c:when test="${not empty vigente}">
                        <li>
                            <p>Fecha creacion: ${vigente.FechaCreacion}    Estado: ${vigente.Estado} Tipo: ${vigente.Tipo}</p>
                        </li>
                </c:when>
                <c:otherwise>
                    <h6>No tiene suscripcion actual</h6><br>
                    <h6>Suscribase!</h6>
                    <div>
                        <form action="/Suscripcion.jsp" method="POST">
                            <select name="tipo">
                                <option value="semanal">Semanal</option>
                                <option value="mensual">Mensual</option>
                                <option value="anual">Anual</option>
>>>>>>> b9b112ca6a0c64543b8e2e972e301d112bd8c99a
                            </select>
                            <button class="btn btn-custom" type="submit">Suscribirse!</button> 
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </ul>
<<<<<<< HEAD
        <br>        
=======
        <br>
        
>>>>>>> b9b112ca6a0c64543b8e2e972e301d112bd8c99a
    </div>
    <br>
    <div>
        <h4> Historial </h4><br>
        <ul>
            <c:choose>
                <c:when test="${not empty historial}">
<<<<<<< HEAD
                    <c:forEach items="${historial}" var="item">
                        <li>
                            <p>Fecha creacion: ${item.fCreacionStr}    Estado: ${item.estado} Tipo: ${item.tipo}</p>
=======
                    <c:forEach items="${suscripciones}" var="item">
                        <li>
                            <p>Fecha creacion: ${item.FechaCreacion}    Estado: ${item.Estado} Tipo: ${item.Tipo}</p>
>>>>>>> b9b112ca6a0c64543b8e2e972e301d112bd8c99a
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
<<<<<<< HEAD
                    <p>No tiene suscripciones anteriores</p>
=======
                    <h6>No tiene suscripciones anteriores</h6>
>>>>>>> b9b112ca6a0c64543b8e2e972e301d112bd8c99a
                </c:otherwise>
            </c:choose>
        </ul>
    </div>    
</t:body>