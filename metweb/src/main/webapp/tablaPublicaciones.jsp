<%-- 
    Document   : tablaPublicaciones
    Created on : Jun 28, 2023, 10:47:15 PM
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
    </body>
</html>
