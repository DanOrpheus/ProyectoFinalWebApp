<%-- 
    Document   : errorHttp
    Created on : Jun 28, 2023, 7:26:41 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Estilos/estilosErrorHttp.css">

        <title>Oops... ¡Algo ocurrió!</title>
    </head>
    <body>
        <h1>Error ocurrido: </h1>
        <p> ${requestScope.error} </p>
    </body>
</html>
