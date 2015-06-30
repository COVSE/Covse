/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidades.Ent_Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebas
 */
public class Dao_Factura2 {
    
       public Ent_Factura Buscar(Connection con, String codigo_factura) {
        Ent_Factura c = new Ent_Factura();
        c.setcodigo_factura("La factura no existe. Por favor verifique su código");
        try {
            PreparedStatement cl = con.prepareStatement(Sql_Factura.Buscar(codigo_factura));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setcodigo_factura(r.getString(1));
                c.setfecha_factura(r.getString(2));
                c.setvalor_total(r.getString(3));
                c.setIVA(r.getString(4));
                c.setcodigo_cliente(r.getString(5));
                c.setcodigo_producto(r.getString(6));
                c.setcantidad(r.getString(7));
                c.setvalor_unitario(r.getString(8));
                
                
               
               
               
               
               
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
    
}
