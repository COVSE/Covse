/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author USUARIO
 */
public class Ent_Clientes {
String codigo_cliente;
String nombre_cliente;
String apellido_cliente;
String direccion;
String ciudad;
String telefono;
String celular;
String correo;


     public Ent_Clientes() {
     }
         
 public Ent_Clientes(String Codigo_cliente,String nombre_cliente,String apellido_cliente,String direccion,String ciudad,String telefono,String celular,String correo){  
 
  this.codigo_cliente = Codigo_cliente;
     this.nombre_cliente=nombre_cliente;
        this.apellido_cliente = apellido_cliente;
         this.direccion = direccion;
         this.ciudad = ciudad;
         this.telefono = telefono;
        this.celular = celular;
        this.correo=correo;
       
 }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String Codigo_cliente) {
        this.codigo_cliente = Codigo_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
 
 }

          

