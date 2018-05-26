<%-- 
    Document   : Registrar
    Created on : 8/04/2018, 10:23:33 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse </title>
         <link rel="stylesheet" href="http://localhost:8080/ChatRestaurante/Recursos/CSS/Estilos.css" >
         <style>
             table {
                border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; width: 200px;   background-color: white; background-clip: padding-box;
             }
         </style>

    </head>
    <body style="background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen1.jpg);   background-repeat: no-repeat; background-size: cover">
    <% 
       ControllerPregunta g = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
       String nombre;//declara una variable texto llamada nombre
       nombre = request.getParameter("Nombre");//recibe un nombre 
       g.operacion_();//arma la estructura de datos
       g.pedir_datos(request, response);//verifica los datos recibidos para ver si el cliente esta registrado
       
       
    %>    
    <center>
        <h1 id="h1">Bienvenido Registrate para iniciar</h1>
        <form method="post" action="Registrado.jsp">
            <table>
                <tr>
                    <td>  <p> Ingrese su Nombre es: </p> </td>
                    <%out.println("<td> <input style='font-size:50px' type='texto' name='nombre' value='"+nombre+"' </td>");%>
                </tr>
                <tr>
                    <td>  <p> Ingrese su Direccion: </p> </td>
                    <td> <input style="font-size:50px" type="text" name="direccion" > </td>
                </tr>
                <tr>
                    <td>  <p> Ingrese su DPI: </p> </td>
                    <td> <input style="font-size:50px" type="text" name="dpi" > </td>
                </tr>
                <tr>
                    <td>  <p> Ingrese su Fecha: </p> </td>
                    <td> <input style="font-size:50px" type="text" name="fecha" > </td>
                </tr>
                <tr>
                    <td>  <p> Ingrese su Nit: </p> </td>
                    <td> <input style="font-size:50px" type="text" name="nit" > </td>
                </tr>
                <tr>
                    <td>  <p> Ingrese su Telefono: </p> </td>
                    <td> <input style="font-size:50px" type="text" name="telefono" > </td>
                </tr>
                
            </table>
            <input id="button" type="submit" name="envio" value="Registrar">
        </form>
                </center>
        
    </body>
</html>
