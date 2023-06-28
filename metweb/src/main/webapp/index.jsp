<%-- 
    Document   : index
    Created on : Jun 28, 2023, 1:17:05 PM
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Inicio</title>
    </head>
    <body>
        <h1>Hola ${sessionScope.usuario.nombre} !!</h1>
        <form action="./auth?action=inicio" method="post">
            <button type="submit">Ir a página de inicio</button>
        </form>        
        <form action="./auth?action=logout" method="post">
            <button type="submit">Cerrar sesión</button>
        </form>
    </body>
</html>
