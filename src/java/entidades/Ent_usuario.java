/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Equipo electrosoft
 */
public class Ent_usuario {
String codigo_usuario;
String contrasena;
String tipo_usuario;

    
      public Ent_usuario() {
    }

    public Ent_usuario(String codigo_usuario,String contrasena,String tipo_usuario) {
        
        this.codigo_usuario=codigo_usuario;
          this.contrasena = contrasena;
        this.tipo_usuario = tipo_usuario;
      
       
       
        }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }  
   
    
    



    

    

    
    
    }
   