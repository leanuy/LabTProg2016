<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="assets/js/jquery-3.1.0.min.js"></script>
<c:choose>
    <c:when test="${esWeb}">
        <a href="${link}">Escuchar(v�nculo externo)</a>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${tieneVigente}">
                <a class="link-user" href="/Descargar?artista=${nickArtista}&album=${nombreAlbum}&tema=${nombreTema}">Descargar</a>
                (${cantDescargas} descargas).
            </c:when>
            <c:otherwise>
                <a href="/Suscripcion">Suscr�bete</a> para poder descargar este y muchos temas m�s. (${cantDescargas} descargas).
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${tieneVigente}">
        <br>
        Agregar a lista:
        <select class="combolistas">
            <c:forEach items="${listas}" var="item">
                <option>${item}</option>
            </c:forEach>
        </select>
        <button class="boton_confirmar btn btn-custom" onclick="ConfirmarAgregarLista()" data-nick="${nick_sesion}" data-tema="${nombreTema}" data-album="${nombreAlbum}" data-artista="${nickArtista}">Agregar a lista</button>
        <div class="mensaje"></div>
    </c:when>
</c:choose>