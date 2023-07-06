<%-- 
    Document   : inicio
    Created on : Jun 28, 2023, 4:53:09 PM
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
        <link rel="stylesheet" type="text/css" href="Estilos/estilo.css">
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
            <table>
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Contenido</th>
                    <th>Fecha creación</th>
                    <th>Fecha Modificacion</th>
                </tr>
                <%
                    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                    MongoDatabase database = mongoClient.getDatabase("redSocialBD");
                    MongoCollection<Document> collection = database.getCollection("publicacion");
                    FindIterable<Document> publicacion = collection.find();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    for (Document publicaciones : publicacion) {
                        String id = publicaciones.getObjectId("_id").toString();
                        String titulo = publicaciones.getString("titulo");
                        String contenido = publicaciones.getString("contenido");
                        Date fechaHora = publicaciones.getDate("fechaHora");
                        Date fechaHoraM = publicaciones.getDate("fechaHoraM");


                %>
                <tr>
                    <td><%= id%></td>
                    <td><%= titulo%></td>
                    <td><%= contenido%></td>
                    <td><%= sdf.format(fechaHora)%></td>
                    <td><%= sdf.format(fechaHoraM)%></td>
                </tr>
                <%
                    }

                    mongoClient.close();
                %>
            </table>
        </main>    
        <aside class="sidebar">
            <div class="NomRecomend">
            </div>
        </aside>
        <footer class="footer">
            <div class="footer-container">
                <p>D. Gutiérrez, V. A., N. Soto, V. Pauda - Licensed under Creative Commons</p>
            </div>
        </footer>
    </body>
</html>
