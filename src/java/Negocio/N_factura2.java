/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Persistencia.Dao_Factura2;
import entidades.Ent_Factura;
import java.sql.Connection;
import utilidades.Conexion;

/**
 *
 * @author Sebas
 */
public class N_factura2 {
      Dao_Factura2 daoFactura;//A una variable le doy las caracteristicas de la clase
    Connection c;
       public Ent_Factura Buscar(String codfac_factura) {
         daoFactura = new Dao_Factura2();
        c = new Conexion().getCon();
        Ent_Factura resultadoBuscar = daoFactura.Buscar(c, codfac_factura);
        return resultadoBuscar;
    }
}
