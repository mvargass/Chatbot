/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;
/*Este modelo servia para almacenar las pregunta no contestadas con las propiedades de su id que por defecto sera 0, la pregunta no contestada y la respuesta con '...' en dbnocontestada.txt por medio de gson, 
Esto ayudara a los desarrolladores para que solo coloque la debida respuesta, id y lo inserten en dbpregunta3.txt*/
/**** @author Guillermo Abraham Marroquin Marroquin No. Carne: 0900-16-6266*/
public class PreguntaNoContestada {
    private int id;
    private String pregunta;
    private String Respuesta;

    public PreguntaNoContestada() {
        this.id = 0;
        this.pregunta="";
        this.Respuesta="";
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
    
     @Override
    public int hashCode() {
        return this.id; //To change body of generated methods, choose Tools | Templates.
    }
    
}
