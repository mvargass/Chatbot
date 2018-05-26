/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**** @author Guillermo Marroquin No. Carne:0900-16-6266*/
/* Este es el modelo servira para los pedidos realizados por el cliente en el fichero dbpedidos.txt por medio de gson*/
public class Pedidos {
    private int id;
    private String nombre;
    private String tipo_pago;
    private String nit;
    private String fecha;
    private String descripcion;
    private String direccion;
    private double total;

    public Pedidos(int id,String nombre, String tipo_pago, double total, String nit, String fecha, String descripcion, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_pago = tipo_pago;
        this.nit = nit;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.total = total;
        this.fecha = fecha;
    }
    
    public Pedidos(){
        this.id= 0;
        this.nombre = "";
        this.tipo_pago = "";
        this.nit = "";
        this.fecha = "";
        this.descripcion = "";
        this.direccion = ""; 
        this.total = 0.0;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    public void setTotal(double total){
    this.total= total;
    }
    
    public double getTotal() {
        return total;
    }

    public void setCantidad(double total) {
        this.total = total;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
    
    
}
   
