<%-- 
    Document   : adminPublic
    Created on : Jun 28, 2023, 9:17:29 PM
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css"><%@include file = "Estilos/estilosPublicaciones.css"%></style>
	<title>Publicaciones Admin</title>
    </head>
    <body>
	<header class="header">
            <div class="logo">
		<a href="inicio.jsp"><h1 id="logoLetter">metFace </h1></a>
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
                        <h2><label for="publicacion">Nueva publicación</label></h2>
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
		<button class="delete-button" onclick="eliminarPublicacion(this)">Eliminar</button>
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
            <div class="post">
		<h2>Publicación 2</h2>
		<p>Contenido de la publicación 2.</p>
		<button class="delete-button" onclick="eliminarPublicacion(this)">Eliminar</button>
		<div class="comments">
                    <div class="comment">
			<p>Comentario 1 para la publicación 2.</p>
                    </div>
                    <div class="comment">
			<p>Comentario 2 para la publicación 2.</p>
                    </div>
		</div>
		<div class="comments2">
                    <form>
			<div>
                            <textarea id="newComentario" placeholder="Nuevo comentario" name="comentario" rows="4" cols="50"></textarea>
			</div>
			<div>
                            <button class="submit-button" type="submit">Publicar</button>
			</div>
                    </form>
		</div>
            </div>
	</div>
        <footer class="footer">
            <div class="footer-container">
		<p>Daniel, Nadia, Victor, Victoria - ITSON 2023 - Licensed under Creative Commons</p>
            </div>
	</footer>
	<script>
            function eliminarPublicacion(button) {
                var post = button.parentNode;
                while (!post.classList.contains("post")) {
                    post = post.parentNode;
                }
                post.parentNode.removeChild(post);
            }
	</script>
    </body>
</html>
