<%-- 
    Document   : ConsultaPedido
    Created on : 15/05/2018, 03:45:39 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Pedidos</title>
         <style>
             table, h1 {
                 background-color: white;
                 border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
             
         </style>
    </head>
    <body style="background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen5.jpg); background-repeat:  no-repeat; background-size:  cover">
    <%
                int id;
               ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
               
                id = Integer.valueOf(p.numero_activo());//recibe el id del cliente otra pagina%>
    <center>  
        <h1>Bienvenido Aqui puedes ver tus pedidos</h1>
        
        <table size="25px">
            <tr style="background-color:brown; color:white; border: hidden; ">
                <td> Id</td>
                <td> Nombre</td>
                <td> DPI</td>
                <td> Direccion</td>
                <td> Tipo de Pago </td>
                <td> Descripcion</td>
                <td> Fecha</td>
                <td> Total</td>
                
            </tr>
              <%
              for(int i=0; i<p.getPedidos().size(); i++){
                  
                  if(p.getPedidos().get(i).getNombre().equals(p.getDbCliente().get(id).getNombre())){//imprime todos los pedidos del cliente
              out.println("<tr>");
              out.println("<td> "+ p.getPedidos().get(i).getId()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getNombre()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getNit()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getDireccion()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getTipo_pago()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getDescripcion()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getFecha()+" </td>");
              out.println("<td> "+ p.getPedidos().get(i).getTotal()+" </td>");
              out.println("</tr>");
                  }
              }
              %>   
        </table>
        <p></p>
        <form action="VistaPregunta.jsp" method="post">
            <input type="submit" value="Regresar a Menu" style="background-color: black; color:white; font-size:50px;">
            <p></p>
            <%out.println("<input type='text' style='visibility:hidden' name='id'  value='"+id+"'>");//envia el id del cliente a Vistapregunta.jsp%>
        </form>
        <p></p>
        <form action="CancelarPedido.jsp" method="post">
            <input type="submit" value="Cancelar Pedido" style="background-color: black; color:white; font-size:50px;">
            <p></p>
            <%out.println("<input type='text' style='visibility:hidden' name='id'  value='"+id+"'>");//envia el id del cliente a  CancelarPedido.jsp%>
        </form>
    </center>
        
        
    </body>
</html>
