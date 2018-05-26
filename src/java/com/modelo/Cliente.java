/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**** @author Guillermo Marroquin No. Carne:0900-16-6266*/
/* Este es el modelo servira para generar el registro de los datos de los clientes en el archivo dbcliente.txt por medio gson*/
public class Cliente {
    private int id;
    private String nombre;
    private String fecha;
    private String nit;
    private String direccion;
    private String telefono;
    private String dpi;

    public Cliente(int id, String nombre, String fecha, String nit, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.nit = nit;
        this.direccion = direccion;
    }
    
    public Cliente(){
        this.id = 0;
        this.nombre = "";
        this.fecha = "";
        this.direccion = "";
        this.telefono = "";
        this.nit= "";
        this.dpi = "";
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    @Override
    public int hashCode() {
        return this.id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

