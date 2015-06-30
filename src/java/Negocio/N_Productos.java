/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Persistencia.Dao_Productos;
import entidades.Ent_Productos;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;
/**
 *
 * @author USUARIO
 */
public class N_Productos {
     Dao_Productos daoUsuarios;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
 
    public int crear(Ent_Productos clientes) {
        daoUsuarios = new Dao_Productos();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuarios.crear(c, clientes);
        return resultadoCrear;
    }
    public int modificar(Ent_Productos clientes) {
        daoUsuarios = new Dao_Productos();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuarios.modificar(c, clientes);
        return resultadoModificar;
    }
 
    public Ent_Productos Buscar(String identificacion) {
         daoUsuarios = new Dao_Productos();
        c = new Conexion().getCon();
       Ent_Productos resultadoBuscar = daoUsuarios.Buscar(c, identificacion);
        return resultadoBuscar;
    }

    public int eliminar(Ent_Productos clientes) {
        daoUsuarios = new Dao_Productos();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuarios.eliminar(c, clientes);
        return resultadoEliminar;
    }

     public List<Ent_Productos> ListarProductos()  {
            daoUsuarios=new Dao_Productos();
        c=new Conexion().getCon();
        return daoUsuarios.ListarProductos(c);
    }

    
}
    

