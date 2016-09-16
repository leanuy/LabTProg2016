<%-- 
    Document   : MiPerfilArtista
    Created on : Sep 15, 2016, 8:42:07 PM
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
                    <img src="<c:out value="${imagen}"/>" style="width:100%"> <%--imagen del artista--%>
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
                <p>
                    <i class="glyphicon glyphicon-globe"></i>
                    <c:out value="${url}"/>
                </p>
                <p>
                    <i class="glyphicon glyphicon-list-alt"></i>
                    <c:out value="${bio}"/>
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
                        Albums:
                    </h2>
                    <c:forEach items="${albums}" var="item">
                        <a href="/VerAlbum?nick=${nick}&amp;album=${item}">${item}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    
</t:body>




<%--
Se muestran los nickname de todos los seguidores que tiene, si es cliente con suscripción
los usuarios a los que sigue (identificando si son clientes o artistas),
las listas de reproducción que creó y las preferencias que tiene guardadas,
brindando la opción de seleccionar uno para ver su detalle como en los casos de uso Consulta de Álbum,
y Consulta de Lista de Reproducción. Si es artista se listan los nombres de cada álbum que tenga registrado
y, para cualquier álbum que el usuario quiera, se visualizan los datos de éste de la misma forma que se hace
en Consulta de Álbum.--%>