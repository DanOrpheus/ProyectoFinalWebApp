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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¡Felicidades!</title>
    </head>
    <body>
        <c:if test="${requestScope.usuario != null}">
        <h1>Bienvenido ${requestScope.usuario.nombreCompleto} !</h1>
        <h3>Esta listo para iniciar sesión en metFace</h3>
        </c:if>     
        <form action="./auth?action=login" method="post">
            <button type="submit">Iniciar sesión</button>
        </form>
    </body>
</html>
