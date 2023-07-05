<%-- 
    Document   : index
    Created on : Jun 28, 2023, 1:17:05 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css"><%@include file = "Estilos/index.css"%></style>
        <title>Index</title>
    </head>
    <body>
        <div class="header">
            <h2></h2>
        </div>
        <div class="content">
            <h1>¡¡ Hola ${sessionScope.usuario.avatar} !!</h1>
            <form action="./auth?action=start" method="post">
                <button type="submit">Ir a página de inicio</button>
            </form>        
            <form action="./auth?action=logout" method="post">
                <button type="submit">Cerrar sesión</button>
            </form>
        </div>
        <div class="footer">
            <p>Daniel, Nadia, Victor, Victoria - ITSON 2023 - Licensed under Creative Commons</p>
        </div>
    </body>
</html>
