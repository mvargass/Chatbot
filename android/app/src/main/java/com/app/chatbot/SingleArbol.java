package com.app.chatbot;

import com.app.chatbot.Model.Arbol;

/**
 * Created by Mario on 24/05/2018.
 */

public class SingleArbol {
    private static Arbol arbol = null;
    public static Arbol getInstance(){
        if(arbol == null)
            arbol = new Arbol();
        return arbol;
    }
}
