
//Definimos los paquetes
package utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    public Connection Con;//Llevamos la conexion a una variable Con

    public Connection getCon() {

        ConexionDB();

        return Con;

    }

    public void setCon(Connection Con) {

        this.Con = Con;

    }

    public Conexion() { // constructor

    }

    static {

        try {

        /* Para mysql

        Class.forName("com.mysql.jdbc.Driver").newInstance();

*/

// String driverName = "oracle.jdbc.driver.OracleDriver";

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

        } catch (ClassNotFoundException e1) {

            System.out.println("ClassNotFoundException" + e1.getMessage());

        } catch (InstantiationException e2) {

            System.out.println("InstantiationException" + e2.getMessage());

        } catch (IllegalAccessException e3) {

            System.out.println("IllegalAccessException" + e3.getMessage());

        } catch (Exception e) {

            System.out.println("Exception" + e.getMessage());

        }

    }

    public void ConexionDB() {

        String host="localhost";

        String puerto="1521";

        String SID="xe";

        String user="COVSE1";

        String password="123";

        try {

       /*ok */ DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        // setCon(DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+puerto+":"+SID, "prueba" ,"123"));

        /*ok*/

        /*ok */ setCon(DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+puerto+":"+SID, user ,password));

        // /* para mysql

        // setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/mibd", "juan", "123"));

        //*/

        } catch (SQLException e4) {

            System.out.print("SQLException e4 " + e4.getMessage() + e4.getErrorCode());

        } catch (Exception e5) {

            System.out.print("SQLException e5" + e5.getMessage());

        }

    }

    public static void main(String param[]) {

        Conexion Connection = new Conexion();

        try {

        ResultSet r = Connection.getCon().prepareStatement("Select * from usuarios1").executeQuery();

        if (r.next()) {

            System.out.println("Usuario: " + " " + r.getString(1) + " Contrasena: " + r.getString(2));

            while (r.next()) {

            System.out.println("Usuario: " + " " + r.getString(1) + " Contrasena: " + r.getString(2));

            }

        } else {

            System.out.println("No hay datos");

        }

        } catch (Exception e) {

            System.out.println("Excepcion " + e.getMessage());

        } finally {

        }

    }

}