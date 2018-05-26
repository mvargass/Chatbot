<%-- 
    Document   : CancelarPedido
    Created on : 16/04/2018, 12:00:17 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancelar Pedido</title>
        <style>
             table, h1 {
                 background-color: white;
                 border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
             
         </style>
        
    </head>
    <body style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen4.png); background-repeat:  no-repeat; background-size:  cover'>
      <center>
        <h1>Bienvenido complete el formulario para Cancelar Pedido</h1>
        <% ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        int id;   //declara una variable numerica entero
        String nombre;//declara una variable texto
        id = Integer.valueOf(p.numero_activo());//recibe el id del cliente de otra pagina
        %>
    
        <form action="Cancelado.jsp" method="post">
        <table style="font-size:25px; ">
            <tr>
                <td><h2>Nombre:</h2></td>
                <td> <%out.println(p.getDbCliente().get(id).getNombre());//imprime el nombre del cliente %></td>
            </tr>
            <tr>
                <td><h2>Nit:</h2></td>
                <td> <% out.println(p.getDbCliente().get(id).getNit()); //imprime el nit del cliente%></td>
            </tr>
            <tr>
                <td><h2>Direccion:</h2></td>
                <td> <% out.println(p.getDbCliente().get(id).getDireccion());//imprime la direccion del cliente %></td>
            </tr>
            <tr>
                <td><h2>Telefono:</h2></td>
                <td> <% out.println(p.getDbCliente().get(id).getTelefono()); //imprime el telefono del cliente%></td>
            </tr>
            <tr>
                <td> <h2>Seleccione el menu a Cancelar:</h2> </td>
            <%
            String aux, aux2;  //declara variables de texto llamadas aux y aux2
            
            out.println("<td><select name='seleccion' > ");//imprime un optionbutton
            for(int i=0; i<p.getPedidos().size(); i++){//imprime la descripcion de la orden y tambien la fecha del pedido
             if(p.getPedidos().get(i).getNombre().equals(p.getDbCliente().get(id).getNombre())){
                aux = p.getPedidos().get(i).getFecha();
                aux2 = p.getPedidos().get(i).getDescripcion();
                out.println("<option value='"+ i +"'> Pedido "+(i+1)+": "+aux + "(" +aux2+ ")"+ "</option>");
             }
            }
            out.println("</select></td>");
            
           
            %>
            </tr>    
            
        </table>
            <%out.println("<input type='text' style='visibility:hidden' name='id' value='"+id+"'>");//envia el id a otra pagina %>
            <p></p>
            <input type="submit" name="enviar" value="Cancelar Orden" style="background-color: black; color:white; font-size:50px;">
        </form>
        <p></p>    
        <form action="VistaPregunta.jsp" method="post">
            <input type="submit" value="Regresar a Menu" style="background-color: black; color:white; font-size:50px;">
            <p></p>
            <%out.println("<input type='text' style='visibility:hidden' name='id'  value='"+id+"'>");//envia el id en otra pagina%>
        </form>
  
    </center>

    </body>
</html>
