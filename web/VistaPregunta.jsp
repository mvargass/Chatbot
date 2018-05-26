<%-- 
    Document   : VistaPregunta
    Created on : 8/04/2018, 01:05:33 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import ="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Bienvenido</title>
    </head>
    <body style="background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen1.jpg);   background-repeat: no-repeat; background-size: cover">
        <center>
         <% 
             
          ControllerPregunta p = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
           p.operacion_();//arma la estructura de datos
           String pregunta;//declaracion de variable pregunta
           String id = "";//inicia con un id y declaracion 0
           pregunta = request.getParameter("pregunta");//recibe la pregunta
                
                if(request.getParameter("id")!=null){//verifica si no recibe el id
                    id = request.getParameter("id");//lo asigna el id si lo recibe de otra pagina
                    
                }else if(request.getParameter("id")==null){//verifica si no recibe id
                    id = p.numero_activo();//lo busca en dbnumero.txt
                   
                }
          

        %>
        <h1  style="  background-color: brown; color: white; font-size: 100px">Hola Bienvenido, ¿En que te puedo Ayudar?</h1>
        <form method="post" action="VistaRespuesta.jsp">
            <table>
                <tr>
                    <td> <% out.println("<input style='visibility: hidden;' name='id' value="+id+">");//envio de id%> </td>
                </tr>
                <tr>
                    <td><input  style="  font-size: 50px" type="text" name="pregunta" id="pregunta" value="Hola"></td>
                    
                    <td><input style="font-size:50px; color:white; background-color: background; " type="submit" name="busqueda" id="busqueda" value=">" </td>
                    
                </tr>
               
            </table> 
                <p></p>
        </form>
                <form method="get" action="IniciarSesion.jsp">
                    <input type="submit" name="Cerrar" value="Cerrar Sesion" style=" background-color: black; color:white; font-size:50px; ">
                </form>
        </center>
    </body>
</html>
