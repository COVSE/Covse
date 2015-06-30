/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author Sebas
 */
public class Sql_Factura2 {
     public static String Buscar(String codigo_factura) {
         return "SELECT * from factura where codigo_factura = "+codigo_factura+"";
     }
     
    
    
}
