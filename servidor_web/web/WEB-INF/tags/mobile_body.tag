<%-- 
    Document   : mobile_body
    Created on : Nov 15, 2016, 7:52:52 PM
    Author     : DJA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="user" type="espotify.datatypes.DataUsuario"%>
<t:wrapper>
    <t:mobile_navbar user="${user}"/>
    <div class="container-fluid main" style="padding:0">
        <div class="row main_row">
            <t:sidebar user="${user}" />
            <div class="contenido col-lg-9 col-md-9 col-sm-12 col-xs-12">
                <jsp:doBody />
            </div>
        </div>
    </div>
</t:wrapper>