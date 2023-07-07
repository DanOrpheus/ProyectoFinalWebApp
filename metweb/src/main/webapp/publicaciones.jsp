<%-- 
    Document   : publicaciones
    Created on : Jun 28, 2023, 9:03:09 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page import="com.mongodb.client.MongoClients" %>
<%@page import="com.mongodb.client.MongoClient" %>
<%@page import="com.mongodb.client.MongoDatabase" %>
<%@page import="com.mongodb.client.MongoCollection" %>
<%@page import="com.mongodb.client.FindIterable" %>
<%@page import="org.bson.Document" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
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
        <script src='publicaciones.js'></script>
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
                        <input type="text" id="title" name="title"
                               placeholder="Titulo de la publicación">
                    </div>
                    <div>
                        <textarea id="content" name="content" 
                                  rows="10" cols="30"></textarea>
                    </div>
                    <div>
                        <button id="btn-publicar" type="button">Publicar</button>
                    </div>
		</form>
            </div>
        </div>
        <div class="publicaciones" id="publicaciones">
            <div class="container">
                <%
                    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                    MongoDatabase database = mongoClient.getDatabase("redSocialBD");
                    MongoCollection<Document> collection = database.getCollection("publicacion");
                    FindIterable<Document> publicacion = collection.find();

                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH");

                    for (Document publicaciones : publicacion) {
                        String id = publicaciones.getObjectId("_id").toString();
                        String titulo = publicaciones.getString("titulo");
                        String contenido = publicaciones.getString("contenido");
                        Date fechaHora = publicaciones.getDate("fechaHora");
                        Date fechaHoraM = publicaciones.getDate("fechaHoraM");
                %>
                <div class="post">
                    <div class="post-titulo">
                        <%= titulo%>
                        <div>
                            <span class="post-date">
                                <%
                                    if (fechaHoraM != null) {
                                        out.print(sdf.format(fechaHoraM));
                                    } else {
                                        out.print(sdf.format(fechaHora));
                                    }
                                %>
                            </span>
                        </div>
                    </div>
                    <div class="post-content">
                        <%= contenido%>
                    </div>
                    <div class="comment">
                        <input type="text" placeholder="Agregar comentario">
                        <button type="submit" class="btn-guardar">Guardar</button>
                    </div>
                </div>
                <%
                    }
                    mongoClient.close();
                %>
            </div>
        </div>
        <footer class="footer">
            <div class="footer-container">
		<p>Daniel, Nadia, Victor, Victoria - ITSON - 2023 - Licensed under Creative Commons</p>
            </div>
	</footer>
    </body>
</html>