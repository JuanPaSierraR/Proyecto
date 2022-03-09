<%-- 
    Document   : index
    Created on : 3/03/2022, 09:43:58 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion</title>
        <link rel="stylesheet" href="Css/iniciarSesion.css">
    </head>
    <body>


        <form class="Formulario" method = "post" action = "Usuarios" > 
            <h1>Iniciar sesion</h1>
            <input type="text" name="txtDocumento" placeholder="Usuario" required="">
            <br>
            <input type="password" name="txtContrasena" placeholder="Contraseña" required="">
            <br>
            <button id="Boton"> Iniciar </button>
            <input type="hidden" value="4" name="opcion">
            <a href="registrarUsuario.jsp">Registrarse</a>

            <div class="mensaje">
                <%
                    if (request.getAttribute("mensajeError") != null) {%>
                ${mensajeError}                              

                <%}%>
            </div>

        </form>
    </body>
</html>
