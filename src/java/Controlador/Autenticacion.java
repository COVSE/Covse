package Controlador;

import entidades.Ent_usuario;
import Negocio.N_Usuarios;
import utilidades.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
/**
 *
 * @author Patricia
 */
public class Autenticacion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_usuario usuario = new Ent_usuario();
        usuario.setCodigo_usuario(request.getParameter("user"));
        usuario.setContrasena(request.getParameter("pass"));
        usuario.setTipo_usuario(request.getParameter("TipoP"));
        int index = 0;
        String accion = (request.getParameter("action"));
        String urlRedireccion = "";
         String us=request.getParameter("user");
         String pass=request.getParameter("pass");
         String tip=request.getParameter("TipoP");
         String ad="Administrador";
         String cli="Cliente";
         String pro="Propietario";

         switch (index) {

            case 0:

               String resultadoAutentico = new N_Usuarios().autenticar(usuario);
                
               if(us.equals("")&&pass.equals("")){
                    JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                     response.sendRedirect("Iniciosesion.jsp");
              } else if(us.equals("")){
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese el usuario", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                      response.sendRedirect("Iniciosesion.jsp");
              } else if(pass.equals("")){
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese la contraseña", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                      response.sendRedirect("Iniciosesion.jsp");
              } else
              {Conexion Connection= new Conexion();
                     try{
                        ResultSet r=Connection.getCon().prepareStatement("Select tipo_usuario from usuarios1 where codigo_usuario='"+us+"'").executeQuery();
                        while(r.next()){
                             if((r.getString(1)).equals(cli)){

                                if (resultadoAutentico.equals("1")) {
                                    request.setAttribute("logueo", "1");
                                    JOptionPane.showMessageDialog(null,"¡Bienvenido a Covse!", "Inicie sesion", JOptionPane.INFORMATION_MESSAGE);
                                    request.getRequestDispatcher("./index.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("logueo", "0");
                                    JOptionPane.showMessageDialog(null,"Verifique si el usuario o contraseña son correctos", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                                    request.getRequestDispatcher("./Iniciosesion.jsp").forward(request, response);
                                }

                             }else if((r.getString(1)).equals(ad)){
                                if (resultadoAutentico.equals("1")){
                                    request.setAttribute("logueo", "1");
                                    JOptionPane.showMessageDialog(null,"¡Bienvenido a Covse!", "Ingreso al sistema", JOptionPane.INFORMATION_MESSAGE);
                                    request.getRequestDispatcher("./subindex.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("logueo", "0");
                                    JOptionPane.showMessageDialog(null,"Verifique si el usuario o contraseña son correctos", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                                    request.getRequestDispatcher("./Iniciosesion.jsp").forward(request, response);
                                }
                             }else if((r.getString(1)).equals(pro)){
                                if (resultadoAutentico.equals("1")){
                                    request.setAttribute("logueo", "1");
                                    JOptionPane.showMessageDialog(null,"¡Bienvenido a Covse!", "Inicie sesion", JOptionPane.INFORMATION_MESSAGE);
                                    request.getRequestDispatcher("./index.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("logueo", "0");
                                    JOptionPane.showMessageDialog(null,"Verifique si el usuario o contraseña son correctos", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                                    request.getRequestDispatcher("./Iniciosesion.jsp").forward(request, response);
                                }
                             }
                        }
                     }catch(Exception e){} 
              }
                break;
        }

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}