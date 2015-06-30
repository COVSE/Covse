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
import entidades.Ent_Clientes;
import Negocio.*;
import utilidades.Conexion;

/**
 *
 * @author USUARIO
 */
 public class MaestroClientes extends HttpServlet {
     int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_Clientes clientes = new Ent_Clientes();
       clientes.setCodigo_cliente(request.getParameter("codigo_cliente"));
       clientes.setNombre_cliente(request.getParameter("nombre_cliente"));
       clientes.setApellido_cliente(request.getParameter("apellido_cliente"));
       clientes.setDireccion(request.getParameter("direccion"));
       clientes.setCiudad(request.getParameter("ciudad"));
       clientes.setTelefono(request.getParameter("telefono"));
       clientes.setCelular(request.getParameter("celular"));
       clientes.setCorreo(request.getParameter("correo"));
       
           
        
        String accion = (request.getParameter("action"));
        System.out.print(clientes);
        String cdc = request.getParameter("codigo_cliente");
        String nom = request.getParameter("nombre_cliente");
        String ape = request.getParameter("apellido_cliente");
        String dir = request.getParameter("direccion");
        String ciu = request.getParameter("ciudad");
        String tel = request.getParameter("telefono");
        String cel = request.getParameter("celular");
        String ema = request.getParameter("correo");
        
        
        
        
        
        
        
        
        
        String User = request.getParameter("Clientes");
        
         Ent_Clientes us = new  Ent_Clientes();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Clientes negocioU = new N_Clientes();
            try {
                List< Ent_Clientes> ListarClientes=negocioU.ListarClientes();
                request.setAttribute("ListarClientes", ListarClientes);
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.MaestroClientes.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(Controlador.MaestroClientes.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Clientes.jsp");
          }
        
       if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_cliente from Clientes").executeQuery();
                while(r.next()){
                    if(cdc.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Este cliente ya existe, por favor verifique el código", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
             }
              }
              }
              catch(Exception e){}

             if(cdc.equals("")&&nom.equals("")&&ape.equals("")&&dir.equals("")&&ciu.equals("")&&tel.equals("")&&cel.equals("")&&ema.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                }
            else if(cdc.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del cliente.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }else if(nom.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre completo.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }else if(ape.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los apellidos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }else if(dir.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la dirección.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }else if(ciu.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la ciudad.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                }else if(tel.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el teléfono.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                }else if(cel.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el celular.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                }else if(ema.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            
            }else {
                int resultado = new N_Clientes().crear(clientes);
                 try {
                  response.sendRedirect("Clientes.jsp");
                  JOptionPane.showMessageDialog(null, "Se guardó correctamente la información del cliente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        
        if ("consultar".equals(accion)){
            if (cdc.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese el código del cliente","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            } else {
                N_Clientes negocioC = new N_Clientes();
                try{
                    Ent_Clientes cli= negocioC.Buscar(cdc);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El cliente fue encontrado con éxito" );
                          request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroClientes.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(cdc.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del cliente.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }else if(cdc.equals("")||nom.equals("")||ape.equals("")||dir.equals("")||ciu.equals("")||tel.equals("")||cel.equals("")||ema.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                }else if(cdc!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_cliente from Clientes").executeQuery();
                while(r.next()){
                    if(cdc.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este cliente?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Clientes().modificar(clientes);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "Se modificó correctamente la información del cliente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Clientes.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_cliente from Clientes").executeQuery();
           while(r1.next()){
           if(!cdc.equals(r1.getString(1))&&(!cdc.equals(""))){
            request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Cliente inexistente, por favor verifique el código del cliente", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(cdc.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del cliente.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_cliente from Clientes").executeQuery();
                while(r.next()){
                    if(cdc.equals(r.getString(1))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este cliente?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Clientes().eliminar(clientes);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente la información del cliente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("./Clientes.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_cliente from Clientes").executeQuery();
           while(r1.next()){
           if(!cdc.equals(r1.getString(1))&&(!cdc.equals(""))){
            request.getRequestDispatcher("./Clientes.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique código del cliente", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch(Exception e) {}

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
