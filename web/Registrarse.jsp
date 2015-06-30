
<%@page import="entidades.Ent_usuario" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<%
    String mensaje = (String) request.getAttribute("mensaje");

     String codigo_usuario = request.getParameter("codigo_usuario");
     String contrasena = request.getParameter("contrasena_usuario");
    String tipo_usuario = request.getParameter("tipo_usuario");
   
   
    
    
    Ent_usuario x = request.getAttribute("cli") != null ? (Ent_usuario) request.getAttribute("cli") : null;
    if (x != null) {
        codigo_usuario = x.getCodigo_usuario();
        contrasena = x.getContrasena();
        tipo_usuario = x.getTipo_usuario();
        
        
        
        
        
        
        
    }
    
    List<Ent_usuario> LU = request.getAttribute("ListarUsuarios") != null ? (List<Ent_usuario>) request.getAttribute("ListarUsuarios") : null;
    
%>

<html>
    <head>
        <title>Registrar usuario</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
   <link rel="stylesheet" href="estilos/estilomenu.css">
    <link type="text/css" href="menu.css" rel="stylesheet" />
    <link type="text/css" href="bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="estilos/craftyslide.css" />
    <link type="text/css" href="estilos/cuadro.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="engine0/style.css" />
     
       <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="menu.js"></script>
    <script languaje="javascript" type="text/javascript" src="./js/Validacion.js" >
    
    </script>
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
<li><a href="Productos.jsp" class="parent"><span>Productos</span></a>
<li><a href="subindex.jsp" class="parent"><span>Regresar al Menú</span></a>
<li><a href="index.jsp" class="parent"><span>Salir</span></a>

                                    
             </ul>
            
            </div>
    
    
                
        
        
    



<br /><br /><br /><br /><br />

        <table align="center">
    
                <td width="900" align="center" bgcolor="white" style="width: 1257px;" valign="top"><br>
                    <table>
                        <tr><td><img src="Imagenes/Bannerregi.png" style='width:499px; height:100px'></td></tr>
                    </table>
                    <table>
                        <hr width="500"><br>
                        <form name="inicio" action="./MaestroUsuarios" method="get">
                            <tr>
                            
                            
                          <tr>
                            
                            <td>Código de usuario<font color="blue">*</font></td>
                            <td><input type="text" name="codigo_usuario" maxlength="30" onkeypress="return validar (event)" value="<%=codigo_usuario != null ? codigo_usuario : ""%>"></td>
                            </tr>
                            <tr>
                            <td>Contraseña <font color="blue">*</font></td>
                            <td><input type="password" name="contrasena" maxlength="30" onkeypress="return validar (event)" value="<%=contrasena != null ? contrasena : ""%>"></td>
                            <td>Tipo de usuario <font color="blue">*</font></td>
                            <td><select type="text" name="tipo_usuario">
                                    <option>--Seleccione el perfil--</option> <option <%if ("Administrador".equals(tipo_usuario)) {%>selected<%}%>>Administrador</option> <option <%if ("Cliente".equals(tipo_usuario)) {%>selected<%}%>>Cliente</option></select></td>
                            </tr>
                            
                            
                            <tr>
                            <td colspan="4" align="center"><br>Los campos con <font color="blue">*</font> son obligatorios</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                    <hr width="500">
                                    <button name="action" value="crear" type="submit"><img src="Imagenes/Crear1.png"></button>
                                    <button name="action" value="modificar" type="submit"><img src="Imagenes/Modificar1.png"></button>
                                    <button name="action" value="eliminar" type="submit"><img src="Imagenes/Eliminar1.png"></button>
                                    <button name="action" value="limpiar" type="submit"><img src="Imagenes/Limpiar1.png"></button>
                                    <button name="action" value="consultar" type="submit"><img src="Imagenes/Consultar1.png"></button>
                                    
                                </td>
                            </tr>
                            <input type="hidden" name="valor" value="0" />
                        </form>
                        
                    </table>
                           <form action="./MaestroUsuarios" method="post" class="letra">
                    <%if (LU == null) {%> <h4>No hay informaci&oacute;n para mostrar</h4>
                    <%} else {%> <br>

                    <table table border="1">
                        
                        <tr>
                            
                            <td>Código</td>
                            <td>Contraseña</td>
                            <td>Tipo de usuario</td>
                           
                            
                            
                            
                            
                            
                            
                            
                        </tr>
                        <%for (Ent_usuario user : LU) {%>
                        <tr>
                             <td><%=user.getCodigo_usuario()%></td>
                            <td><%=user.getContrasena()%></td>
                            <td><%=user.getTipo_usuario()%></td>
                            
                           
                            
                            
                            
                            
                            
                            
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