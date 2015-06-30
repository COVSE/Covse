<%@page import="entidades.Ent_Productos" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");
      String codigo_producto = request.getParameter("codigo_producto");
    String nombre_producto = request.getParameter("nombre_producto");
    String precio = request.getParameter("precio");
    String cantidad_disponible = request.getParameter("cantidad_disponible");
     String marca = request.getParameter("marca");
   
    
    
   Ent_Productos x = request.getAttribute("cli") != null ? (Ent_Productos) request.getAttribute("cli") : null;
    if (x != null) {
         codigo_producto= x.getCodigo_producto();
        nombre_producto = x.getNombre_producto();
        precio = x.getPrecio();
         cantidad_disponible = x.getCantidad_disponible();
         marca= x.getMarca();
        
       
    }
    
    List<Ent_Productos> LU = request.getAttribute("ListarProductos") != null ? (List<Ent_Productos>) request.getAttribute("ListarProductos") : null;
    
%>

<html>
    <head>
        <title>Productos</title>
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
                            <li><a href="Pedidos.jsp" class="parent"><span>Pedidos</span></a>
                            <li><a href="Clientes.jsp" class="parent"><span>Clientes</span></a>
                            <li><a href="Proveedores.jsp" class="parent"><span>Proveedores</span></a>
                            <li><a href="Factura.jsp" class="parent"><span>Facturaci&oacute;n</span></a>
                                <li><a href="Registrarse.jsp" class="parent"><span>Registrar</span></a>
                            <li><a href="subindex.jsp" class="parent"><span>Regresar al Menú</span></a>
                            <li><a href="index.jsp" class="parent"><span>Salir</span></a>
                                
                                    
             </ul>
            
            </div>
    
    
                <br /><br /><br /><br /><br/>

        <table align="center">
            
    
                <td width="900" align="center" bgcolor="white" style="width: 1257px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannerprod.png" style='width:504px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroProduc" method="get">
                            <tr>
                              <td>Código de producto<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_producto" maxlength="30" onkeypress="return validarNumeros(event)" value="<%= codigo_producto != null ? codigo_producto : ""%>"></td>
                            </tr>
                                                        <tr>
                            <td>Nombre de producto<font color="blue">*</font></td>
                            <td><input type="text" name="nombre_producto" maxlength="30" onkeypress="return validarsololetras(event)" value="<%= nombre_producto != null ? nombre_producto : ""%>"></td>
                            <td>Valor unitario<font color="blue">*</font></td>
                            <td><input type="text" name="precio" maxlength="30" onkeypress="return validarNumeros(event)" value="<%= precio != null ?  precio : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Cantidad disponible <font color="blue">*</font></td>
                            <td><input type="text" name="cantidad_disponible" maxlength="30" onkeypress="return validarNumeros(event)" value="<%=cantidad_disponible != null ? cantidad_disponible : ""%>"></td>
                            <td>Marca <font color="blue">*</font></td>
                            <td><input type="text" name="marca" maxlength="30" maxlength="30" onkeypress="return validar(event)" value="<%= marca != null ?  marca : ""%>"></td>
                            </tr>
                          
                            <tr>
                            <td colspan="4" align="center"><br>Los campos con <font color="blue">*</font> son obligatorios</td>
                            </tr>
                              <tr>
                                <td align="center" colspan="4">
                                
                                    <button name="action" value="crear" class="boton crear" style="height:29px; width:96px" type="submit"><img src="Imagenes/Crear1.png"></button>
                                    <button name="action" value="modificar"class="boton modificar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Modificar1.png"></button>
                                    <button name="action" value="eliminar" class="boton eliminar" style="height:29px; width:96px" type="submit"><img src="Imagenes/Eliminar1.png"></button>
                                    <button name="action" value="limpiar" class="boton limpiar"style="height:29px; width:96px" type="submit"><img src="Imagenes/Limpiar1.png"></button>
                                    <button name="Lista" value="Listar" class="boton listar"style="height:29px; width:96px" type="submit"><img src="Imagenes/Listar1.png"></button>
                                     <button name="action" value="consultar" class="boton consultar"style="height:29px; width:96px" type="submit"><img src="Imagenes/Consultar1.png"></button>
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                            
                           <form action="./MaestroProduc" method="post" class="letra">
                    <%if (LU == null) {%> <h4>No hay informaci&oacute;n para mostrar</h4>
                    <%} else {%> <br>

                <table table border="1">
                    
                        
                        <tr>
                            <td>Codigo producto</td>
                            <td>Nombre producto</td>
                            <td>Valor unitario</td>
                            <td>Cantidad disponible</td>
                            <td>Marca</td>
                            
                           </tr>
                        <%for (Ent_Productos user : LU) {%>
                        <tr>
                            <td><%=user.getCodigo_producto()%></td>
                            <td><%=user.getNombre_producto()%></td>
                            <td><%=user.getPrecio()%></td>
                            <td><%=user.getCantidad_disponible()%></td>
                             <td><%=user.getMarca()%></td>
                         
                         
                                               
                                         
                            
                         
                        
                            
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


