<%-- 
    Document   : publicaciones
    Created on : Jun 28, 2023, 9:03:09 PM
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css">
            <%@include file = "Estilos/estilosPublicaciones.css"%>
        </style>
	    <title>Publicaciones</title>
    </head>
    <body>
        <header class="header">
            <div class="logo">
                <a href="inicio.jsp"><h1 id="logoLetter">metface </h1></a>
            </div>
            <nav class="navbar">
                <div class="subnavbar">
                    <a class="navitem" href="#">Publicaciones</a>
                </div>
                <div class="subnavbar2">
                    <a class="navitem" href="inicio.jsp">Inicio</a>
                    <a class="navitem" href="register.jsp">Crear Cuenta</a>
                </div>
            </nav>
        </header>
        <div class="grid-container">
            <div class="add-post">
                <form id="form_publicaciones" action="./posts?action=create" method="post">
                    <div>
                        <input type="text" id="title" name="title" 
                               placeholder="Titulo de la publicación">
                    </div>
                    <div>
                        <textarea id="content" name="content" 
                                  rows="10" cols="30"></textarea>
                    </div>
                    <div>
                        <button class="submit-button" id="btn-publicar">Publicar</button>
                    </div>
		</form>
            </div>
        <footer class="footer">
            <div class="footer-container">
		<p>Daniel, Nadia, Victor, Victoria - Licensed under Creative Commons</p>
            </div>
	</footer>
    </body>
</html>