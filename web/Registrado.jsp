<%-- 
    Document   : Registrado
    Created on : 8/04/2018, 10:33:27 PM
    Author     : Grupo 1
   /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido Registrado</title>
        <style>
             table {
            border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;   background-color: white;}
         </style>
    </head>
    <body  style="background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen1.jpg); background-repeat:  no-repeat; background-size: cover;">
        <%
          
            ControllerPregunta n = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
            int id;//declaracion id
            String nombre, direccion, dpi, telefono, nit;//declaracion de direccion, nombre, dpi, telefono, dpi
            nombre= request.getParameter("nombre");//recibe el nombre de otra pagina
            direccion= request.getParameter("direccion");//recibe la direccion de otra pagina
            dpi = request.getParameter("dpi");//recibe el dpi de otra pagina
            telefono = request.getParameter("telefono");//recibe el telefono de otra pagina
            nit = request.getParameter("nit");//recibe el nit de otra pagina
            n.operacion_();//arma la estructura de datos
            id = n.registrar_(request, response);//registra al cliente en dbcliente.txt y dbcuenta.txt
        %>
        <center>
        <h1 style="background-color: white; font-size:50px;">Datos de Usuario:</h1>
        <table>
            <tr>
                <td> <p style="font-size:50px"> Id: <% out.println(id+1);%> </p></td> 
            </tr>
            <tr>
                <td> <p style="font-size:50px">Nombre: <% out.println(nombre);%> </p> </td> 
            </tr>
            <tr>
                <td> <p style="font-size:50px"> Direccion: <% out.println(direccion);%></p></td>
            </tr>
            <tr>
                <td> <p style="font-size:50px">DPI: <% out.println(dpi);%> </p> </td> 
            </tr>
            <tr>
                <td> <p style="font-size:50px"> Telefono: <% out.println(telefono);%> </p></td>
            </tr>
            <tr>
                <td> <p style="font-size:50px"> Nit: <% out.println(nit);%> </p></td> 
            </tr>          
        </table>
        
            
            <form method="post" action="VistaPregunta.jsp">
                
               <% out.println("<input type='text' style ='visibility:hidden;' name='id' value='" + id + "'>");//envia el id%>
               <p></p>
               <input type="submit" value="Ir Al Chatbot" name="enviar" style=" background-color: black; color:white; font-size:50px; ">
             
            </form>
        </center>
        
    </body>
</html>
