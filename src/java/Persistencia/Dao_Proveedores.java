/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_Proveedores;
import entidades.Ent_Proveedores;
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
public class Dao_Proveedores {
      public List <Ent_Proveedores> ListarProveedores(Connection con){ // me crea la matriz donde se mostraral la informacion
       
        List<Ent_Proveedores> resul= new ArrayList<Ent_Proveedores>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Proveedores.getProveedores());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
               Ent_Proveedores c=new Ent_Proveedores();
                  c.setCodigo_proveedor(r.getString(1));
                  c.setNombre_empresa(r.getString(2));
                  c.setTelefono(r.getString(3));
                  c.setCelular(r.getString(4));
                  c.setCorreo(r.getString(5));//Llevar y traer los datos
                  c.setCiudad(r.getString(6));
                  c.setPais(r.getString(7));
                  c.setDireccion(r.getString(8));
                  
               
                
                  
                         
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
    
    public int crear (Connection c,Ent_Proveedores proveedores) {
        
        String sql=Sql_Proveedores.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
           st.setString(1, proveedores.getCodigo_proveedor());
           st.setString(2, proveedores.getNombre_empresa());//coge el dato del formulario y lo lleva a la base de datos
           st.setString(3, proveedores.getTelefono());
           st.setString(4, proveedores.getCelular());
           st.setString(5, proveedores.getCorreo());
           st.setString(6, proveedores.getCiudad());
           st.setString(7, proveedores.getPais());
           st.setString(8, proveedores.getDireccion());
               
            
         
            
              resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_Proveedores proveedores) {
        String sql = Sql_Proveedores.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
           st.setString(8, proveedores.getCodigo_proveedor());
           st.setString(1, proveedores.getNombre_empresa());//coge el dato del formulario y lo lleva a la base de datos
           st.setString(2, proveedores.getTelefono());
           st.setString(3, proveedores.getCelular());
           st.setString(4, proveedores.getCorreo());
           st.setString(5, proveedores.getCiudad());
           st.setString(6, proveedores.getPais());
           st.setString(7, proveedores.getDireccion());
                
            //PRIMARY KEY porque no se modifica
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_Proveedores Buscar(Connection con, String codigo_proveedor) {
  Ent_Proveedores c = new Ent_Proveedores();
        c.setCodigo_proveedor("el proveedor no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Proveedores.Buscar(codigo_proveedor));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setCodigo_proveedor(r.getString(1));
                c.setNombre_empresa(r.getString(2));
                c.setTelefono(r.getString(3));
                c.setCelular(r.getString(4));
                c.setCorreo(r.getString(5));
                c.setCiudad(r.getString(6));
                c.setPais(r.getString(7));
                c.setDireccion(r.getString(8));
                 
               
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

 public int eliminar(Connection c, Ent_Proveedores proveedores) {
        String sql = Sql_Proveedores.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, proveedores.getCodigo_proveedor());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
}
