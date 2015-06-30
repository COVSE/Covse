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
import entidades.Ent_Proveedores;
import Negocio.*;
import utilidades.Conexion;

/**
 *
 * @author USUARIO
 */
 public class MaestroProveedores extends HttpServlet {
     int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_Proveedores proveedores = new Ent_Proveedores();
       proveedores.setCodigo_proveedor(request.getParameter("codigo_proveedor"));
       proveedores.setNombre_empresa(request.getParameter("nombre_empresa"));
       proveedores.setTelefono(request.getParameter("Telefono"));
       proveedores.setCelular(request.getParameter("Celular"));
       proveedores.setCorreo(request.getParameter("Correo"));
       proveedores.setCiudad(request.getParameter("Ciudad"));
       proveedores.setPais(request.getParameter("Pais"));
       proveedores.setDireccion(request.getParameter("Direccion"));
       
           
        
        String accion = (request.getParameter("action"));
        System.out.print(proveedores);
        String cop = request.getParameter("codigo_proveedor");
        String noe = request.getParameter("nombre_empresa");
        String te = request.getParameter("Telefono");
        String ce = request.getParameter("Celular");
        String co = request.getParameter("Correo");
        String ci = request.getParameter("Ciudad");
        String pa = request.getParameter("Pais");
        String di = request.getParameter("Direccion");
        
        
        
        
        
        
        
        
        
        String User = request.getParameter("Clientes");
        
         Ent_Proveedores us = new  Ent_Proveedores();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Proveedores negocioU = new N_Proveedores();
            try {
                List< Ent_Proveedores> ListarProveedores=negocioU.ListarProveedores();
                request.setAttribute("ListarProveedores", ListarProveedores);
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.MaestroProveedores.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(Controlador.MaestroProveedores.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Proveedores.jsp");
          }
        
       if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_proveedore from Proveedores").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Este proveedor ya existe, por favor verifique el código", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
             }
              }
              }
              catch(Exception e){}

             if(cop.equals("")&&noe.equals("")&&te.equals("")&&ce.equals("")&&co.equals("")&&ci.equals("")&&pa.equals("")&&di.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                }
            else if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del proveedor.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }else if(noe.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la empresa.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }else if(te.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el teléfono.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }else if(ce.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el celular.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }else if(co.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo electrónico.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                }else if(ci.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la ciudad.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                }else if(pa.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el país.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                }else if(di.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la dirección.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            
            }else {
                int resultado = new N_Proveedores().crear(proveedores);
                 try {
                  response.sendRedirect("Proveedores.jsp");
                  JOptionPane.showMessageDialog(null, "Se guardó correctamente la información del proveedor", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        
        if ("consultar".equals(accion)){
            if (cop.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese el código del proveedor","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            } else {
                N_Proveedores negocioC = new N_Proveedores();
                try{
                    Ent_Proveedores cli= negocioC.Buscar(cop);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El proveedor fue encontrado con éxito" );
                          request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroClientes.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del proveedor.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }else if(cop.equals("")||noe.equals("")||te.equals("")||ce.equals("")||co.equals("")||ci.equals("")||pa.equals("")||di.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                }else if(cop!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_proveedor from Proveedores").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este proveedor?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Proveedores().modificar(proveedores);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "Se modificó correctamente la información del proveedor", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Proveedores.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_proveedor from Proveedores").executeQuery();
           while(r1.next()){
           if(!cop.equals(r1.getString(1))&&(!cop.equals(""))){
            request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Cliente inexistente, por favor verifique el código del proveedor", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del proveedor.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_proveedor from Proveedores").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este proveedor?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Proveedores().eliminar(proveedores);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente la información del proveedor", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("./Proveedores.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_proveedor from Proveedores").executeQuery();
           while(r1.next()){
           if(!cop.equals(r1.getString(1))&&(!cop.equals(""))){
            request.getRequestDispatcher("./Proveedores.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique código del proveedor", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
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
