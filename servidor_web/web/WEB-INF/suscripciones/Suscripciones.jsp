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
    <script>
        var bot = document.getElementById("botones_suscripcion");
        bot.hide();
    </script>
    <div>
        <h4>Suscripcion Actual</h4><br>
        <ul>
            <c:choose>
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
                    <c:forEach items="${suscripciones}" var="item">
                        <li>
                            <p>Fecha creacion: ${item.FechaCreacion}    Estado: ${item.Estado} Tipo: ${item.Tipo}</p>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h6>No tiene suscripciones anteriores</h6>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</t:body>