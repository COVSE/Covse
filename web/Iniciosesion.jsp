<%-- 
    Document   : Iniciosesion
    Created on : 4/03/2014, 09:04:46 AM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>

<head>

<title>Inicio de sesión</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link rel="stylesheet" href="estilos/estilomenu.css">
    <link type="text/css" href="menu.css" rel="stylesheet" />
    <link type="text/css" href="bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="estilos/craftyslide.css" />
    <link type="text/css" href="estilos/cuadro.css" rel="stylesheet" />

    
	
      
    <link rel="stylesheet" type="text/css" href="engine0/style.css" />
     
      

    
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="menu.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    
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
   
   width:76%;
   left:208px;
}

#tablita{
    float: right;
    
}

</style>

<div id="menu">
    <ul class="menu">
        <li><a href="Ayuda.jsp" class="parent"><span>Ayuda</span></a>
<li><a href="Acerca.jsp" class="parent"><span>Acerca de</span></a></li>
<li><a href="CONTACTENOS.jsp" class="parent"><span>Contáctenos</span></a>
<li><a href="Galeriadeimagenes.jsp" class="parent"><span>Galería de imágenes</span></a>
    <li><a href="index.jsp" class="parent"><span>Regresar al inicio</span></a></li>

             </ul>
            
            </div>
    
    



<br /><br /><br /><br /><br /><br /><br /><br />



<link href="estilos/iniciosesion.css" rel="stylesheet" type="text/css" />
</head>

<body  link="#FFFAFA" vlink="#FFFAFA" alink="#FFFAFA">
    <div class="wraper">
    <div id="iniciosesion">
        <nav>
        <H2>Iniciar sesi&oacute;n</H2>
        <hr>
      <form action="./Autenticacion" method="post">
						<center>
						<input type="text" name="user" id="user" value="" size="25" placeholder="Usuario" style='width:200px; height:25px'/><br></br>
						<input type="password" name="pass" id="pass" value="" size="25" placeholder="Contraseña" style='width:200px; height:25px'/><br></br>
                                                      <input type="hidden" name="valor" id="accion" value="0"/>
                                                
                                                
 <button   class="boton aceptar" name="Aceptar" id="user"   style='width:96px; height:29px' type="submit"></button>
 <button class="boton salir" name="Salir" id="user"style='width:96px; height:29px' type="submit"></button>
    
                                                      
   
 <li><a HREF="CONTACTENOS.jsp"><FONT color="black" ALIGN=center>Olvidó su Contraseña?</a></li>
                                         </center>
            
                    </form>
          <a href="subindex.jsp"></a>
        
        
                        
     
    </nav>
    </div>
        <br /><br /><br /><br /><br /><br /><br /><br /><br />
        <center><FONT color="black" SIZE="5">Síguenos en:</font><br>
<A HREF="https://www.facebook.com/covsepolitecnico"><img src="Imagenes/face.png" height="50" width="50"></a>

<A HREF="https://www.youtube.com/watch?v=X5Wkp1gsNik"><img src="Imagenes/you.png" height="50" width="50"></a>
   <center><div id="copyright">Copyright&copy; 2014 - Página creada por Covse - Todos los derechos resevados</div></center>
</body>
 
    </html>

    </HTML>