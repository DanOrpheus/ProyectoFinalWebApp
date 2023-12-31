<%-- 
    Document   : inicio
    Created on : Jun 28, 2023, 1:11:03 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>
<%@page import="org.itson.dominio.Usuario"%>
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
    <script src='inicio.js'></script>
    <title>Inicio</title>
</head>
<body>
    <header>
        <div class="logo">
            <a href="inicio.jsp"><h1 id="logoLetter">metface</h1></a>
        </div>
        <nav class="navbar">
            <a class="navitem" href="publicaciones.jsp">Publicaciones</a>

            <a class="navitem" href="register.jsp">Crear Cuenta</a>

            <a class="navitem" href="login.jsp">Cerrar Sesión</a>
        </nav>
    </header>
    <main>
        <!-- Contenido principal de la página -->
        <h2>¡Bienvenido, ${sessionScope.usuario.avatar}!</h2>
        <!--<div class="container">-->
            <%
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("redSocialBD");
                MongoCollection<Document> pCol = database.getCollection("posts");
                MongoCollection<Document> cCol = database.getCollection("comentarios");
                FindIterable<Document> comentario = cCol.find();
                FindIterable<Document> publicacion = pCol.find();
                for (Document publicaciones : publicacion) {
                    String id = publicaciones.getObjectId("_id").toString();
                    String titulo = publicaciones.getString("titulo");
                    String contenido = publicaciones.getString("contenido");
                    String fechaHoraCreacion = publicaciones.getString("fechaHoraCreacion");
                    Document autor = publicaciones.get("autor", Document.class);
            %>
        <div class="post">
            <div class="post-title">
                <%= titulo%><br>
                <i><%= autor.getString("avatar")%></i>
                <form>
                    <div class="post-options">
                        <button type="button" 
                            class="delete-button" 
                            id="btn-eliminar">Eliminar</button>
                    </div>
                </form>
            </div>
            <div class="post-content">
                <%= contenido%>
            </div>
            <div class="post-date">
                <%= fechaHoraCreacion%>
            </div>
        
            <hr>
        
            <form>
                <div class="comment">
                    <input type="text" id="content" name="content" 
                        placeholder="Agregar comentario">
                    <button type="button" id="btn-guardar" 
                        class="btn-guardar">Enviar</button>
                </div>
            </form>
        </div>
                <%
                for (Document comentarios : comentario) {
                    String content = comentarios.getString("contenido");
                    String fechaHora = comentarios.getString("fechaHora");
                    Document autorCom = comentarios.get("autor", Document.class);
                    //String idPost = comentarios.getString("post");

                %>
            <div class="commentBox">
                <div class="comment-content">
                            <%= content%>
                </div>
                <div class="comment-date">
                    <%= fechaHora%><br>
                    <i><%= autorCom.getString("avatar")%></i>
                </div>
            </div>    
        <%
                }
            }
            mongoClient.close();
        %>      
        <!--</div>-->
            
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
</body>
</html>

