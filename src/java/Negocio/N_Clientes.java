/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Persistencia.Dao_Clientes;
import entidades.Ent_Clientes;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;
/**
 *
 * @author USUARIO
 */
public class N_Clientes {
     Dao_Clientes daoUsuarios;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
 
    public int crear(Ent_Clientes clientes) {
        daoUsuarios = new Dao_Clientes();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuarios.crear(c, clientes);
        return resultadoCrear;
    }
    public int modificar(Ent_Clientes clientes) {
        daoUsuarios = new Dao_Clientes();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuarios.modificar(c, clientes);
        return resultadoModificar;
    }
 
     public Ent_Clientes Buscar(String Codigo_cliente) {
         daoUsuarios = new Dao_Clientes();
        c = new Conexion().getCon();
       Ent_Clientes resultadoBuscar = daoUsuarios.Buscar(c, Codigo_cliente);
        return resultadoBuscar;
    }

    public int eliminar(Ent_Clientes clientes) {
        daoUsuarios = new Dao_Clientes();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuarios.eliminar(c, clientes);
        return resultadoEliminar;
    }

     public List<Ent_Clientes> ListarClientes()  {
            daoUsuarios=new Dao_Clientes();
        c=new Conexion().getCon();
        return daoUsuarios.ListarClientes(c);
    }

    
}
    
