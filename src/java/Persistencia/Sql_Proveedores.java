/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author USUARIO
 */
public class Sql_Proveedores {
     
    public static String Crear() {
        return "insert into Proveedores(codigo_proveedor,nombre_empresa,Telefono,Celular,Correo,Ciudad,Pais,Direccion) values (?,?,?,?,?,?,?,?)";
       }
    
    public static String Modificar(){
        return "update Proveedores set  nombre_empresa=?,Telefono=?,Celular=?,Correo=?,Ciudad=?,Pais=?,Direccion=?  where codigo_proveedor=?";
    }
    
     public static String Buscar(String codigo_proveedor) {
         return "SELECT * from Proveedores where codigo_proveedor = "+codigo_proveedor+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from Proveedores where codigo_proveedor= ?";
     }
     
     public static String getProveedores(String codigo_proveedor) {
         if(codigo_proveedor!= null) {
             return "SELECT codigo_proveedor,nombre_empresa,Telefono,Celular,Correo,Ciudad,Pais,Direccion from Proveedores where codigo_proveedor like '%"+codigo_proveedor+"%' order by codigo_proveedor asc"; 
         }else{
             return null;
         }
     }
     
     public static String getProveedores() {
         return "SELECT codigo_proveedor,nombre_empresa,Telefono,Celular,Correo,Ciudad,Pais,Direccion from Proveedores order by codigo_proveedor asc";
     }
    
}

