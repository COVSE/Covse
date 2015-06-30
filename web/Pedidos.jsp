<%@page import="entidades.Ent_Pedidos" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");
    String codigo_pedido = request.getParameter("codigo_pedido");
    String codigo_proveedor = request.getParameter("codigo_proveedor");
    String codigo_producto = request.getParameter("codigo_producto");
    String cantidad = request.getParameter("cantidad");
    String valor_unitario = request.getParameter("valor_unitario");
    String IVA = request.getParameter("IVA");
    String fecha_pedido = request.getParameter("fecha_pedido");
    
    
    
    Ent_Pedidos x = request.getAttribute("cli") != null ? (Ent_Pedidos) request.getAttribute("cli") : null;
    if (x != null) {
        codigo_pedido = x.getCodigo_pedido();
        codigo_proveedor = x.getCodigo_proveedor();
        codigo_producto = x.getCodigo_producto();
        cantidad = x.getCantidad();
        valor_unitario = x.getValor_unitario();
        IVA = x.getIVA();
        fecha_pedido = x.getFecha_pedido();
        
        
        
        
        
        
    }
    
    List<Ent_Pedidos> LU = request.getAttribute("ListarPedidos") != null ? (List<Ent_Pedidos>) request.getAttribute("ListarPedidos") : null;
    
%>

<html>
    <head>
        <title>Pedidos</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
   <link rel="stylesheet" href="estilos/estilomenu.css">
    <link type="text/css" href="menu.css" rel="stylesheet" />
    <link type="text/css" href="bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="estilos/craftyslide.css" />
    <link type="text/css" href="estilos/cuadro.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="engine0/style.css" />
     
       <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="menu.js"></script>
    <script languaje="javascript" type="text/javascript" src="./js/Validacion.js" ></script>
    
    </head>
    <BODY BACKGROUND="Imagenes/f1.jpg">
        
        
       <div class="container cuadroa">  
<H1><LEFT> <FONT COLOR="#FFFAFA" SIZE="7" FACE="Century Gothic"> <CENTER>  </CENTER></FONT></H1>
    <center><img style="width:1213px;" src="Imagenes/banner23.png"></center>
 
 <style type="text/css">
* { margin:0;
    padding:0;
    
}


div#copyright a:hover { color:#F00000; }
div#menu {
  top: 255px;
   
   width:88%;
   left:100px;
}

#tablita{
    float: right;
    
}
</style>

<div id="menu">
    <ul class="menu">
                            <li><a href="Productos.jsp" class="parent"><span>Productos</span></a>
                            <li><a href="Clientes.jsp" class="parent"><span>Clientes</span></a>
                            <li><a href="Proveedores.jsp" class="parent"><span>Proveedores</span></a>
                            <li><a href="Factura.jsp" class="parent"><span>Facturaci&oacute;n</span></a>
                                <li><a href="Registrarse.jsp" class="parent"><span>Registrar</span></a>
                            <li><a href="subindex.jsp" class="parent"><span>Regresar al Menú</span></a>
                            <li><a href="index.jsp" class="parent"><span>Salir</span></a>
                                
                                    
             </ul>
            
            </div>
    
    
                
        
        
    



<br /><br /><br /><br /><br />

        <table align="center">
    
                <td width="900" align="center" bgcolor="white" style="width: 1257px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannerpedi.png" style='width:504px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroPedidos" method="get">
                            <tr>
                            <td>Código del pedido<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_proveedor" maxlength="60" onkeypress="return validar (event)" value="<%=codigo_proveedor != null ? codigo_proveedor : ""%>"></td>    
                            <td>Fecha del pedido <font color="blue">*</font></td>
                            <td><input type="date" name="fecha_pedido" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=fecha_pedido != null ? fecha_pedido : ""%>"></td>
                            <tr>
                            <td>Código del producto<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_proveedor" maxlength="60" onkeypress="return validarNumeros (event)" value="<%=codigo_proveedor != null ? codigo_proveedor : ""%>"></td>
                            <td>IVA <font color="blue">*</font></td>
                            <td><input type="text" name="IVA" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=IVA != null ? IVA : ""%>"></td>
                            
                            </tr>
                            <tr> <td>Valor unitario <font color="blue">*</font></td>
                            <td><input type="text" name="valor_total" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=valor_unitario != null ? valor_unitario : ""%>"></td>
                            <td>Cantidad<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_proveedor" maxlength="60" onkeypress="return validarNumeros (event)" value="<%=codigo_proveedor != null ? codigo_proveedor : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Código del proveedor<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_proveedor" maxlength="60" onkeypress="return validarNumeros (event)" value="<%=codigo_proveedor != null ? codigo_proveedor : ""%>"></td>
                           
                            
                            
                            </tr>
                            
                            <tr>
                            <td colspan="4" align="center"><br>Los campos con <font color="blue">*</font> son obligatorios</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                               
                                    <button name="action" value="crear" style="height:29px; width:96px" type="submit"><img src="Imagenes/Crear1.png"></button>
                                    <button name="action" value="modificar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Modificar1.png"></button>
                                    <button name="action" value="eliminar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Anular1.png"></button>
                                    <button name="action" value="limpiar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Limpiar1.png"></button>
                                    <button name="Lista" value="Listar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Listar1.png"></button>
                                    <button name="action" value="consultar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Consultar1.png"></button>
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                           <form action="./MaestroPedidos" method="post" class="letra">
                    <%if (LU == null) {%> <h4>No hay informaci&oacute;n para mostrar</h4>
                    <%} else {%> <br>

                    <table table border="1">
                        
                        <tr>
                            <td>Código del pedido</td>
                            <td>Fecha pedido</td>
                            <td>Código del producto</td>
                            <td>IVA</td>
                            <td>Valor unitario</td>
                            <td>Cantidad</td>
                            <td>Codigo del proveedor</td>
                            
                            
                            
                            
                            
                            
                            
                        </tr>
                        <%for (Ent_Pedidos user : LU) {%>
                        <tr>
                            <td><%=user.getCodigo_proveedor()%></td>
                            <td><%=user.getCodigo_proveedor()%></td>
                            <td><%=user.getCodigo_producto()%></td>
                            <td><%=user.getCantidad()%></td>
                            <td><%=user.getIVA()%></td>
                            <td><%=user.getFecha_pedido()%></td>
                            
                            
                            
                            
                            
                            
                            
                        </tr>
                        <%}%>
                    </table>
                </form>
                <%}%>      
                </td>
            </tr>
        </table>
                <center><FONT color="black" SIZE="5">Síguenos en:</font><br>
<A HREF="https://www.facebook.com/covsepolitecnico"><img src="Imagenes/face.png" height="50" width="50"></a>

<A HREF="https://www.youtube.com/watch?v=X5Wkp1gsNik"><img src="Imagenes/you.png" height="50" width="50"></a>
                <center><div id="copyright">Copyright&copy; 2014 - Página creada por Covse - Todos los derechos resevados</div></center>
    </body>
</html>
