<%-- 
    Document   : VistaRespuesta
    Created on : 8/04/2018, 03:00:41 PM
    Author     : Grupo 1
    /* @authorSergio Fernando Sican Patzan  No. Carne. 0900-16-00602*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.controlador.ControllerPregunta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respuesta</title>
         <style>
             table, h1 {
            border: 20px solid rgba(0,0,0,0.3); -moz-background-clip: padding-box; -webkit-background-clip: padding-box; background-clip: padding-box;  }
         </style><%-- background-color: white;--%>
    </head>
    <body style=' background-image: url(http://localhost:8080/ChatRestaurante/Recursos/Imagenes/imagen3.jpg); background-repeat:  no-repeat; background-size:  cover'>
    <center>
        <%
            
            ControllerPregunta e = new ControllerPregunta(request);//declara el controlador y envia el request para envio de ruta de la pagina
            e.operacion_();//arma la estructura de datos
            int id= Integer.valueOf(request.getParameter("id"));//convierte id obtenido por otra pagina
            String nombre, convertidor;//declaracion de variables
            nombre= request.getParameter("pregunta");//recibe la pregunta dada por el usuario
            convertidor= nombre.toLowerCase();//convierte de las letras a minusculas
            String [] simbolos ={"," , ".", ";", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", "¡", "?", "¿", "/", "*", "+", "-", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", " 0", "   ", "  ", "â", "ã±"};//contiene todos los simbolos que se eliminaran
            
            for(int i=0; i<simbolos.length; i++){//realiza un ciclo hasta el numero de simbolos en la lista simbolos
            convertidor = convertidor.replace(simbolos[i] , "");//reemplaza todos los simbolos declarados por ''
            }
            
            e.realizar_pregunta(convertidor, e.getPregunta());//realiza la busqueda de la pregunta
            String respuesta = e.retornorespuesta();//declaracion de variable pregunta
            e.arbol_decision(convertidor, request, response);//busca en el arbol desicion si no existe una funcion que inicie con la pregunta
            e.designar_nopregunta();//verifica si existe la pregunta o no existe
            
            
       %>
       
       <h1 style=' background-color: white ; font-size: 50px; color: black; font: bold'>  <%out.println(respuesta);%> </h1>
       
            <h2 style=' background-color: brown; height: fit-content; font-size: 50px; text-align:center; color: white; font: bold'> Historial de Conversación: </h2>
      
        <table style=' <%--background-color: white;--%>  -webkit-background-size'>
            
        <%
           
        for(int i=0; i<e.getConvestacion().size(); i++){//imprime el historial de la conversacion
          
        out.println("<tr >");
        out.println("<td style='background-color: green; color:white; text-align:left; border-radius:5px; font-size: 50px; font: bold'> "+ e.getConvestacion().get(i).getPregunta() + "</td>");
        out.println("</tr>");
        out.println("<tr >");
        out.println("<td> <p></p> <td>");
        out.println("<td style='background-color: red ; color:white; text-align: right; font-size: 50px; border-radius:5px; font: bold'> "+ e.getConvestacion().get(i).getRespuesta() + "</td>");
        out.println("</tr>");
        }
                    
        %>
        </table>
        
        <h4></h4>
        <form method="post" action="VistaPregunta.jsp">
           
           <% out.println("<input type='text' value='"+id+"' style='visibility: hidden;' name='id'>"); //envia el id a vistapregunta.jsp%>
           <h4></h4>
           <input type="submit" value="Preguntar"  style=" background-color: black; color:white; font-size: 50px;" >
        </form>
    </center>
 
    </body>
</html>
