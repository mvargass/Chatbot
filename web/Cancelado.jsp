<%-- 
    Document   : Cancelado
    Created on : 7/05/2018, 12:34:40 PM
    Author     : Grupo1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
        Mi parte todos los jsp (interfaz grafica).
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancelando...</title>
    </head>
    <body>
        <h1>Cancelando</h1>
        <%
        
        ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        p.cancelar_pedido(request, response);//cancela la orden de dbpedidos y redirige a menu principal VistaPregunta.txt        
        
        
        
        
        %>
    </body>
</html>
