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
    <div>
        <h4>Suscripcion Actual</h4><br>
        <ul>
            <c:choose>
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
                            </select>
                            <button class="btn btn-custom" type="submit">Suscribirse!</button> 
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </ul>
        <br>        
    </div>
    <br>
    <div>
        <h4> Historial </h4><br>
        <ul>
            <c:choose>
                <c:when test="${not empty historial}">
                    <c:forEach items="${historial}" var="item">
                        <li>
                            <p>Fecha creacion: ${item.fCreacionStr}    Estado: ${item.estado} Tipo: ${item.tipo}</p>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>No tiene suscripciones anteriores</p>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>    
</t:body>