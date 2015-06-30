/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Equipo covse
 */
public class Ent_Proveedores {
    String codigo_proveedor;
    String nombre_empresa;
    String Telefono;
    String Celular;
    String Correo;
    String Ciudad;
    String Pais;
    String Direccion;
    
    
    

    public Ent_Proveedores() {
    }

    public Ent_Proveedores(String codigo_proveedor,String nombre_empresa,String Telefono,String Celular,String Correo,String Ciudad,String Pais,String Direccion) {
        this.codigo_proveedor = codigo_proveedor;
        this.nombre_empresa = nombre_empresa;
        this.Telefono=Telefono;
        this.Celular = Celular;
        this.Correo= Correo;
        this.Ciudad= Ciudad;
        this.Pais= Pais;
        this.Direccion= Direccion;
        
        
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    
}   

   
   
   
   
   

    

    


   
