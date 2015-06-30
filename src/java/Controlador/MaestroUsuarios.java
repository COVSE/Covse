/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import entidades.Ent_usuario;
import Negocio.*;
import utilidades.Conexion;
import java.awt.HeadlessException;

/**
 *
 * @author Equipo ELECTROSOFT
 */

public class MaestroUsuarios extends HttpServlet {
    int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_usuario Usuario = new Ent_usuario();
        Usuario.setCodigo_usuario(request.getParameter("codigo_usuario"));
        Usuario.setContrasena(request.getParameter("contrasena"));
        Usuario.setTipo_usuario(request.getParameter("tipo_usuario"));
   
        
        
        
        
        
        
        String accion = (request.getParameter("action"));
        System.out.print(Usuario);
        String id = request.getParameter("codigo_usuario");
        String con = request.getParameter("contrasena");
        String tip = request.getParameter("tipo_usuario");
      
     
        
        
        
        
        
        
        String User = request.getParameter("Registro");
        
        Ent_usuario us = new Ent_usuario();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Usuarios negocioU = new N_Usuarios();
            try {
                List<Ent_usuario> ListarUsuarios=negocioU.ListarUsuarios();
                request.setAttribute("ListarUsuarios", ListarUsuarios);
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(MaestroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(MaestroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Registrarse.jsp");
          }
        
        if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_usuario from usuarios1").executeQuery();
                while(r.next()){
                    if(id.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Éste registro ya existe, Por favor verifique el código de usuario", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
             }
            }
              }catch(Exception e){}

            if(id.equals("")&&con.equals("")&&tip.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                }
            else if(id.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, seleccione el tipo de perfil.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            }else if(con.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la contraseña.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            }else if(tip.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el tipo de perfil.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            }else {
                int resultado = new N_Usuarios().crear(Usuario);
                 try {
                  response.sendRedirect("Registrarse.jsp");
                  JOptionPane.showMessageDialog(null, "El usuario se creó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        if ("consultar".equals(accion)){
            if (id.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese su código","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            } else {
                N_Usuarios negocioC = new N_Usuarios();
                try{
                    Ent_usuario cli= negocioC.Buscar(id);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El usuario fue encontrado con éxito" );
                          request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(id.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código de usuario.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            }else if(id.equals("")||con.equals("")||tip.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                }else if(id!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_usuario from usuarios1").executeQuery();
                while(r.next()){
                    if(id.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este usuario?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Usuarios().modificar(Usuario);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "El usuario se modificó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Registrarse.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_usuario from usuarios1").executeQuery();
           while(r1.next()){
           if(!id.equals(r1.getString(1))&&(!id.equals(""))){
            request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el código de usuario", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(id.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código de usuario.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_usuario from usuarios1").executeQuery();
                while(r.next()){
                    if(id.equals(r.getString(1))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este usuario?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Usuarios().eliminar(Usuario);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "El usuario se eliminó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("Registrarse.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_usuario from usuarios1").executeQuery();
           while(r1.next()){
           if(!id.equals(r1.getString(1))&&(!id.equals(""))){
            request.getRequestDispatcher("./Registrarse.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el código de usuario", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch(Exception e) {}

         }
    }
    
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>  
    
}