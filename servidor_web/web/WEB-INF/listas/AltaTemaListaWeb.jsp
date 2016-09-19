<%-- 
    Document   : AgregarTemaListaWeb
    Created on : Sep 17, 2016, 11:33:56 AM
    Author     : Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row"> 
                <h2> A que lista desea agregar el tema?</h2>
            </div>
            <div class="row">
                <c:forEach items="${listas}" var="item">
                    <li>
                        <a href="/AgregarTemaListaWeb?nick=${nickUsr}&tema=${item}&">${item}</a>
                    </li>
                </c:forEach>
            </div>
</t:body>
