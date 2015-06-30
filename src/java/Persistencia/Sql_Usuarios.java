package Persistencia;

/**
 *
 * @author Equipo electrosoft
 */
public class Sql_Usuarios {
    
    public static String autenticar() { //Crear el metodo autenticar para validar el usuario
        return "SELECT * FROM usuarios1 where codigo_usuario = ? and contrasena = ?";
        /**
         * seleccione los campos de la tabla usuarios de la base de datos
         * ? porque no sabemos que va a digitar el usuario en el inicio de sesion
         * 
         */
    }
    public static String Crear() {//COMPLETAR
        return "insert into usuarios1 (codigo_usuario,contrasena,tipo_usuario) values (?,?,?)";
       
    }
    
    public static String Modificar(){
        return "update usuarios1 set contrasena=?,tipo_usuario=?  where codigo_usuario=?";
    }
    
     public static String Buscar(String codigo_usuario) {
         return "SELECT * from usuarios1 where codigo_usuario = "+codigo_usuario+"";
     }
     
     public static String Eliminar() { //drop elimina toda la tabla y delete elimina los campos
         return "delete from usuarios1 where codigo_usuario= ?";
     }
     
     public static String getUsuarios(String ced) {
         if(ced != null) {
             return "SELECT  codigo_usuario,contrasena,tipo_usuario from usuarios1 where codigo_usuario like '%"+ced+"%' order by codigo_usuario asc"; 
         }else{
             return null;
         }
     }
     
     public static String getUsuarios() {
         return "SELECT  codigo_usuario,contrasena,tipo_usuario from usuarios1 order by codigo_usuario asc";
     }
     
}

