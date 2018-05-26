package com.app.chatbot.Model;

import java.util.ArrayList;

/**
 * Created by Mario on 23/05/2018.
 */

public class Nodo {
    private String valor;
    private ArrayList<Nodo> hijos;
    private int id;
    private int padre;

    Nodo(int id,int padre,String newData) {
        hijos = new ArrayList<>();
        valor = newData;
        this.id = id;
        this.padre = padre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }
}
