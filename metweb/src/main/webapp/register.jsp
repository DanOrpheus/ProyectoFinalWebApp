<%-- 
    Document   : register
    Created on : Jun 28, 2023, 1:11:03 PM
    Author     : Victor, Victori0a, Daniel y Nadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <style type="text/css"><%@include file = "Estilos/estiloRegistro.css"%></style>
	<title>Crear Nueva Cuenta</title>
    </head>
    <body>
	<header>
            <h1><a class="logo">metface</a></h1>
            <a href="#" class="navlink" >Ayuda</a>
                <div class="subnavbar2">
                    <a class="navitem" href="inicio.jsp">Inicio</a> </div>
  	</header>
        <main>
            <form class="formcont" action="./user?action=create" method="post">
                    <h1 class="registerHeader">Nueva Cuenta</h1>
                    <hr>
                    <input type="text" id="username" name="username" 
                           placeholder="Ingresa un nombre de usuario">                
                    <input type="email" id="mail" name="mail" 
                           placeholder="Ingresa tu correo">
                    <input type="text" id="firstname" name="firstname" 
                           placeholder="Nombre(s)">
                    <input type="text" id="lastname" name="lastname" 
                           placeholder="Apellido(s)">
                    <input type="password" id="pass" name="pass" 
                           placeholder="Ingresa una contraseña">
                    <input type="password" id="passConfirm" name="passConfirm" 
                           placeholder="Confirma tu contraseña">
                      <input type="file" id="profileImage" accept="image/*">

           <%-- Muestra el mensaje de error si existe --%>
    <% String errorPass = (String) request.getAttribute("errorPass"); %>
    <% if (errorPass != null) { %>
        <p style="color: red;
    font-weight: bold;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;"><%= errorPass %></p>
    <% } %>      
                    <input type="date" id="birthdate" name="birthdate">
                    <select id="city" name="city">
                        <option value="" selected>--Selecciona una ciudad--</option>
                        <optgroup label="Sonora">
                            <option value="obregon">Ciudad Obregón</option>
                            <option value="hermosillo">Hermosillo</option>
                            <option value="nogales">Nogales</option>
                            <option value="guaymas">Guaymas</option>
                            <option value="navojoa">Navojoa</option>
                        </optgroup>
                        <optgroup label="Coahuila">
                            <option value="saltillo">Saltillo</option>
                            <option value="torreon">Torreón</option>
                            <option value="zaragoza">Zaragoza</option>
                            <option value="nadadora">Nadadora</option>
                            <option value="matamoros">Matamoros</option>
                        </optgroup>
                        <optgroup label="Baja California">
                            <option value="mexicali">Mexicali</option>
                            <option value="ensenada">Ensenada</option>
                            <option value="tijuana">Tijuana</option>
                            <option value="tecate">Tecate</option>
                            <option value="rosarito">Rosarito</option>
                        </optgroup>
                        <optgroup label="Chihuahua">
                            <option value="chihuahua">Chihuahua</option>
                            <option value="cjuarez">Ciudad Juárez</option>
                            <option value="delicias">Delicias</option>
                            <option value="parral">Parral</option>
                            <option value="camargo">Camargo</option>                        
                        </optgroup>
                        <optgroup label="Durango">
                            <option value="canatlan">Canatlán</option>
                            <option value="clerdo">Ciudad Lerdo</option>
                            <option value="salto">El Salto</option>
                            <option value="blanco">Peñón Blanco</option>
                            <option value="palacio">Gómez Palacio</option>
                        </optgroup>
                        <optgroup label="Guanajuato">
                            <option value="celaya">Celaya</option>
                            <option value="salamanca">Salamanca</option>
                            <option value="irapuato">Irapuato</option>
                            <option value="allende">San Miguel de Allende</option>
                            <option value="leon">León de los Aldama</option>
                        </optgroup>
                    </select>
                    <button class="button1" type="submit">Registrarse</button>
                    <button class="button2" type="reset">Reiniciar</button>
            </form>
        </main>
	<footer>
	    <div class="ftrItem1">
                <p class="ftrP">Daniel, Nadia, Victor, Victoria - ITSON 2023 - Licensed under Creative Commons</p>
	    </div>
  	</footer>
    </body>
</html>