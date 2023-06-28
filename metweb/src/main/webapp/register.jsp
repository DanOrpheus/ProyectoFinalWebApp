<%-- 
    Document   : register
    Created on : Jun 28, 2023, 1:11:03 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/Estilos/estiloRegistro.css">
	<title>Crear Nueva Cuenta</title>
    </head>
    <body>
	<header>
            <h1><a href="index.html" class="logo">metFace</a></h1>
            <a href="#">Ayuda</a>
  	</header>
	<form class="formcont" action="#" method="post">
		<h1 class="registerHeader">Nueva Cuenta</h1>
		<hr>
		<input type="text" id="username" name="username" placeholder="Nombre de Usuario">
		<input type="email" id="correo" name="correo" placeholder="Correo Electronico">
		<input type="text" id="nombre" name="nombre" placeholder="Nombre(s)">
		<input type="text" id="apellido" name="apellido" placeholder="Apellido(s)">
		<input type="password" id="pass" name="pass" placeholder="Crea una Contraseña">
		<input type="password" id="passConfirm" name="passConfirm" placeholder="Confirma tu Contraseña">
		<input class="button1" type="submit" name="Enviar" value="Enviar">
		<input class="button2" type="reset" name="Restablecer">
	</form>
	<footer>
	    <div class="ftrItem1">
	      <p>D. Gutiérrez, V. A., N. Soto, V. Pauda - ITSON 2023 - Licensed under Creative Commons</p>
	    </div>
  	</footer>
    </body>
</html>