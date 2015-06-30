/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;//Nombre paquete

import Persistencia.Dao_Usuarios;
import entidades.Ent_usuario;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;

/**
 *
 * @author Equipo electrosoft
 */
public class N_Usuarios {
    
    Dao_Usuarios daoUsuarios;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
    public String autenticar (Ent_usuario usuario){
        daoUsuarios = new Dao_Usuarios();
        c = new Conexion().getCon();
        String resultado = daoUsuarios.autenticar(c, usuario);
        /**Guarda el metodo autenticar
         * Tambien la conexion y la variable
         */
        
        return resultado;
    }
    public int crear(Ent_usuario usuarios) {
        daoUsuarios = new Dao_Usuarios();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuarios.crear(c, usuarios);
        return resultadoCrear;
    }
    public int modificar(Ent_usuario usuarios) {
        daoUsuarios = new Dao_Usuarios();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuarios.modificar(c, usuarios);
        return resultadoModificar;
    }
 
    public Ent_usuario Buscar(String codigo_usuario) {
         daoUsuarios = new Dao_Usuarios();
        c = new Conexion().getCon();
        Ent_usuario resultadoBuscar = daoUsuarios.Buscar(c, codigo_usuario);
        return resultadoBuscar;
    }

    public int eliminar(Ent_usuario usuarios) {
        daoUsuarios = new Dao_Usuarios();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuarios.eliminar(c, usuarios);
        return resultadoEliminar;
    }

     public List<Ent_usuario> ListarUsuarios()  {
            daoUsuarios=new Dao_Usuarios();
        c=new Conexion().getCon();
        return daoUsuarios.ListarUsuarios(c);
    }

    
}
