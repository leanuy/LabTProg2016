<%-- 
    Document   : body
    Created on : Sep 13, 2016, 11:01:33 AM
    Author     : agustina
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="user" type="servidor.DataUsuario"%>
<t:wrapper>
    <t:navbar user="${user}"/>
    <div class="container-fluid main" style="padding:0">
        <div class="row main_row">
            <t:sidebar user="${user}" />
            <div class="contenido col-lg-9 col-md-9 col-sm-12 col-xs-12">
                <jsp:doBody />
            </div>
        </div>
    </t:wrapper> 