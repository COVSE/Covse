package Persistencia;

/**
 *
 * @author Equipo electrosoft
 */
public class Sql_Factura {
    
    public static String autenticar() { //Crear el metodo autenticar para validar el usuario
        return "SELECT * FROM factura where codigo_factura = ? and codigo_producto = ?";
        /**
         * seleccione los campos de la tabla usuarios de la base de datos
         * ? porque no sabemos que va a digitar el usuario en el inicio de sesion
         * 
         */
    }
    public static String Crear() {//COMPLETAR
        return "insert into factura (codigo_factura, fecha_factura, valor_total, IVA, codigo_cliente, codigo_producto, cantidad, valor_unitario) values (?,?,?,?,?,?,?,?)";
       
    }
    
    public static String Modificar(){
        return "update factura set codigo_factura=?,fecha_factura=?,valor_total=?,IVA=?,codigo_cliente=?, codigo_producto=?,cantidad=?, valor_unitario=? where codigo_factura=?";
    }
    
     public static String Buscar(String codigo_factura) {
         return "SELECT * from factura where codigo_factura = "+codigo_factura+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from factura where codigo_factura= ?";
     }
     
     public static String getFactura(String codfac) {
         if(codfac != null) {
             return "SELECT codigo_factura, fecha_factura, valor_total, IVA, codigo_cliente, codigo_producto, cantidad, valor_unitario, from factura where codigo_factura like '%"+codfac+"%' order by codigo_factura asc"; 
         }else{
             return null;
         }
     }
     
     
    static String getFactura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}





