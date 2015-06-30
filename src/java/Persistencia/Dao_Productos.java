/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_Productos;
import entidades.Ent_Productos;
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
 * @author USUARIO
 */
public class Dao_Productos {
      public List <Ent_Productos> ListarProductos(Connection con){ // me crea la matriz donde se mostraral la informacion
       
        List<Ent_Productos> resul= new ArrayList<Ent_Productos>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Productos.getProductos());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
               Ent_Productos c=new Ent_Productos();
                  c.setCodigo_producto(r.getString(1));
                  c.setNombre_producto(r.getString(2));
                  c.setPrecio(r.getString(3));
                  c.setCantidad_disponible(r.getString(4));
                    c.setMarca(r.getString(5));//Llevar y traer los datos
                  
               
                
                  
                         
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
    
    public int crear (Connection c,Ent_Productos productos) {
        
        String sql=Sql_Productos.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
           st.setString(1, productos.getCodigo_producto());
            st.setString(2, productos.getNombre_producto());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(3, productos.getPrecio());
              st.setString(4, productos.getCantidad_disponible());
                st.setString(5, productos.getMarca());
               
            
         
            
              resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_Productos productos) {
        String sql = Sql_Productos.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
           st.setString(5, productos.getCodigo_producto());
            st.setString(1, productos.getNombre_producto());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(2, productos.getPrecio());
              st.setString(3, productos.getCantidad_disponible());
              st.setString(4, productos.getMarca());
                
            //PRIMARY KEY porque no se modifica
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_Productos Buscar(Connection con, String codigo_producto) {
  Ent_Productos c = new Ent_Productos();
        c.setCodigo_producto("el producto no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Productos.Buscar(codigo_producto));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setCodigo_producto(r.getString(1));
                  c.setNombre_producto(r.getString(2));
                  c.setPrecio(r.getString(3));
                  c.setCantidad_disponible(r.getString(4));
                    c.setMarca(r.getString(5));
                 
               
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

 public int eliminar(Connection c, Ent_Productos productos) {
        String sql = Sql_Productos.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, productos.getCodigo_producto());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
}
