
package com.modelo;


/**** @author Guillermo Marroquin */
/*Este modelo servira para los menus que tiene el restaurante con sus propiedades como id, descripcion del menu y precio total del menu en el fichero dbmenu.txt por medio de gson*/
public class Menu {
    private int id;//id del menu
    private String descripcion;//descripcion del menu
    private Double Total;//precio total del menu

    //constructor con paramentros
    public Menu(int id, String descripcion, Double Total) {
        this.id = id;
        this.descripcion = descripcion;
        this.Total = Total;
    }
    
    //constructor sin parametros y declaracion de valores por defecto
    public Menu(){
        this.id = 0;
        this.descripcion = "";
        this.Total = 0.0;
    }
    
    /*get que envian el atributo que esta privado y los set que reciben los datos para establecerlos en los atributos*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    @Override
    public int hashCode() {
        return this.id; //Para cambiar el cuerpo de metodo generado, elegir herramienta | plantillas
    }
    
    
    
}
