
package com.controlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.Cliente;
import com.modelo.Pedidos;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.modelo.DbData;
import com.modelo.Pregunta;
import com.modelo.Menu;
import com.modelo.PreguntaNoContestada;
import com.modelo.Cuenta;
/**** @author Grupo 1 **/
/* @author Mario Roberto Vargas Solares  No. Carne. 0900-16-4037*/
public class ControllerPregunta {
    private Pregunta pregunta;
    private Cliente nodo1;
    private Pedidos nodo2;
    private Cuenta nodo3;
    private DbData<Cuenta> dbcuenta;
    private DbData<Pregunta> dbpregunta;
    private DbData<Cliente> dbcliente;
    private DbData<Pedidos> dbpedidos;
    private DbData<PreguntaNoContestada> dbpregunno;
    private DbData<PreguntaNoContestada> dbcontestacion;
    private DbData<Menu> dbmenu;
    private DbData<String> formapago;
    private DbData<Integer> dbnumero;
    List<Integer> numero;
    private Date fecha;
    private Random aleatorio;
    private int io;
    private String otrarespuesta;
    private String pe;
    private String nombre="";
    
    
    public ControllerPregunta(Pregunta pregunta, Cliente nodo1, Pedidos nodo2 ) {
        this.pregunta = pregunta;
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
    }

    public ControllerPregunta(HttpServletRequest request) throws IOException, ServletException{//se pide la ubicacion del archivo del JSP para la ubicacion de los archivos de texto
        this.nodo1 = new Cliente();
        this.nodo2 = new Pedidos();
        this.nodo3 = new Cuenta();
        this.aleatorio = new Random();
        this.fecha = new Date();
        this.numero = new ArrayList<Integer>();
        this.dbcuenta = new DbData(Cuenta.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbcuenta.txt");
        this.dbcliente= new DbData(Cliente.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbcliente.txt" );
        this.dbpedidos = new DbData(Pedidos.class, generar_ruta(request) +"\\EstructuraDeDatos\\dbpedidos.txt");
        this.dbcontestacion = new DbData(PreguntaNoContestada.class ,generar_ruta(request) + "\\EstructuraDeDatos\\dbconversacion.txt");
        this.dbpregunno = new DbData(PreguntaNoContestada.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbnocontestada.txt");
        this.dbnumero = new DbData(Integer.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbnumero.txt");
        this.dbpregunta = new DbData(Pregunta.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbpregunta3.txt");
         this.dbmenu = new DbData(Menu.class, generar_ruta(request) + "\\EstructuraDeDatos\\dbmenu.txt");
        this.formapago = new DbData(String.class, generar_ruta(request) +"\\EstructuraDeDatos\\dbformpago.txt");
        this.otrarespuesta = "Hola, En este momento esta pregunta no esta disponible :(";
    }
    
    //ESTA FUNCION SE ENCARGA DE LOCALIZAR LA UBICACION DE LA CARPETA QUE CONTIENE LOS RESPECTIVOS ARCHIVOS TXT 
    public String generar_ruta(HttpServletRequest request )throws ServletException, IOException{
    ServletContext srvcon = request.getServletContext();
    String rutafisica = srvcon.getRealPath("Recursos");
    return rutafisica;
    }
    
    //ESTA FUNCION DEVUELVE LAS PREGUNTAS UBICADAS EN DBPREGUNTA3.TXT
    public Pregunta getPregunta() {
        return pregunta;
    }

    //ESTA FUNCION DEVUELVE LOS PEDIDOS UBICADOS EN DBPEDIDOS.TXT
    public List<Pedidos> getPedidos() throws FileNotFoundException {
        return dbpedidos.getAll();
    }
    
    //ESTA FUNCION DEVUELVE LAS PREGUNTAS NO CONTESTADAS UBICADO EN DBNOCONTESTADA.TXT
    public List<PreguntaNoContestada> getPregunno() throws FileNotFoundException {
        return dbpregunno.getAll();
    }

    //ESTA FUNCION DEVUELVE LA CONVERSACION QUE ESTA UBICADA EN DBCONVERSACION.TXT
    public List<PreguntaNoContestada> getConvestacion() throws FileNotFoundException {
        return dbcontestacion.getAll();
    }
    
    //ESTA FUNCION SE ENCARGA DE VERIFICAR QUE LOS CLIENTES ESTEN REGISTRADOS EN DBCLIENTE.TXT
    public void pedir_datos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    int contador; 
    String nombre,contra;
    contador=1; 
    
    nombre= request.getParameter("Nombre");
    contra = request.getParameter("Contrasenia");
    
    
    
    for(int u= 0; u<dbcuenta.getAll().size(); u++){
        if(dbcuenta.getAll().get(u).getNombre().equals(nombre)){
            io = u;
            u = dbcuenta.getAll().size()+1;
            System.out.println(io);
            numero.add(io);
            dbnumero.add(io);
            dbnumero.addAll(numero);
            response.sendRedirect("http://localhost:8080/ChatRestaurante/VistaPregunta.jsp");
        } else if((nombre.equals(dbcuenta.getAll().get(u).getNombre()))==false){
                   contador = contador + 1;
                }
    }
  
    }
    
    //DEVUELVE LA LISTA DE LOS CLIENTES DE DBCLIENTE.TXT
    public List<Cliente> getDbCliente() throws FileNotFoundException{
        return dbcliente.getAll();
    }

    //DEVUELVE LA LISTA DE LOS MENUS DISPONIBLES DE DBMENU.TXT
    public List<Menu> getDbmenu() throws FileNotFoundException {
        return dbmenu.getAll();
    }
 
    //ESTA FUNCION SE ENCARGA DE REGISTRAR LOS CLIENTES QUE NO ESTAN REGISTRADOS
    public int registrar_(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        nodo1 = new Cliente();
        nodo3 = new Cuenta();
        String nombre, direccion, dpi, fecha, nit, telefono;
        
        nombre = request.getParameter("nombre");
        direccion = request.getParameter("direccion");
        dpi = request.getParameter("dpi");
        fecha = request.getParameter("fecha");
        nit = request.getParameter("nit");
        telefono = request.getParameter("telefono");
                    
                    //CREACION DEL CLIENTE
                    nodo1.setId(dbcliente.getAll().size()+1);
                    nodo1.setNombre(nombre);
                    nodo1.setDireccion(direccion);        
                    nodo1.setDpi(dpi);           
                    nodo1.setFecha(fecha);          
                    nodo1.setNit(nit);          
                    nodo1.setTelefono(telefono);
                    dbcliente.add(nodo1);
                    
                    //CREACION DE CUENTA
                    nodo3.setId(dbcliente.getAll().size()+1);
                    nodo3.setNombre(nombre);
                    nodo3.setContra(nombre);
                    dbcuenta.add(nodo3);
                      
                    if(dbcliente.getAll().size()>1){
                    io = dbcliente.getAll().size()-1;} 
                    if(dbcliente.getAll().size()==0){ io = 0;}
                    //System.out.println(io);
                    
                    
     return io;           
    }

    //ESTA OBTIENE EL PUNTO DE EQUILIBRIO QUE TIENE LA RESPECTIVA PREGUNTA
    public int obtenerFE(Pregunta nodo){
        int aux;
        
        if(nodo==null){
        aux = -1;
        }
        
        else{
        
        aux = nodo.getFe();
        }
        
        return aux;
    }
    
    //ESTA FUNCION REALIZA UNA ROTACION SIMPLE HACIA LA IZQUIERDA DE LAS PREGUNTAS PARA EQUILIBRAR EL ARBOL
    public Pregunta rotacionSimple_iz(Pregunta c){
        Pregunta auxiliar=c.getHijoiz();
        c.setHijoiz(auxiliar.getHijode());
        auxiliar.setHijode(c);
        c.setFe(Math.max(obtenerFE(c.getHijoiz()), obtenerFE(c.getHijode()))+1);
        auxiliar.setFe(Math.max(obtenerFE(auxiliar.getHijoiz()), obtenerFE(auxiliar.getHijode()))+1);
        return auxiliar;
    }
    
    //ESTA FUNCION REALIZA UNA ROTACION SIMPLE HACIA LA DERECHA DE LAS PREGUNTAS PARA EQUILIBRAR EL ARBOL
     public Pregunta rotacionSimple_de(Pregunta c){
        Pregunta auxiliar=c.getHijode();
        c.setHijode(auxiliar.getHijoiz());
        auxiliar.setHijoiz(c);
        c.setFe(Math.max(obtenerFE(c.getHijoiz()), obtenerFE(c.getHijode()))+1);
        auxiliar.setFe(Math.max(obtenerFE(auxiliar.getHijoiz()), obtenerFE(auxiliar.getHijode()))+1);
        return auxiliar;
    }
     
    //ESTA FUNCION REALIZA UNA ROTACION DOBLE HACIA LA IZQUIERDA DE LAS PREGUNTAS PARA EQUILIBRAR EL ARBOL 
    public Pregunta rotacionDouble_iz(Pregunta c){
    Pregunta temporal;
    c.setHijoiz(rotacionSimple_de(c.getHijoiz()));
    temporal = rotacionSimple_iz(c);
    return temporal;
    }
    
    //ESTA FUNCION REALIZA UNA ROTACION DOBLE HACIA LA DERECHA DE LAS PREGUNTAS PARA EQUILIBRAR EL ARBOL
    public Pregunta rotacionDouble_de(Pregunta c){
    Pregunta temporal;
    c.setHijode(rotacionSimple_iz(c.getHijode()));
    temporal = rotacionSimple_de(c);
    return temporal;
    }
    
    
    //ESTA FUNCION SE ENCARGA DE INSERTAR CADA PREGUNTA EN LOS HIJOS DE LA RAIZ Y REALIZAR LAS ROTACIONES NECESARIAS
    public Pregunta insertarAVL(Pregunta nuevo, Pregunta subAr){
        Pregunta nuevoPadre = subAr;
        if(nuevo.getId()<subAr.getId()){
            if(subAr.getHijoiz()==null){
                subAr.setHijoiz(nuevo);
            }else{
                subAr.setHijoiz(insertarAVL(nuevo, subAr.getHijoiz()));
                if((obtenerFE(subAr.getHijoiz())- obtenerFE(subAr.getHijode()))==2){
                    if(nuevo.getId()<subAr.getHijoiz().getId()){
                        nuevoPadre=rotacionSimple_iz(subAr);
                        
                    }else{
                        nuevoPadre=rotacionDouble_iz(subAr);
                    }
                }
            }
          
        }else if(nuevo.getId()>subAr.getId()){
            if(subAr.getHijode()==null){
                subAr.setHijode(nuevo);
            }else{
                subAr.setHijode(insertarAVL(nuevo, subAr.getHijode()));
            if(obtenerFE(subAr.getHijode())-(obtenerFE(subAr.getHijoiz()))==2){
                if(nuevo.getId()>subAr.getHijode().getId()){
                    nuevoPadre=rotacionSimple_de(subAr);
                    
                }else{
                    nuevoPadre=rotacionDouble_de(subAr);
                }
            }
            }
        
        }else{
       System.out.println("Dato repetido");
     
        }
        
        
        if((subAr.getHijoiz()==null)&&(subAr.getHijode()!=null)){
            subAr.setFe(subAr.getHijode().getFe()+1);
        }else if((subAr.getHijode()==null)&&(subAr.getHijoiz()!=null)){
            subAr.setFe(subAr.getHijoiz().getFe()+1);
        }else{
            subAr.setFe(Math.max(obtenerFE(subAr.getHijoiz()), obtenerFE(subAr.getHijode()))+1);
        }
        return nuevoPadre;
    }
    
    
    //ESTA FUNCION INSERTA CADA VALOR EN EL ARBOL AVL RAIZ DE OTRO MODO LO DIRIGE A INGRESAR A LOS HIJOS
    public void insertar(int d, String pre, String res){
       Pregunta nuevo = new Pregunta(d, pre, res);
        if(this.pregunta==null){
            //System.out.println(d + "Raiz");
            pregunta=nuevo;
            //Raiz = new Nodo(d);
        }else{
            pregunta=insertarAVL(nuevo, pregunta);
        }
        
    }
    
    //*****************************************************************//
    //Guillermo Abrahm Marroquin Marroquin No. Carne: 0900-16-6266*****//
    //ESTA FUNCION DEVUELVE LA REPRESENTACION DEL ARBOL AVL          //**
    /**/public void imprimir_arbol(Pregunta nodo){                   //**
    /**/if(nodo!=null){                                              //**
    /**/        nombre += (""+ nodo.getId()+ "");                    //**
    /**/        nombre += ("{");                                     //**
    /**/        imprimir_arbol(nodo.getHijoiz());                    //**
    /**/        nombre += ",";                                       //**   
    /**/        imprimir_arbol(nodo.getHijode());                    //**
    /**/        nombre += ("}");                                     //**   
    /**/}                                                            //**   
    /**/                                                             //**   
    /**/}                                                            //**
    /**ESTA FUNCION ELIMINA TODOS LOS VALORES DE MAS DE LA REPRESENTACION/**/
    /**/public String getNombre(){                                   //**
    /**/return this.nombre.replace("{,}", "").replace(",}", "}").replace("{,", "{");/**/
    /**/}                                                            //**
    //*****************************************************************//
    
    
    //ESTE ES UN AUXILIAR PARA INSERCION DE TODAS LAS PREGUNTAS, RESPUESTA, ID
    public void accion_insertar() throws FileNotFoundException{
        for(int i=0; i<this.dbpregunta.getAll().size(); i++){
            this.insertar(dbpregunta.getAll().get(i).getId(), dbpregunta.getAll().get(i).getPregunta(), dbpregunta.getAll().get(i).getRespuesta());
        }
    }
    
    //DEVUELVE EL NUMERO DEL CLIENTE QUE INICIO SESION EN LA LISTA DBCLIENTE.TXT
    public String numero_activo() throws FileNotFoundException{       
        String numero = String.valueOf(dbnumero.getAll().get(0));
        return numero;
    }
    
   //DEVUELVE LA RESPUESTA SEGUN LA PREGUNTA SOLICITADA
    public String retornorespuesta(){
        return this.otrarespuesta;
    }
    
    //ESTA FUNCION SE ENCARGA DE BUSCAR LA PREGUNTA EN TODO EL ARBOL AVL, Y DEPENDIENDO SI SE PARECE A LA PREGUNTA QUE EL
    //CLIENTE COLOCO DARA SU RESPECTIVA RESPUESTA
    public void realizar_pregunta(String d, Pregunta nodo) {
       pe = d;//ASIGNA LA PREGUNTA A LA VALOR PE
       String aux;
       
       if(nodo!=null){//CONDICIONA CUANDO EL NODO NO SEA NULO
        aux = nodo.getPregunta();//COLOCA LA PREGUNTA EN EL AUXILIAR
        if(nodo.getPregunta()!=null){//EVALUA QUE NO SEA NULA LA PREGUNTA
        if(aux.equals(d)){ otrarespuesta = nodo.getRespuesta(); }}//SI SE PARECE LA PREGUNTA CON LA PREGUNTA QUE EL CLIENTE ESCRIBIO LA DEVUELVE EN OTRARESPUESTA
        realizar_pregunta(d, nodo.getHijoiz());//BUSCA EN EL HIJO IZQUIERDO DEL NODO 
        realizar_pregunta(d, nodo.getHijode());//BUSCARA EN EL HIJO DERECHO DEL NODO
       }
       
    }
    
    //ESTE RECIBIRA EL NUMERO DEL CLIENTE QUE INICIO SESION
    public void set_Numero(int i){
     ArrayList<Integer> a = new ArrayList<Integer>();
     a.add(i);
     this.numero.addAll(a);
    }
    
    //ESTA FUNCION SE ENCARGA DE EVALUAR SI ALGUNAS DE LAS PREGUNTAS TIENE UNA ACCION A REALIZARSE
    public void arbol_decision(String respuesta, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<String> pago = new ArrayList<String>();  
        io = Integer.valueOf(request.getParameter("id"));
        
         if((respuesta.equals("quiero comprar un menu al credito")) || (respuesta.equals("al credito"))){
         a.add(io);
         this.numero.addAll(a);
         pago.add("Credito");
         formapago.addAll(pago);
         response.sendRedirect("http://localhost:8080/ChatRestaurante/Comprar.jsp");
        } else if((respuesta.equals("quiero comprar un menu al efectivo")|| (respuesta.equals("al efectivo")))){
            a.add(io);
            this.numero.addAll(a);
            pago.add("Efectivo");
            formapago.addAll(pago);
            response.sendRedirect("http://localhost:8080/ChatRestaurante/Comprar.jsp");
        } else if((respuesta.equals("quiero comprar un menu al debito"))||(respuesta.equals("quiero comprar al dedito")) || (respuesta.equals("al debito"))){
         a.add(io);
         this.numero.addAll(a);
         pago.add("Debito");
         formapago.addAll(pago);
         response.sendRedirect("http://localhost:8080/ChatRestaurante/Comprar.jsp");
        }else if((respuesta.equals("quiero comprar un menu al cheque")) || respuesta.equals("al cheque")){ 
        a.add(io);
         this.numero.addAll(a);
         pago.add("Cheque");
         formapago.addAll(pago);
         response.sendRedirect("http://localhost:8080/ChatRestaurante/Comprar.jsp");
        
        }else if(respuesta.equals("quiero cancelar un pedido") ||(respuesta.equals("quiero cancelar mi pedido"))){
         a.add(io);
         this.dbnumero.addAll(a);
         response.sendRedirect("http://localhost:8080/ChatRestaurante/CancelarPedido.jsp");
         
        }else if(respuesta.equals("cual es el especial del dia")){
            int aux;
            Random r = new Random();
            aux = r.nextInt(dbmenu.getAll().size());
            otrarespuesta = "El especial en este momento del dia es: " + dbmenu.getAll().get(aux).getDescripcion() 
            + " A solo: "+ dbmenu.getAll().get(aux).getTotal();
        }else if(respuesta.equals("que hora son") || respuesta.equals("chatbot que hora son")){
            Date fecha = new Date();
            otrarespuesta = "Son las: " + fecha.getHours()+ ":" + fecha.getMinutes();
        }else if((respuesta.equals("quiero ver mis pedidos")|| respuesta.equals("quiero ver mis ordenes"))){
            a.add(io);
            this.dbnumero.addAll(a);
            response.sendRedirect("http://localhost:8080/ChatRestaurante/ConsultaPedido.jsp");
        }else if((respuesta.equals("quiero consultar el menu") || respuesta.equals("quiero ver menu") || respuesta.equals("al menu") || respuesta.equals("quiero ver el menu") || respuesta.equals("al menu") || respuesta.equals("cuanto cuesta solo las papas fritas") || respuesta.equals("al menu"))){
            a.add(io);
            this.dbnumero.addAll(a);
            otrarespuesta = "...";
            response.sendRedirect("http://localhost:8080/ChatRestaurante/ConsultaMenu.jsp");
        }else if((respuesta.equals("como me llamo") || respuesta.equals("me puede decir como me llamo"))){
           int au;
            au = Integer.valueOf(this.numero_activo());
            otrarespuesta = "Claro tu nombre es: " + this.getDbCliente().get(au).getNombre();
        }else if(respuesta.equals("cerrar sesion")){
            response.sendRedirect("http://localhost:8080/ChatRestaurante/IniciarSesion.jsp");
        }else if(respuesta.equals("generar arbol avl")){
            this.imprimir_arbol(pregunta);
            otrarespuesta = this.getNombre();
        }
    }
    
    //ESTA FUNCION ES NECESARIA YA QUE ALMACENA EL TIPO DE PAGO QUE REALIZARA EL CLIENTE
    public List<String> getPago() throws FileNotFoundException{
    return formapago.getAll();
    }
    
    //ESTA FUNCION SE ENCARGA DE ESCRIBIR EN LOS PEDIDOS LA ORDEN SOLICITADA POR LOS CLIENTES
    public void comprar_menu(HttpServletRequest request, HttpServletResponse response ) throws FileNotFoundException, IOException{
        int menu;
        String formapago;
        formapago = request.getParameter("formapago");
        menu = Integer.valueOf(request.getParameter("seleccion"));
        io= Integer.valueOf(request.getParameter("id"));
            
            nodo2 = new Pedidos();
            System.out.println(dbpedidos.getAll().size()+1);
            nodo2.setId(dbpedidos.getAll().size()+1);
            nodo2.setNombre(dbcliente.getAll().get(io).getNombre());
            nodo2.setDescripcion(this.dbmenu.getAll().get(menu).getDescripcion());
            nodo2.setDireccion(dbcliente.getAll().get(io).getDireccion());
            nodo2.setNit(dbcliente.getAll().get(io).getNit());
            nodo2.setFecha(fecha.toString());
           
            nodo2.setTipo_pago(formapago);
            nodo2.setTotal(dbmenu.getAll().get(menu).getTotal());
            dbpedidos.add(nodo2);
    
    }
    
    
   //ESTA FUNCION SE ENCARGA DE EVALUAR SI LA PRENGUNTA REALIZADA NO FUE CONTESTADA Y COLOCARLA EN LAS PREGUNTAS NO CONSTESTADAS dbnocontestada.txt en el formato de la pregunta con su respectiva pregunta y un espacio para la respuesta
   public void designar_nopregunta() throws IOException{
       PreguntaNoContestada nocontestada = new PreguntaNoContestada();
       if((pe!=null) & (otrarespuesta.equals("Hola, En este momento esta pregunta no esta disponible :("))){
            
           nocontestada.setPregunta(pe);
           nocontestada.setRespuesta("...");
           this.dbpregunno.add(nocontestada);
           nocontestada.setPregunta(pe);
           nocontestada.setRespuesta(otrarespuesta);
            this.dbcontestacion.add(nocontestada);
       }
       
       else if((pe!=null) & ((otrarespuesta.equals("Hola, En este momento esta pregunta no esta disponible :("))==false)){
           nocontestada.setPregunta(pe);
           nocontestada.setRespuesta(otrarespuesta);
            this.dbcontestacion.add(nocontestada);
       }
   }
    
   //ESTA FUNCION SE ENCARGA DE CANCELAR EL PEDIDO QUE EL CLIENTE ORDENO
   public void cancelar_pedido(HttpServletRequest request, HttpServletResponse response)throws FileNotFoundException, IOException{
      int id, seleccion;
       id = Integer.valueOf(request.getParameter("id"));
       seleccion = Integer.valueOf(request.getParameter("seleccion"));
       this.dbpedidos.delete(dbpedidos.getAll().get(seleccion));
       response.sendRedirect("http://localhost:8080/ChatRestaurante/VistaPregunta.jsp");
    }
   
   //SIRVE PARA ARMAR EL ARBOL AVL
    public void operacion_() throws FileNotFoundException{
       System.out.println("Cargando datos");
       this.accion_insertar();
    }
    
    // SE ENCARGA DE LIMPIAR LA CONVERSACION UBICADA EN EL ARCHIVO DE dbconversacion.txt
    public void limpiar_listachat(){
       ArrayList<PreguntaNoContestada> vacio = new ArrayList<PreguntaNoContestada>();
        try {
            this.dbcontestacion.addAll(vacio);
        } catch (IOException ex) {
            Logger.getLogger(ControllerPregunta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}


