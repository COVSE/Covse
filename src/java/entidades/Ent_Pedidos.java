/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Equipo electrosoft
 */
public class Ent_Pedidos {

String codigo_pedido;
String codigo_proveedor;
String codigo_producto;
String cantidad;
String valor_unitario;
String IVA;
String fecha_pedido;

    
    
    
   
    
    

    public Ent_Pedidos() {
    }

    public Ent_Pedidos(String codigo_pedido,String codigo_proveedor,String codigo_producto,String cantidad,String valor_unitario,String IVA,String fecha_pedido) {
        
        this.codigo_pedido= codigo_pedido;
        this.codigo_proveedor = codigo_proveedor;
        this.codigo_producto = codigo_producto;
        this.codigo_pedido= codigo_pedido;
        this.cantidad= cantidad;
        this.valor_unitario= valor_unitario;
        this.fecha_pedido= fecha_pedido;
        
        
        
       
        }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    
    

    
}
