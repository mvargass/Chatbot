<%-- 
    Document   : Comprar
    Created on : 12/04/2018, 02:33:05 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <style>
             table, h1 {
             background-color: white; border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
         </style>
    </head>
    <body style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen4.png); background-repeat:  no-repeat; background-size:  cover'>
     <center>   
        <h1>Bienvenido Completa el siguiente formulario:</h1>
    
        <%ControllerPregunta e = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
        String aux, formapago; //declara variables de texto
        double aux2; //declara una variable de numero entero
        int id=0;//declara aux2 con valor de 0
        formapago="";//declara la variable formapago como ''
        
        if(request.getParameter("id")!=null){//verifica que reciba el id del cliente
        id = Integer.valueOf(request.getParameter("id")); //declara el id del cliente a id
        }else if(request.getParameter("id")==null){//verifica si no recibe existe el id cliente
           id = Integer.valueOf(e.numero_activo()); //recibe el id del cliente del dbnumero.txt
        }
        
        if(request.getParameter("seleccionador")!=null){//verifica si recibe la forma de pago del cliente de otra pagina
        formapago = request.getParameter("seleccionador");//recibe el valor recibido de seleccionado
        } else if(request.getParameter("seleccionador")==null){//verifica si no recibe la forma de pago del cliente de otra pagina
        formapago = e.getPago().get(0);}//recibe el tipo de pago que realizara el cliente de dbnumero.txt
        %>
        
      <form method="post"  action="Comprado.jsp">
        <table style=" font-size:50px" size= "50px">
            <tr>
            <td> Nombre: </td>
            <td> <% out.println(e.getDbCliente().get(id).getNombre());%></td>
            </tr>
            <tr>
            <td> DPI: </td>
            <td> <% out.println(e.getDbCliente().get(id).getDpi());%></td>
            </tr>
            <tr>
            <td> Direccion: </td>
            <td> <% out.println(e.getDbCliente().get(id).getDireccion());%></td>
            </tr>
            <tr>
            <td> Telefono: </td>
            <td> <% out.println(e.getDbCliente().get(id).getTelefono());%></td>
            </tr>
             <tr>
            <td>Tipo de Pago: </td>
            <td> <% out.println(formapago);%></td>
            </tr>
            <%
            out.println("<tr>");
            out.println("<td>Seleccione el menu: </td>");
            out.println("<td><select name='seleccion'> ");
            for(int i=0; i<e.getDbmenu().size(); i++){
                aux = e.getDbmenu().get(i).getDescripcion();
                aux2 = e.getDbmenu().get(i).getTotal();
            out.println("<option value='"+ i +"'> Menu "+(i+1)+": "+aux + "( A solo " +aux2+ ")"+ "</option>");
            
            }
            out.println("</select></td>");
            out.println("</tr>");
            %>
            </table>
            <%out.println("<input type='text' style='visibility:hidden' name='formapago'  value='"+formapago+"'>");%>
            <%out.println("<input type='text' style='visibility:hidden' name='id'  value='"+id+"'>");%>
            
            <p></p>
            <input type="submit" value="Comprar" style="background-color: black; color:white; font-size:50px;">
        </form>
        <form action="VistaPregunta.jsp" method="post">
            <input type="submit" value="Regresar a Menu" style="background-color: black; color:white; font-size:50px;">
            <p></p>
            <%out.println("<input type='text' style='visibility:hidden' name='id'  value='"+id+"'>");%>
        </form>
    </center>
    </body>
</html>
