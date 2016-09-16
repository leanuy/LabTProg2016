<%-- 
    Document   : MiPerfilCliente.jsp
    Created on : Sep 15, 2016, 7:47:21 PM
    Author     : JavierM42
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">         
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del cliente--%>
                </div>
                <h1>
                    <c:out value="${nick}"/>
                </h1>
                <p>
                    <i class="glyphicon glyphicon-user"></i>
                    <c:out value="${nombre}"/> <c:out value="${apellido}"/>
                </p>
                <p>
                    <i class="glyphicon glyphicon-envelope"></i>
                    <c:out value="${correo}"/>
                </p>
                <p>
                    <i class="glyphicon glyphicon-calendar"></i>
                    <c:out value="${fechaNac}"/>
                </p>
                <div>
                    <h2>
                        Tus Seguidores
                    </h2>
                    <c:forEach items="${seguidores}" var="item">
                        <a href="/VerPerfil?nick=${item}">${item}</a>
                        <br>
                    </c:forEach>
                </div>
                <div>
                    <h2>
                        Sigues a
                    </h2>
                    <c:forEach items="${seguidos}" var="item">
                        <a href="/VerPerfil?nick=${item}">${item}</a>
                        <br>
                    </c:forEach>
                </div>
                <div>
                    <h2>
                        Tus Listas Públicas
                    </h2>
                    <c:forEach items="${listasPub}" var="item">
                        ${item}<br/>
                    </c:forEach>
                </div>
                <div>
                    <h2>
                        Tus Listas Privadas
                    </h2>
                    <c:forEach items="${listasPriv}" var="item">
                        ${item}<br/>
                    </c:forEach>
                </div>
                <div>
                    <h2>
                        Tus Favoritos
                    </h2>
                    <%--<c:forEach items="${listas}" var="item">
                        ${item}<br/>
                    </c:forEach>--%>
                </div>
            </div>
        </div>
    </div>
    
</t:body>




<%--
nickname, correo electrónico, nombre, apellido, fecha de nacimiento e imagen (opcional)
Se muestran los nickname de todos los seguidores que tiene, si es cliente con suscripción los usuarios a los que sigue (identificando si son clientes o artistas),
las listas de reproducción que creó y las preferencias que tiene guardadas, brindando la opción de seleccionar uno para ver su detalle como en los casos de uso Consulta de Álbum, y Consulta de Lista de Reproducción.--%>