<%@page import="entidades.Ent_Proveedores" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");
    String codigo_proveedor = request.getParameter("codigo_proveedor");
    String nombre_empresa = request.getParameter("nombre_empresa");
    String Telefono = request.getParameter("Telefono");
    String Celular = request.getParameter("Celular");
    String Correo = request.getParameter("Correo");
    String Ciudad = request.getParameter("Ciudad");
    String Pais = request.getParameter("Pais");
    String Direccion = request.getParameter("Direccion");
    
    
    
    
    Ent_Proveedores x = request.getAttribute("cli") != null ? (Ent_Proveedores) request.getAttribute("cli") : null;
    if (x != null) {
        codigo_proveedor = x.getCodigo_proveedor();
        nombre_empresa = x.getNombre_empresa();
        Telefono = x.getTelefono();
        Celular= x.getCelular();
        Correo = x.getCorreo();
        Ciudad = x.getCiudad();
        Pais = x.getPais();
        Direccion = x.getDireccion();
      
        
        
        
        
        
        
    }
    
    List<Ent_Proveedores> LU = request.getAttribute("ListarProveedores") != null ? (List<Ent_Proveedores>) request.getAttribute("ListarProveedores") : null;
    
%>


    <head>
        <title>Proveedores</title>
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
                            <li><a href="Factura.jsp" class="parent"><span>Facturaci&oacute;n</span></a>
                                <li><a href="Productos.jsp" class="parent"><span>Productos</span></a>
                                <li><a href="Registrarse.jsp" class="parent"><span>Registrar</span></a>
                            <li><a href="subindex.jsp" class="parent"><span>Regresar al Menú</span></a>
                            <li><a href="index.jsp" class="parent"><span>Salir</span></a>
                                
                                    
             </ul>
            
            </div>
    
    
                
        
        
    



<br /><br /><br /><br /><br />

        <table align="center">
    
                <td width="900" align="center" bgcolor="white" style="width: 1920px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannerprove.png" style='width:504px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroProveedores" method="get">
                            <tr>
                            <td>Código del Proveedor<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_proveedor" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=codigo_proveedor != null ? codigo_proveedor : ""%>"></td>
                            <td>Nombre de la Empresa <font color="blue">*</font></td>
                            <td><input type="text" name="nombre_empresa" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=nombre_empresa != null ? nombre_empresa : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Teléfono <font color="blue">*</font></td>
                            <td><input type="text" name="Telefono" maxlength="30" onkeydown="return validarNumeros (event)" value="<%=Telefono != null ? Telefono : ""%>"></td>
                            <td>Celular <font color="blue">*</font></td>
                            <td><input type="text" name="Celular" maxlength="30" onkeydown="return validarNumeros(event)" value="<%=Celular != null ? Celular : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Correo Electrónico <font color="blue">*</font></td>
                            <td><input type="text" name="Correo" maxlength="30" onkeypress="return validar (event)" value="<%=Correo != null ? Correo : ""%>"></td>
                            <td>Ciudad <font color="blue">*</font></td>
                            <td><input type="text" name="Ciudad" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=Ciudad != null ? Ciudad : ""%>"></td>
                            </tr>
                            <tr>
                            <td>País <font color="blue">*</font></td>
                            <td><input type="text" name="Pais" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=Pais != null ? Pais : ""%>"></td>
                            <td>Dirección <font color="blue">*</font></td>
                            <td><input type="text" name="Direccion" maxlength="30" onkeypress="return validar (event)" value="<%=Direccion != null ? Direccion : ""%>"></td>
                            </tr>
                            <tr>
                            <td colspan="4" align="center"><br>Los campos con <font color="blue">*</font> son obligatorios</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                
                                    <button name="action" value="crear" style="height:30px; width:96px" type="submit"><img src="Imagenes/Crear1.png"></button>
                                    <button name="action" value="modificar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Modificar1.png"></button>
                                    <button name="action" value="eliminar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Anular1.png"></button>
                                    <button name="action" value="limpiar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Limpiar1.png"></button>
                                    <button name="action" value="consultar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Consultar1.png"></button>
                                    <button name="Lista" value="Listar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Listar1.png"></button>
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                           <form action="./MaestroProveedores" method="post" class="letra">
                    <%if (LU == null) {%> <h4>No hay informaci&oacute;n para mostrar</h4>
                    <%} else {%> <br>

                    <table table border="1">
                        
                        <tr>
                            <td>Código Proveedor</td>
                            <td>Nombre Empresa</td>
                            <td>Teléfono</td>
                            <td>Celular</td>
                            <td>Correo Electrónico</td>
                            <td>Ciudad</td>
                            <td>País</td>
                            <td>Dirección</td>
                            
                            
                            
                            
                            
                            
                            
                            
                        </tr>
                        <%for (Ent_Proveedores user : LU) {%>
                        <tr>
                            <td><%=user.getCodigo_proveedor()%></td>
                            <td><%=user.getNombre_empresa()%></td>
                            <td><%=user.getTelefono()%></td>
                            <td><%=user.getCelular()%></td>
                            <td><%=user.getCorreo()%></td>
                            <td><%=user.getCiudad()%></td>
                            <td><%=user.getPais()%></td>
                            <td><%=user.getDireccion()%></td>
                            
                            
                            
                            
                            
                            
                            
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

