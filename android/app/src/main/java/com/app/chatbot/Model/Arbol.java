package com.app.chatbot.Model;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Mario on 23/05/2018.
 *
 */

public class Arbol {
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public Arbol() {
        raiz = null;
    }

    public void insertarHijo(int id,String valor, int padre){
        if(raiz==null)
            raiz = new Nodo(0, padre,  "");
        if(padre == 0)
            raiz.getHijos().add(new Nodo(id, padre, valor));
        else{
            for(Nodo nodo: raiz.getHijos()){
                if(nodo.getId() == padre){
                    nodo.getHijos().add(new Nodo(id, padre, valor));
                }
            }
        }
    }

    public void insertarHijo(int id, String valor){
        insertarHijo(id, valor,0);
    }
    public Nodo buscar(String valor){
        for(Nodo nodo: raiz.getHijos()){
                String[] palabrasClave = nodo.getValor().split(",");
            int coincidencias = 0;
            for(String s: palabrasClave){
                if(valor.toLowerCase().trim().contains(s.toLowerCase().trim()))
                    coincidencias++;
            }
            if(coincidencias>=1) return nodo;
        }
        return null;
    }
}
