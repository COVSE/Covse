/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;//Nombre paquete

import Persistencia.Dao_Factura;
import entidades.Ent_Factura;
import java.sql.Connection;
import java.util.List;
import utilidades.Conexion;

/**
 *
 * @author Equipo electrosoft
 */
public class N_Factura {
    
    Dao_Factura daoFactura;//A una variable le doy las caracteristicas de la clase
    Connection c;
    
    public String autenticar (Ent_Factura factura){
        daoFactura = new Dao_Factura();
        c = new Conexion().getCon();
        String resultado = daoFactura.autenticar(c, factura);
        /**Guarda el metodo autenticar
         * Tambien la conexion y la variable
         */
        
        return resultado;
    }
    public int crear(Ent_Factura factura) {
        daoFactura = new Dao_Factura();
        c = new Conexion().getCon();
        int resultadoCrear = daoFactura.crear(c, factura);
        return resultadoCrear;
    }
    public int modificar(Ent_Factura factura) {
        daoFactura = new Dao_Factura();
        c = new Conexion().getCon();
        int resultadoModificar = daoFactura.modificar(c, factura);
        return resultadoModificar;
    }
 
    public Ent_Factura Buscar(String codfac_factura) {
         daoFactura = new Dao_Factura();
        c = new Conexion().getCon();
        Ent_Factura resultadoBuscar = daoFactura.Buscar(c, codfac_factura);
        return resultadoBuscar;
    }

    public int eliminar(Ent_Factura factura) {
        daoFactura = new Dao_Factura();
        c = new Conexion().getCon();
        int resultadoEliminar = daoFactura.eliminar(c, factura);
        return resultadoEliminar;
    }

     public List<Ent_Factura> ListarFactura()  {
            daoFactura=new Dao_Factura();
        c=new Conexion().getCon();
        return daoFactura.Listarfactura(c);
    }

    
}

