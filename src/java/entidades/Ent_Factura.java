/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Equipo covse
 */
public class Ent_Factura {
    String codigo_factura;
    String fecha_factura;
    String valor_total;
    String IVA;
    String codigo_cliente;
    String codigo_producto;
    String cantidad;
    String valor_unitario;
   
    
    

    public Ent_Factura() {
    }

    public Ent_Factura(String codigofactura, String fechafactura, String valortotal, String IVA, String codigocliente, String codigoproducto, String cantidad, String valorunitario) {
        this.codigo_factura = codigofactura;
        this.fecha_factura = fechafactura;
        this.valor_total=valortotal;
        this.IVA = IVA;
        this.codigo_cliente= codigocliente;
        this.codigo_producto= codigoproducto;
        this.cantidad= cantidad;
        this.valor_unitario= valorunitario;
        
        
        
    }

    public String getcodigo_factura() {
        return codigo_factura;
    }
    
    public void setcodigo_factura(String codigo_factura) {
        this.codigo_factura = codigo_factura;
    }
    
    public String getfecha_factura() {
        return fecha_factura;
    }

    public void setfecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
    
    public String getvalor_total() {
        return valor_total;
    }

    public void setvalor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getIVA() {
        return IVA;
    }
    
    public void setIVA(String IVA) {
        this.IVA = IVA;
    }
    
     public String getcodigo_cliente() {
        return codigo_cliente;
    }

    public void setcodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getcodigo_producto() {
        return codigo_producto;
    }

    public void setcodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }
    
    public String getcantidad() {
        return cantidad;
    }

    public void setcantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getvalor_unitario() {
        return valor_unitario;
    }

    public void setvalor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
   
   
}   
