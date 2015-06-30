/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author USUARIO
 */
public class Ent_Productos {
     String codigo_producto;
    String nombre_producto;
    String precio;
    String cantidad_disponible;
    String  marca;
    

 public Ent_Productos() {
    }
 public Ent_Productos(String codigo_producto,String nombre_producto,String precio,String cantidad_disponible,String marca) {
        
        this.codigo_producto= codigo_producto;
        this.nombre_producto =nombre_producto;
        this.precio = precio;
        this.codigo_producto = codigo_producto;
        this.cantidad_disponible= cantidad_disponible;
        this. marca=  marca;
        
       }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(String cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}