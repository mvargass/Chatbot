
package com.modelo;

/**** @author Guillermo Abraham Marroquin Marroquin No. Carne: 0900-16-6266*/
/*Este modelo servira para que el registro de las cuentas de los cliente con respectivos nombre como sus contraseñas por medio de gson*/
public class Cuenta {
    private int id;
    private String nombre;
    private String contra;

    public Cuenta(int id, String nombre, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
    }

    public Cuenta() {
        this.id = 0;
        this.nombre = "";
        this.contra = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public int hashCode() {
        return this.id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
