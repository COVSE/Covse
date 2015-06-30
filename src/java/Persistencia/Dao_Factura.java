package Persistencia;

import entidades.Ent_Factura;
import java.sql.Connection;// Conexion a la base de datos
import java.sql.PreparedStatement; // Prepara la consulta con la base de datos
import java.sql.ResultSet;// encargado de guardar las consultas en una variable
import java.sql.SQLException;// controlar los errores
import java.util.ArrayList; // organiza la informacion conla base de datos
import java.util.List;
import java.util.logging.Level;//mensaje de error en validacion del usuario
import java.util.logging.Logger; //mensaje de error en validacion del usuario

/**
 *
 * @author equipo Electrosoft
 */
public class Dao_Factura {
    
    
        public String autenticar (Connection c, Ent_Factura factura){
        String sql = Sql_Factura.autenticar();//Valores de la consulta Sql_usuarios
        String resultado = null;//Guardar los valores que traiga de la base de datos
        try {
            PreparedStatement st = c.prepareStatement (sql);
            //La variable se prepare para recibir la conexion y el valor del usuario y la contraseña
            
            ResultSet rs = null;
            //Guarda el resultado de lo que se trae
            
            st.setString(1, factura.getcodigo_factura());
            //Devuelva un string, el primer campo de la clase usuario coja el getUsuario
            st.setString(6, factura.getcodigo_producto());
            rs = st.executeQuery();
            //Ejecute la sentencia sql y guarde toda la informacion de Ent_usuario
            
            if(rs.next()) {
                //Si rs tiene informacion entonces el resultado es verdadero
                resultado = "1";
            } else {
                resultado = "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
            //Si lo anterior no se cumple muestra un mensaje
        } finally {
            try { 
                c.close();//Cerrar la base de datos
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
        //Para saber si rs si guardo la informacion. 1 guardo 0 no encontro
    }
        
        
    public List <Ent_Factura> Listarfactura (Connection con){ // me crea la matriz donde se mostraral la informacion
        
        List<Ent_Factura> resul= new ArrayList<Ent_Factura>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Factura.getFactura());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
                Ent_Factura c=new Ent_Factura();
                  c.setcodigo_factura(r.getString(1));
                  c.setfecha_factura(r.getString(2));
                  c.setvalor_total(r.getString(3));
                  c.setIVA(r.getString(4));
                  c.setcodigo_cliente(r.getString(5));//Llevar y traer los datos
                  c.setcodigo_producto(r.getString(6));
                  c.setcantidad(r.getString(7));
                  c.setvalor_unitario(r.getString(8));//COMPLETAR
                  
                  
                
                
               
                
                 
                  
                
                resul.add(c);// adiciona a c lo que trajo
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            try {
                con.close();
            } catch (Exception ex){  }
            
        }
        return resul;
    }
    
    public int crear (Connection c,Ent_Factura factura) {
        
        String sql=Sql_Factura.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
           
            st.setString(1, factura.getcodigo_factura());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(2, factura.getfecha_factura());
            st.setString(3, factura.getvalor_total());
            st.setString(4, factura.getIVA());
            st.setString(5, factura.getcodigo_cliente());
            st.setString(6, factura.getcodigo_producto());
            st.setString(7, factura.getcantidad());
            st.setString(8, factura.getvalor_unitario());
           
            
            
            resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_Factura factura) {
        String sql = Sql_Factura.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
            st.setString(1, factura.getcodigo_factura());//Primary key porque el dato no se modifica
            st.setString(2, factura.getfecha_factura());
            st.setString(3, factura.getvalor_total());
            st.setString(4, factura.getIVA());
            st.setString(5, factura.getcodigo_cliente());
            st.setString(6, factura.getcodigo_producto());
            st.setString(7, factura.getcantidad());
            st.setString(8, factura.getvalor_unitario());
            
            
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_Factura Buscar(Connection con, String codigo_factura) {
        Ent_Factura c = new Ent_Factura();
        c.setcodigo_factura("La factura no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Factura.Buscar(codigo_factura));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setcodigo_factura(r.getString(1));
                c.setfecha_factura(r.getString(2));
                c.setvalor_total(r.getString(3));
                c.setIVA(r.getString(4));
                c.setcodigo_cliente(r.getString(5));
                c.setcodigo_producto(r.getString(6));
                c.setcantidad(r.getString(7));
                c.setvalor_unitario(r.getString(8));
                
                
               
               
               
               
               
            }
        } catch (Exception e) {
            e.printStackTrace();
            return c;

        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }

        }
        return c;
    }

 public int eliminar(Connection c, Ent_Factura factura) {
        String sql = Sql_Factura.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(8, factura.getcodigo_factura());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }

    
}
