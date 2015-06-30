/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_usuario;
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
public class Dao_Usuarios {
    
    
        public String autenticar (Connection c, Ent_usuario usuario){
        String sql = Sql_Usuarios.autenticar();//Valores de la consulta Sql_usuarios
        String resultado = null;//Guardar los valores que traiga de la base de datos
        try {
            PreparedStatement st = c.prepareStatement (sql);
            //La variable se prepare para recibir la conexion y el valor del usuario y la contraseña
            
            ResultSet rs = null;
            //Guarda el resultado de lo que se trae
            
            st.setString(1, usuario.getCodigo_usuario());
            //Devuelva un string, el primer campo de la clase usuario coja el getUsuario
            st.setString(2, usuario.getContrasena());
            rs = st.executeQuery();
            //Ejecute la sentencia sql y guarde toda la informacion de Ent_usuario
            
            if(rs.next()) {
                //Si rs tiene informacion entonces el resultado es verdadero
                resultado = "1";
            } else {
                resultado = "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            //Si lo anterior no se cumple muestra un mensaje
        } finally {
            try { 
                c.close();//Cerrar la base de datos
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
        //Para saber si rs si guardo la informacion. 1 guardo 0 no encontro
    }
        
        
    public List <Ent_usuario> ListarUsuarios (Connection con){ // me crea la matriz donde se mostraral la informacion
        
        List<Ent_usuario> resul= new ArrayList<Ent_usuario>();
        try {
            
            PreparedStatement p= con.prepareStatement (Sql_Usuarios.getUsuarios());
            ResultSet r= p.executeQuery(); // guarda el resultado y ejecuta la sentencia sql
            while (r.next()) {
                
                Ent_usuario c=new Ent_usuario();
                
                  c.setCodigo_usuario(r.getString(1));
                  c.setContrasena(r.getString(2));//Llevar y traer los datos
                  c.setTipo_usuario(r.getString(3));
                  
                  //COMPLETAR
                
                
               
                
                 
                  
                
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
    
    public int crear (Connection c,Ent_usuario usuarios) {
        
        String sql=Sql_Usuarios.Crear(); //definiendo la variable sql que hereda las caracteristicas de la sentencia sql crear
        int resultadoCrear=0;
        try {
            PreparedStatement st=c.prepareStatement(sql); // prepara la consulta con la base de datos
           
                
            st.setString(1, usuarios.getCodigo_usuario());
            st.setString(2, usuarios.getContrasena());
            st.setString(3, usuarios.getTipo_usuario());
           
       
            
            
            resultadoCrear = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
            finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultadoCrear;
        }

    public int modificar(Connection c, Ent_usuario usuarios) {
        String sql = Sql_Usuarios.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);//Prepara la consulta
            
            
          st.setString(3, usuarios.getCodigo_usuario()); //PRIMARY KEY porque no se modifica
            st.setString(2, usuarios.getContrasena());
            st.setString(1, usuarios.getTipo_usuario());
           
          
            
            resultadoModificar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }

       public Ent_usuario Buscar(Connection con, String codigo_usuario) {
        Ent_usuario c = new Ent_usuario();
        c.setCodigo_usuario("La cuenta no existe. Por favor verifique los datos");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Usuarios.Buscar(codigo_usuario));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
               c.setCodigo_usuario(r.getString(1));
                c.setContrasena(r.getString(2));
                c.setTipo_usuario(r.getString(3));
           
               
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

 public int eliminar(Connection c, Ent_usuario Usuarios) {
        String sql = Sql_Usuarios.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, Usuarios.getCodigo_usuario());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Dao_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
    
}