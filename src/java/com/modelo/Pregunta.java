
package com.modelo;

/**** @author Guillermo Marroquin No. Carne:0900-16-6266*/

/*Este es el modelo de las preguntas que contiene su id, respuesta, hijo iz, hijo de y 
tambien su punto de equilibrio que servira para el arbol AVL se almacenan en dbpregunta3.txt por medio de gson*/

public class Pregunta {
   int id, fe;
    String pregunta;
    String Respuesta;
    private Pregunta hijoiz;
    private Pregunta hijode;
    
    public Pregunta(int id, String pregunta, String respuesta){
        
        this.id = id;
        this.pregunta = pregunta;
        this.Respuesta= respuesta;
        this.hijoiz= null;
        this.hijode = null;
    }

    public Pregunta() {
        this.fe = 0;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.Respuesta = respuesta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

  
    public Pregunta getHijoiz() {
        return hijoiz;
    }

    public void setHijoiz(Pregunta hijoiz) {
        this.hijoiz = hijoiz;
    }

    public Pregunta getHijode() {
        return hijode;
    }

    public void setHijode(Pregunta hijode) {
        this.hijode = hijode;
    }

    @Override
    public int hashCode() {
        return this.id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
