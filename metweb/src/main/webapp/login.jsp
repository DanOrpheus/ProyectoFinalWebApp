<%-- 
    Document   : login
    Created on : Jun 28, 2023, 12:59:25 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="estiloLogin.css">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <header>
            <h1><a class="logo">metFace</a></h1>
            <a href="#">Ayuda</a>
        </header>
        <div class="container">
            <form id="form_login" action="./auth?action=login" method="POST">
                <h1>Iniciar sesión</h1>
                <hr>
                <label for="avatar">Nombre de usuario</label>
                <input type="text" id="avatar" name="avatar">
                <label for="pass">Contraseña</label>
                <input type="password" id="pass" name="pass">
                <button type="submit">Iniciar sesión</button>
            </form>
            <p>¿No tienes cuenta?</p>
            <button type="submit" form="form_login" formaction="./auth?action=register" 
                    formmethod="post">Registrarse</button>
        </div>
        <footer>
            <div class="ftrItem1">
                <p>Daniel, Nadia, Victor, Victoria - ITSON 2023 - Licensed under Creative Commons</p>
            </div>
        </footer>
    </body>
</html>
