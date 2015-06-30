/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Persistencia.Dao_Proveedores;
import entidades.Ent_Proveedores;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;
/**
 *
 * @author USUARIO
 */
public class N_Proveedores {
     Dao_Proveedores daoUsuarios;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
 
    public int crear(Ent_Proveedores proveedores) {
        daoUsuarios = new Dao_Proveedores();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuarios.crear(c, proveedores);
        return resultadoCrear;
    }
    public int modificar(Ent_Proveedores proveedores) {
        daoUsuarios = new Dao_Proveedores();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuarios.modificar(c, proveedores);
        return resultadoModificar;
    }
 
    public Ent_Proveedores Buscar(String identificacion) {
         daoUsuarios = new Dao_Proveedores();
        c = new Conexion().getCon();
       Ent_Proveedores resultadoBuscar = daoUsuarios.Buscar(c, identificacion);
        return resultadoBuscar;
    }

    public int eliminar(Ent_Proveedores proveedores) {
        daoUsuarios = new Dao_Proveedores();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuarios.eliminar(c, proveedores);
        return resultadoEliminar;
    }

     public List<Ent_Proveedores> ListarProveedores()  {
            daoUsuarios=new Dao_Proveedores();
        c=new Conexion().getCon();
        return daoUsuarios.ListarProveedores(c);
    }

    
}