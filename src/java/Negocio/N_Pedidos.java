/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Persistencia.Dao_Pedidos;
import entidades.Ent_Pedidos;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;
/**
 *
 * @author USUARIO
 */
public class N_Pedidos {
     Dao_Pedidos daoUsuarios;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
 
    public int crear(Ent_Pedidos pedidos) {
        daoUsuarios = new Dao_Pedidos();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuarios.crear(c, pedidos);
        return resultadoCrear;
    }
    public int modificar(Ent_Pedidos pedidos) {
        daoUsuarios = new Dao_Pedidos();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuarios.modificar(c, pedidos);
        return resultadoModificar;
    }
 
    public Ent_Pedidos Buscar(String identificacion) {
         daoUsuarios = new Dao_Pedidos();
        c = new Conexion().getCon();
       Ent_Pedidos resultadoBuscar = daoUsuarios.Buscar(c, identificacion);
        return resultadoBuscar;
    }

    public int eliminar(Ent_Pedidos pedidos) {
        daoUsuarios = new Dao_Pedidos();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuarios.eliminar(c, pedidos);
        return resultadoEliminar;
    }

     public List<Ent_Pedidos> ListarPedidos()  {
            daoUsuarios=new Dao_Pedidos();
        c=new Conexion().getCon();
        return daoUsuarios.ListarPedidos(c);
    }

    
}