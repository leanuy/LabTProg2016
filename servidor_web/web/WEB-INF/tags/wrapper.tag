<%-- 
    Document   : wrapper
    Created on : Sep 13, 2016, 10:43:08 AM
    Author     : agustina
--%>

<%@tag description="Basic Wrapper" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">

        <title>Espotify</title>
        <meta name="description" content="Music">
        <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway" rel="stylesheet"> 
        <meta name="author" content="SitePoint">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/bootstrap.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/font_awesome/css/font-awesome.css" type='text/css'>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/css.css">
        <script src="<%= request.getContextPath()%>/assets/js/jquery-3.1.0.min.js"></script>
    </head>
    <body>
        <jsp:doBody/>
        <script src="<%= request.getContextPath()%>/assets/js/bootstrap.js"></script>
        <script src="<%= request.getContextPath()%>/assets/js/script.js"></script>
    </body>
</html>