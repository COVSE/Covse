/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author USUARIO
 */
public class Sql_Productos {
     
    public static String Crear() {
        return "insert into Productos (codigo_producto,nombre_producto,precio,cantidad_disponible,marca) values (?,?,?,?,?)";
       }
    
    public static String Modificar(){
        return "update Productos set  nombre_producto=?,precio=?,cantidad_disponible=?, marca=?  where codigo_producto=?";
    }
    
     public static String Buscar(String codigo_producto) {
         return "SELECT * from Productos where codigo_producto = "+codigo_producto+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from Productos where codigo_producto= ?";
     }
     
     public static String getProductos(String codigo_producto) {
         if(codigo_producto != null) {
             return "SELECT codigo_producto,nombre_producto,precio,cantidad_disponible,marca from Productos where codigo_producto like '%"+codigo_producto+"%' order by codigo_producto asc"; 
         }else{
             return null;
         }
     }
     
     public static String getProductos() {
         return "SELECT codigo_producto,nombre_producto,precio,cantidad_disponible,marca from Productos order by codigo_producto asc";
     }
    
}
