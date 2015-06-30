<%@page import="entidades.Ent_Clientes" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");
      String Codigo_cliente = request.getParameter("codigo_cliente");
    String nombre_cliente = request.getParameter("nombre_cliente");
    String apellido_cliente = request.getParameter("apellido_cliente");
    String direccion = request.getParameter("direccion");
     String ciudad = request.getParameter("ciudad");
    String telefono = request.getParameter("telefono");
    String celular = request.getParameter("celular");
    String correo = request.getParameter("correo");
  
    
    
    Ent_Clientes x = request.getAttribute("cli") != null ? (Ent_Clientes) request.getAttribute("cli") : null;
    if (x != null) {
         Codigo_cliente= x.getCodigo_cliente();
         nombre_cliente = x.getNombre_cliente();
         apellido_cliente = x.getApellido_cliente();
         direccion = x.getDireccion();
         ciudad= x.getCiudad();
         telefono = x.getTelefono();
         celular= x.getCelular();
         correo = x.getCorreo();
       
    }
    
    List<Ent_Clientes> LU = request.getAttribute("ListarClientes") != null ? (List<Ent_Clientes>) request.getAttribute("ListarClientes") : null;
    
%>

<html>
    <head>
        <title>Clientes</title>
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
                            <li><a href="Productos.jsp" class="parent"><span>Productos</span></a></li>
                            
                            <li><a href="Proveedores.jsp" class="parent"><span>Proveedores</span></a></li>
                            <li><a href="Pedidos.jsp" class="parent"><span>Pedidos</span></a></li>
                            <li><a href="Factura.jsp" class="parent"><span>Facturaci&oacute;n</span></a></li>
                            <li><a href="Registrarse.jsp" class="parent"><span>Registrar</span></a></li>
                            <li><a href="subindex.jsp" class="parent"><span>Regresar al Menú</span></a></li>
                             <li><a href="index.jsp" class="parent"><span>Salir</span></a>
                                
                                  
             </ul>
            
            </div>
    
    
                <br /><br /><br /><br /><br/>

        <table align="center">
    
                 <td width="900" align="center" bgcolor="white" style="width:1920px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannercli.png" style='width:504px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroClientes" method="get">
                            <tr>
                              <td>Codigo cliente<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_cliente" maxlength="30" onkeypress="return validarNumeros(event)" value="<%=Codigo_cliente != null ? Codigo_cliente : ""%>"></td>
                            
                                                        <tr>
                            <td>Nombre completo<font color="blue">*</font></td>
                            <td><input type="text" name="nombre_cliente" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=nombre_cliente != null ? nombre_cliente : ""%>"></td>
                            <td>Apellidos <font color="blue">*</font></td>
                            <td><input type="text" name="apellido_cliente" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=apellido_cliente != null ? apellido_cliente : ""%>"></td>
                            
                            
                            <tr>
                             <td> Dirección <font color="blue">*</font></td>
                            <td><input type="text" name="direcion" maxlength="30" onkeypress="return validarNumeros (event)" value="<%=direccion != null ? direccion: ""%>"></td>
                            
                            <td> Ciudad <font color="blue">*</font></td>
                             <td><input type="text" name="ciudad" maxlength="30" onkeypress="return validarsololetras(event)" value="<%=ciudad != null ? ciudad: ""%>"></td>
                             </tr>
                           <td>Teléfono<font color="blue">*</font></td>
                            <td><input type="text" name="telefono" maxlength="30" onkeypress="return (event)" value="<%=telefono != null ? telefono : ""%>"></td>
                            
                            <tr>
                             <td>Celular <font color="blue">*</font></td>
                            <td><input type="text" name="celular" maxlength="30" onkeypress="return validarsololetras (event)" value="<%=celular != null ? celular : ""%>"></td>
                           
                           <td>Correo electrónico <font color="blue">*</font></td>
                            <td><input type="email" name="correo" maxlength="30" onkeypress="return  (event)" value="<%=correo!= null ?correo : ""%>"></td>               
                            
                            <tr>
                            <td colspan="4" align="center"><br>Los campos con <font color="blue">*</font> son obligatorios</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                
                                    <button name="action" value="crear" style="height:30px; width:96px" type="submit"><img src="Imagenes/Crear1.png"></button>
                                    <button name="action" value="modificar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Modificar1.png"></button>
                                    <button name="action" value="eliminar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Eliminar1.png"></button>
                                    <button name="action" value="limpiar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Limpiar1.png"></button>
                                    <button name="action" value="consultar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Consultar1.png"></button>
                                    <button name="Lista" value="Listar" style="height:30px; width:96px" type="submit"><img src="Imagenes/Listar1.png"></button>
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                           <form action="./MaestroClientes" method="post" class="letra">
                    <%if (LU == null) {%> <h4>No hay informaci&oacute;n para mostrar</h4>
                    <%} else {%> <br>

                <table table border="1">
                        
                        <tr>
                            <td>Codigo cliente</td>
                            <td>Nombre completo</td>
                            <td>Apellidos</td>
                            <td>Dirección</td>
                            <td>Ciudad</td>
                            <td>Teléfono</td> 
                            <td>Celular</td>
                            <td>Email</td>
                             
                             
                       </tr>
                    <%for (Ent_Clientes user : LU) {%>
                    <tr>
                    <td><%=user.getCodigo_cliente()%></td>
                    <td><%=user.getNombre_cliente()%></td>
                    <td><%=user.getApellido_cliente()%></td>
                    <td><%=user.getDireccion()%></td>
                    <td><%=user.getCiudad()%></td>
                    <td><%=user.getTelefono()%></td>
                    <td><%=user.getCelular()%></td>
                    <td><%=user.getCorreo()%></td>


</tr>
<%}%>
</table>
</form>
<%}%>      
</td>
</tr>
</table>
                
                <br /><br /><br /><br /><br/><br /><br /><br /><br /><br/>
                <center><FONT color="black" SIZE="5">Síguenos en:</font><br>
<A HREF="https://www.facebook.com/covsepolitecnico"><img src="Imagenes/face.png" height="50" width="50"></a>

<A HREF="https://www.youtube.com/watch?v=X5Wkp1gsNik"><img src="Imagenes/you.png" height="50" width="50"></a>
 <center><div id="copyright">Copyright&copy; 2014 - Página creada por Covse - Todos los derechos resevados</div></center>
    </body>
</html>
