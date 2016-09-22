<%-- 
    Document   : OrdenarBuscar
    Created on : Oct 7, 2016, 11:12:30 PM
    Author     : DJA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                            <a href="/VerAlbum?album=${item[1]}&nick=${item[2]}">${item[0]} - ${item[3]}</a>
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
                                <c:when test="${item[1] == 'Defecto'}">
                                    <a href="/VerListaDefecto?lista=${item[0]}">${item[0]} - ${item[2]}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/VerListaParticular?lista=${item[0]}&nick=${item[3]}">${item[0]} - ${item[2]}</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
       