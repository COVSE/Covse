package Persistencia;

/**
 *
 * @author Equipo electrosoft
 */
public class Sql_Clientes{
   
    
    public static String Crear() {
        return "insert into Clientes insert into Clientes (codigo_cliente,nombre_cliente,apellido_cliente,direccion,ciudad,telefono,celular,correo)  values (?,?,?,?,?,?,?,?)";
       }
    
    public static String Modificar(){
        return "update Clientes set  nombre_cliente=?,apellido_cliente=?,direccion=?,ciudad=?,telefono=?,celular=?,correo=?  where codigo_cliente=?";
    }
    
     public static String Buscar(String codigo_cliente) {
         return "SELECT * from Clientes where codigo_cliente = "+codigo_cliente+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from Clientes where codigo_cliente= ?";
     }
     
     public static String getClientes(String codigo_cliente) {
         if(codigo_cliente != null) {
             return "SELECT codigo_cliente,nombre_cliente,apellido_cliente,direccion,ciudad,telefono,celular,correo from Clientes where codigo_cliente like '%"+codigo_cliente+"%' order by codigo_cliente asc"; 
         }else{
             return null;
         }
     }
     
     public static String getClientes() {
         return "SELECT codigo_cliente,nombre_cliente,apellido_cliente,direccion,ciudad,telefono,celular,correo from Clientes order by codigo_cliente asc";
     }
     
}
