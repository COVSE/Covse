/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_Clientes;
import entidades.Ent_Clientes;
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
public class Dao_Clientes {
      public List <Ent_Clientes> ListarClientes(Connection con){ // me crea la matriz donde se mostraral la informacion
       
        List<Ent_Clientes> resul= new ArrayList<Ent_Clientes>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Clientes.getClientes());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
               Ent_Clientes c=new Ent_Clientes();
                  c.setCodigo_cliente(r.getString(1));
                  c.setNombre_cliente(r.getString(2));
                  c.setApellido_cliente(r.getString(3));
                  c.setDireccion(r.getString(4));
                    c.setCiudad(r.getString(5));//Llevar y traer los datos
                    c.setTelefono(r.getString(6));
                    c.setCelular(r.getString(7));
                    c.setCorreo(r.getString(8));
                  
               
                
                  
                         
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
    
    public int crear (Connection c,Ent_Clientes clientes) {
        
        String sql=Sql_Clientes.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
           st.setString(1, clientes.getCodigo_cliente());
            st.setString(2, clientes.getNombre_cliente());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(3, clientes.getApellido_cliente());
              st.setString(4, clientes.getDireccion());
                st.setString(5, clientes.getCiudad());
                st.setString(6, clientes.getTelefono());
                st.setString(7, clientes.getCelular());
                st.setString(8, clientes.getCorreo());
               
            
         
            
              resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_Clientes clientes) {
        String sql = Sql_Clientes.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
           st.setString(8, clientes.getCodigo_cliente());
            st.setString(1, clientes.getNombre_cliente());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(2, clientes.getApellido_cliente());
              st.setString(3, clientes.getDireccion());
              st.setString(4, clientes.getCiudad());
              st.setString(5, clientes.getTelefono());
              st.setString(6, clientes.getCelular());
              st.setString(7, clientes.getCorreo());
                
            //PRIMARY KEY porque no se modifica
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_Clientes Buscar(Connection con, String Codigo_cliente) {
  Ent_Clientes c = new Ent_Clientes();
        c.setCodigo_cliente("el cliente no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Clientes.Buscar(Codigo_cliente));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setCodigo_cliente(r.getString(1));
                c.setNombre_cliente(r.getString(2));
                c.setApellido_cliente(r.getString(3));
                c.setDireccion(r.getString(4));
                c.setCiudad(r.getString(5));
                c.setTelefono(r.getString(6));
                c.setCelular(r.getString(7));
                c.setCorreo(r.getString(8));
                 
               
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

 public int eliminar(Connection c, Ent_Clientes clientes) {
        String sql = Sql_Clientes.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, clientes.getCodigo_cliente());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
}
