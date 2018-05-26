<%-- 
    Document   : Comprado
    Created on : 12/04/2018, 03:14:53 PM
    Author     : Grupo1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprando</title>
        <style>
             table, h1 {
            border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box; background-color: white; }
         </style>
        
       
    </head>
    <body style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen4.png); background-repeat:  no-repeat; background-size:  cover'>
    <center>
        <h1>Comprando, ¡Gracias por Comprar!</h1>
        <p></p>
        <%
        ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        int id, menu;//declara variables numericas enteras
         String formapago;//declara variable de texto llamada formapago 
         formapago = request.getParameter("formapago");//recibe la forma de pago del cliente de otra pagina
         menu = Integer.valueOf(request.getParameter("seleccion"));//recibe el id del menu seleccionado de otra pagina
         id = Integer.valueOf(request.getParameter("id"));//recibe el id del cliente de otra pagina
         
         p.comprar_menu(request, response);//realiza la compra y crea el pedido en dbpedidos.txt
         
         
        %>
       
        <table style="font-size:50px;">
            <tr >
            <td><p> ID: </p></td>
            <td><p> <% out.println(id+1); %> </p></td>
            </tr>
            <tr>
            <td><p> Nombre: </p></td>
            <td><p> <% out.println(p.getDbCliente().get(id).getNombre()); //imprime en la pagina el nombre %> </p></td>
            </tr>
            <tr>
            <td><p> Direccion: </p></td>
            <td><p> <% out.println(p.getDbCliente().get(id).getDireccion()); //imprime en la pagina la direccion%> </p></td>
            </tr>
            <tr>
            <td><p> Telefono: </p></td>
            <td><p> <% out.println(p.getDbCliente().get(id).getTelefono()); //imprime en la pagina el telefono%> </p></td>
            </tr>
            <tr>
            <td><p> Menu: </p></td>
            <td><p> <% out.println(p.getDbmenu().get(menu).getDescripcion()); //imprime en la pagina el menu%> </p></td>
            </tr>
            <tr>
            <td><p> Total: </p></td>
            <td><p> <% out.println(p.getDbmenu().get(menu).getTotal()); //imprime en la pagina el total a pagar del menu%> </p></td>
            </tr>
        </table>
            <form method="post" action="VistaPregunta.jsp">
                <input type="submit" value="Regresar al Chatbot" style="background-color: black; color:white; font-size:50px;">
            </form>
    </center>
    </body>
</html>
