<%-- 
    Document   : ConsultaMenu
    Created on : 15/05/2018, 09:07:43 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido Consulta de Menu</title>
        <style>
             table, h1 {
                 background-color: white;
                 border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
             
         </style>
    </head>
    <body  style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen6.jpg); background-repeat:  no-repeat; background-size:  cover'>
        <%
        int id;
        ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        id= Integer.valueOf(p.numero_activo());//recibe el id del cliente de archivo dbnumero.txt
        %>
    <center>
        <h1>Bienvenido Los menus disponibles:</h1>
        <table text-size="25px">
            <tr style="background-color:brown; color:white;">
            <td> Id </td>
            <td> Nombre Menu </td>
            <td> Descripcion </td>
            <td> Total </td>
            </tr>
            <%
                
           
            for(int i=0; i<p.getDbmenu().size(); i++){//imprime el menu ubicado en dbmenu.txt    
            out.println("<tr>");
            out.println("<td>"+ p.getDbmenu().get(i).getId()+"</td>");
            out.println("<td> Menu "+p.getDbmenu().get(i).getId()+"</td>");
            out.println("<td>"+ p.getDbmenu().get(i).getDescripcion()+"</td>");
            out.println("<td>"+ p.getDbmenu().get(i).getTotal()+"</td>");
            out.println("</tr>");
            }
            %>
            
            
        </table>
            <form action="VistaPregunta.jsp" method="post">
                <input type="submit" value="Ir a ChatBot" style="background-color: black; color:white; font-size:50px;">
                <p></p>
                <%out.println("<input type='text' value='"+id+"' style='visibility:hidden;'>");%>
                <% p.set_Numero(id);%>
            </form>
            <p></p>
            <form action="Comprar.jsp" method="post">
                <h1 style="background-color:white; font-size:50px;"> ¿Desea Realizar una compra? Selecciona un tipo de Pago</h1>
                <select style="font-size:50px; " name="seleccionador"> 
                    <option value="Efectivo">Efectivo</option>
                    <option value="Cheque">Cheque</option>
                    <option value="Debito">Debito</option>
                    <option value="Credito">Credito</option>
                </select>
                <p></p>
                <%out.println("<input type='text' value='"+id+"' style='visibility:hidden;'>");//envia el id del cliente
                p.set_Numero(id);//imprime el id del cliente en dbnumero.txt
                %>
                <p></p>
                <input type="submit" value="Comprar" style="background-color: black; color:white; font-size:50px;">

            </form>
            </center>
    </body>
</html>
