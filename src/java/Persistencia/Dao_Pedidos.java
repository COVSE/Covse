/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_Pedidos;
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
public class Dao_Pedidos {
      public List <Ent_Pedidos> ListarPedidos(Connection con){ // me crea la matriz donde se mostraral la informacion
       
        List<Ent_Pedidos> resul= new ArrayList<Ent_Pedidos>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Pedidos.getPedidos());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
               Ent_Pedidos c=new Ent_Pedidos();
                  c.setCodigo_pedido(r.getString(1));
                  c.setCodigo_proveedor(r.getString(2));
                  c.setCodigo_producto(r.getString(3));
                  c.setCantidad(r.getString(4));
                  c.setValor_unitario(r.getString(5));//Llevar y traer los datos
                  c.setIVA(r.getString(6));
                  c.setFecha_pedido(r.getString(7));
                  
               
                
                  
                         
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
    
    public int crear (Connection c,Ent_Pedidos pedidos) {
        
        String sql=Sql_Pedidos.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
                st.setString(1, pedidos.getCodigo_pedido());
                st.setString(2, pedidos.getCodigo_proveedor());//coge el dato del formulario y lo lleva a la base de datos
                st.setString(3, pedidos.getCodigo_producto());
                st.setString(4, pedidos.getCantidad());
                st.setString(5, pedidos.getValor_unitario());
                st.setString(6, pedidos.getIVA());
                st.setString(7, pedidos.getFecha_pedido());
               
            
         
            
              resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_Pedidos pedidos) {
        String sql = Sql_Pedidos.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
           st.setString(1,  pedidos.getCodigo_pedido());
            st.setString(2,  pedidos.getCodigo_proveedor());//coge el dato del formulario y lo lleva a la base de datos
            st.setString(3,  pedidos.getCodigo_producto());
              st.setString(4,  pedidos.getCantidad());
              st.setString(5,  pedidos.getValor_unitario());
              st.setString(6,  pedidos.getIVA());
              st.setString(7,  pedidos.getFecha_pedido());
                
            //PRIMARY KEY porque no se modifica
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_Pedidos Buscar(Connection con, String codigo_pedido) {
  Ent_Pedidos c = new Ent_Pedidos();
        c.setCodigo_pedido("el pedido no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Pedidos.Buscar(codigo_pedido));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                    c.setCodigo_pedido(r.getString(1));
                    c.setCodigo_proveedor(r.getString(2));
                    c.setCodigo_producto(r.getString(3));
                    c.setCantidad(r.getString(4));
                    c.setValor_unitario(r.getString(5));
                    c.setIVA(r.getString(6));
                    c.setFecha_pedido(r.getString(7));
                 
               
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

 public int eliminar(Connection c, Ent_Pedidos pedidos) {
        String sql = Sql_Pedidos.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, pedidos.getCodigo_pedido());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
}
