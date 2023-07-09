<%-- 
    Document   : inicio
    Created on : Jun 28, 2023, 1:11:03 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.mongodb.client.MongoClients" %>
<%@page import="com.mongodb.client.MongoClient" %>
<%@page import="com.mongodb.client.MongoDatabase" %>
<%@page import="com.mongodb.client.MongoCollection" %>
<%@page import="com.mongodb.client.FindIterable" %>
<%@page import="org.bson.Document" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="Estilos/estiloInicio.css">
    <title>Inicio</title>
    <script src='inicio.js'></script>
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
                <a class="navitem" href="register.jsp">Crear Cuenta</a>
                <div class="subnavbar4">
                <a class="navitem" href="login.jsp">Cerrar Sesión</a>
</form>
            </div>
        </nav>
    </header>
    <main>
    <!-- Contenido principal de la página -->
    <h2>¡Bienvenido, ${sessionScope.usuario.avatar}!</h2>
</main>
    <main>
        <div class="container">
            <%
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("redSocialBD");
                MongoCollection<Document> collection = database.getCollection("posts");
                FindIterable<Document> publicacion = collection.find();
                for (Document publicaciones : publicacion) {
                    String id = publicaciones.getObjectId("_id").toString();
                    String titulo = publicaciones.getString("titulo");
                    String contenido = publicaciones.getString("contenido");
                    String fechaHora = publicaciones.getString("fechaHoraCreacion");
            %>
            <div class="post">
                <div class="post-title">
                    <%= titulo%>
                    <div class="post-options">
                        <button type="button" 
                                class="delete-button" 
                                id="btn-eliminar">Eliminar</button>
                    </div>
                </div>
                <div class="post-content">
                    <%= contenido%>
                </div>
                <div>
                    <%= fechaHora%>
                </div>
                <form>
                    <div class="comment">
                        <input type="text" id="content" name="content" 
                            placeholder="Agregar comentario">
                        <button type="button" id="btn-guardar" 
                            class="btn-guardar">Guardar</button>
                    </div>
                </form>
            </div>
            <%
                }
                mongoClient.close();
            %>
        </div>
    </main>
    <aside class="sidebar">
        <div class="NomRecomend">
        </div>
    </aside>
    <footer class="footer">
        <div class="footer-container">
		<p>Daniel, Nadia, Victor, Victoria - ITSON - 2023 - Licensed under Creative Commons</p>
        </div>
    </footer>
    <script src="inicio.js"></script> <!-- Archivo JavaScript -->
</body>
</html>

