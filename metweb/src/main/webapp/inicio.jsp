<%-- 
    Document   : inicio
    Created on : Jun 28, 2023, 4:53:09 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
            <style type="text/css"><%@include file = "Estilos/estilo.css"%></style>
	    <title>Inicio</title>
    </head>
    <body>
	    <header>
            <div class="logo">
		        <a href="inicio.jsp"><h1 id="logoLetter">metFace</h1></a>
            </div>
            <nav class="navbar">
		        <div class="subnavbar">
                    <a class="navitem" href="publicaciones.jsp">Publicaciones</a>
		        </div>
		        <div class="subnavbar2">
                    <a class="navitem" href="inicio.jsp">Inicio</a>
                    <a class="navitem" href="register.jsp">Crear Cuenta</a>
		        </div>
            </nav>
	    </header>
        <main>
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
        </main>	
	    <aside class="sidebar">
            <div class="NomRecomend">
            </div>
	    </aside>      
    </body>
</html>