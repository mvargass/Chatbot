<%-- 
    Document   : IniciarSesion
    Created on : 8/04/2018, 09:47:09 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido Inicia Sesion</title>
        <style>
             table, h11 {
             background-color: white; color:white;  border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
         </style>
         <link rel="stylesheet" href="http://localhost:8080/ChatRestaurante/Recursos/CSS/Estilos.css" >
    </head>
    
    <body style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen8.jpg); background-repeat: no-repeat; background-size: cover'>
    <%
       
        ControllerPregunta g = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        g.limpiar_listachat();//limpia la conversacion de dbconversacion.txt
        
    %>
    <center>
        <h1  style=" background-color: brown; color: white; font-size:100px" size= "100px" >¡Hola, Inicia sesion para empezar!</h1>
        <form method="post" action="Registrar.jsp">
        <table >
                <tr>   
                    <td  style="font-size:60px;color:black; text-shadow: 2px 2px 2px #FFFFFF;">Usuario:</td>    
                    <td><input type='text' style='font-size: 50px; width: 500px;' size="50px"  name="Nombre"></td>
                </tr>
                <tr style='font-size:25px;'>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td style="font-size:60px;color:black;  text-shadow: 2px 2px 2px #FFFFFF">Contraseña:</td>
                    <td><input type='password' style='font-size: 50px; width: 500px;' size="50px" name="Contrasenia"></td>
                </tr>
            </table>
            <p></p>
            <input type= 'submit'  value='Iniciar Sesion' id='button'>
        </form>
        <p></p>
        <form action="Registrar.jsp">
            <input type="submit" value="Registrarse" id="button">
            <p></p>
            <%out.println("<input type='text' value=' ' style='visibility:hidden' name='Nombre'>");
            out.println("<input type='text' value=' ' style='visibility:hidden' name='Contrasenia'>");%>
        </form>
    </center>
    </body>
    
</html>
