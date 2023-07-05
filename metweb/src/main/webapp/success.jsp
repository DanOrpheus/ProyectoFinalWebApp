<%-- 
    Document   : success
    Created on : Jun 28, 2023, 7:29:03 PM
    Author     : Victor, Victoria, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css"><%@include file = "Estilos/estiloSuccess.css"%></style>
        <title>¡Felicidades!</title>
    </head>
    <body>
        <div class="container">
        <header></header>
        <div class="content"
        <c:if test="${requestScope.usuario != null}">
        <h1>¡Bienvenido ${requestScope.usuario.nombreCompleto}!</h1>
        <h3>¡¡¡Esta listo para iniciar sesión en metFace!!!</h3>
        </c:if>     
        <form action="./auth?action=login" method="post">
            <button type="submit">Iniciar sesión</button>
        </form>
        </div>
        <footer></footer>
        </div>
    </body>
</html>
