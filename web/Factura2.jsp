<%@page import="entidades.Ent_Factura" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");
    String codigo_factura = request.getParameter("codigo_factura");
    String fecha_factura = request.getParameter("fecha_factura");
    String valor_total = request.getParameter("valor_total");
    String IVA = request.getParameter("IVA");
    String codigo_cliente = request.getParameter("codigo_cliente");
    String codigo_producto = request.getParameter("codigo_producto");
    String cantidad = request.getParameter("cantidad");
    String valor_unitario = request.getParameter("valor_unitario");
    
    
    
    
    Ent_Factura x = request.getAttribute("cli") != null ? (Ent_Factura) request.getAttribute("cli") : null;
    if (x != null) {
        codigo_factura = x.getcodigo_factura();
        fecha_factura = x.getfecha_factura();
        valor_total = x.getvalor_total();
        IVA = x.getIVA();
        codigo_cliente = x.getcodigo_cliente();
        codigo_producto = x.getcodigo_producto();
        cantidad = x.getcantidad();
        valor_unitario = x.getvalor_unitario();
        
        
        
        
        
        
        
    }
    
    List<Ent_Factura> LU = request.getAttribute("ListarFactura") != null ? (List<Ent_Factura>) request.getAttribute("ListarFactura") : null;
    
%>


<html>
    <head>
        <title>Factura</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <link type="text/css" href="estilos/Clientes.css" rel="stylesheet" />  
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
                            <li><a href="Productos.jsp" class="parent"><span>Productos</span></a></li>
                            <li><a href="Contactenos.jsp" class="parent"><span>Registrar</span></a></li>
                            <li><a href="index.jsp" class="parent"><span>Regresar al Menú</span></a></li>
                          
                          
                                
                                    
             </ul>
            
            </div>
    
    
                <br /><br /><br /><br /><br/>

        <table align="center">
    
                <td width="900" align="center" bgcolor="white" style="width: 1920px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannerfaccli.png" style='width:504px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroFactura" method="get">
                            <tr>
                           <td>Código de Factura <font color="blue">*</font></td>
                            <td><input type="text" name="codigo_factura" maxlength="60"  onkeypress="return validarNumeros (event)" value="<%=codigo_factura != null ? codigo_factura : ""%>"></td>
                            <td>Fecha de Factura <font color="blue">*</font></td>
                            <td><input type="date" name="fecha_factura" maxlength="30" onkeydown="return validar (event)" value="<%=fecha_factura != null ? fecha_factura : ""%>"></td>
                            </tr>
                            <tr><td>Valor Total <font color="blue">*</font></td>
                            <td><input type="text" name="valor_total" maxlength="30" onkeydown="return validarNumeros (event)" value="<%=valor_total != null ? valor_total: ""%>"></td>
                            <td>IVA<font color="blue">*</font></td>
                            <td><input type="text" name="IVA" maxlength="30" onkeydown="return validarNumeros (event)" value="<%=IVA != null ? IVA : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Código de producto <font color="blue">*</font></td>
                            <td><input type="text" name="codigo_producto" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=codigo_producto != null ? codigo_producto : ""%>"></td>
                            <td>Código de cliente <font color="blue">*</font></td>
                            <td><input type="text" name="codigo_cliente" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=codigo_cliente!= null ? codigo_cliente: ""%>"></td>
                            
                            </tr>
                            <tr><td>Cantidad <font color="blue">*</font></td>
                            <td><input type="text" name="cantidad" maxlength="30" onkeydown="return validarsoloNumeros(event)" value="<%=cantidad != null ? cantidad : ""%>"></td>
                            <td>Valor unitario <font color="blue">*</font></td>
                            <td><input type="text" name="valor_unitario" maxlength="30" onkeydown="return validar (event)" value="<%=valor_unitario != null ? valor_unitario : ""%>"></td>
                           
                           
                            </tr>
                            
                            <tr>
                           <br></br>
                                <td align="center" colspan="4">
                               
                                     <br></br> <br></br> 
                                    <button name="action" value="limpiar" class="boton limpiar"style="height:29px; width:96px" type="submit"></button>
                                 
                                     <button name="action" value="consultar" class="boton consultar"style="height:29px; width:96px" type="submit"></button>
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                                  <form action="./MaestroFactura2" method="post" class="letra">
                    <%if (LU == null) {%> 
                    <%} else {%> <br>

                    <table table border="1">
                        
                        <tr>
                            <td>codigo factura</td>
                            <td>fecha factura</td>
                            <td>valor total</td>
                            <td>IVA</td>
                            <td>codigo cliente</td>
                            <td>Código del producto</td>
                            <td>cantidad</td>
                            <td>valor unitario</td>
                           
                            
                            
                            
                            
                            
                            
                            
                        </tr>    </div>
                        <%for (Ent_Factura user : LU) {%>
                        <tr>
                            <td><%=user.getcodigo_factura()%></td>
                            <td><%=user.getfecha_factura()%></td>
                            <td><%=user.getvalor_total()%></td>
                            <td><%=user.getIVA()%></td>
                            <td><%=user.getcodigo_cliente()%></td>
                            <td><%=user.getcodigo_producto()%></td>
                            <td><%=user.getcantidad()%></td>
                            <td><%=user.getvalor_unitario()%></td>
                            
                           
                            
                            
                            
                            
                            
                            
                            
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

