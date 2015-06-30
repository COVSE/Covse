/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author USUARIO
 */
public class Sql_Pedidos {
     
    public static String Crear() {
        return "insert into Pedidos (codigo_pedido,codigo_proveedor,codigo_producto,cantidad,valor_unitario,IVA,fecha_pedido) values (?,?,?,?,?,?,?)";
       }
    
    public static String Modificar(){
        return "update Pedidos set  codigo_proveedor=?,codigo_producto=?,cantidad=?,valor_unitario=?,IVA=?,fecha_pedido=?  where codigo_pedido=?";
    }
    
     public static String Buscar(String codigo_pedido) {
         return "SELECT * from Pedidos where codigo_pedido = "+codigo_pedido+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from Pedidos where codigo_pedido= ?";
     }
     
     public static String getPedidos(String codigo_pedido) {
         if(codigo_pedido != null) {
             return "SELECT codigo_proveedor,codigo_producto,cantidad,valor_unitario,IVA,fecha_pedido from Pedidos where codigo_pedido like '%"+codigo_pedido+"%' order by codigo_pedido asc"; 
         }else{
             return null;
         }
     }
     
     public static String getPedidos() {
         return "SELECT codigo_proveedor,codigo_producto,cantidad,valor_unitario,IVA,fecha_pedido from Pedidos order by codigo_pedido asc";
     }
    
}

