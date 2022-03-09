<%-- 
    Document   : registrarUsuario
    Created on : 3/03/2022, 08:29:39 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link rel="stylesheet" href="Css/registrarUsuario.css">
    </head>
    <body>

        <form class="Formulario" method = "post" action = "Usuarios" > 
            <h1>Registrar Usuario</h1>
            <input type="text" name="txtNombre" placeholder="Nombres" required="" >
            <br>
            <input type="text" name="txtDocumento" placeholder="Documento" required="">
            <br>
            <input type="text" name="txtTelefono" placeholder="Telefono" required="">
            <br>
            <input type="text" name="txtEmail" placeholder="Email" required="">
            <br>
            <input type="text" name="txtDireccion" placeholder="Direccion" required="">
            <br>
            <input type="number" name="txtEstado" placeholder="Estado" required="">
            <br>
            <input type="password" name="txtContrasena" placeholder="Contraseña" required=""><br>
            <button id="Boton"> Registrar </button>
            <input type="hidden" value="1" name="opcion">
            <a href="index.jsp">Iniciar Sesion</a><br>
            
            <div class="mensaje">
                <%
                if (request.getAttribute("mensajeError") != null) {%>
                ${mensajeError}

                <%   } else {%>
                ${mensajeExito}

                <%}%>
            </div>
        </form>

    </body>
</html>
