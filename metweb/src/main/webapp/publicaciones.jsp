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
        <style type="text/css"><%@include file = "Estilos/estilosPublicaciones.css"%></style>
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
                <form>
                    <div>
                        <h2><label for="publicacion" >Nueva publicación<br></label></h1>
                        <textarea id="publicacion" name="publicacion" rows="4" cols="70"></textarea>
                    </div>
                    <div>
                        <button class="submit-button" type="submit">Publicar</button>
                    </div>
		</form>
            </div>
            <div class="post">	
                <h2>Publicación 1</h2>
                <p>Contenido de la publicación 1.</p>
                <div class="comments">
                    <div class="comment">
                        <p>Comentario 1 para la publicación 1.</p>
                    </div>
                    <div class="comment">
                        <p>Comentario 2 para la publicación 1.</p>
                    </div>
                </div>
                <div class="comments2">
                    <form>
                        <div>
                            <textarea id="comentario" 
                                      placeholder="Nuevo comentario" 
                                      name="comentario" rows="4" 
                                      cols="50"></textarea>
                        </div>
                        <div>
                             <button class="submit-button" type="submit">Publicar</button>
                        </div>
                    </form>
                </div>
            </div>
            <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo de la publicación</th>
                <th>Contenido</th>
                <th>Fecha y hora de la creación</th>
            </tr>
            <c:forEach items="${requestScope.posts}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.contenido}</td>
                    <td>${item.fechaHoraCreacion}</td>
                </tr> 
            </c:forEach>
            </table>      
        <footer class="footer">
            <div class="footer-container">
		<p>Daniel, Nadia, Victor, Victoria - Licensed under Creative Commons</p>
            </div>
	</footer>
    </body>
</html>