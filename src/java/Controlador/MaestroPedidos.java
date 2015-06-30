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
import entidades.Ent_Pedidos;
import Negocio.*;
import utilidades.Conexion;

/**
 *
 * @author USUARIO
 */
 public class MaestroPedidos extends HttpServlet {
     int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_Pedidos pedidos = new Ent_Pedidos();
       pedidos.setCodigo_pedido(request.getParameter("codigo_pedido"));
       pedidos.setCodigo_proveedor(request.getParameter("codigo_proveedor"));
       pedidos.setCodigo_producto(request.getParameter("codigo_producto"));
       pedidos.setCantidad(request.getParameter("cantidad"));
       pedidos.setValor_unitario(request.getParameter("valor_unitario"));
       pedidos.setIVA(request.getParameter("IVA"));
       pedidos.setFecha_pedido(request.getParameter("fecha_pedido"));
       
           
        
        String accion = (request.getParameter("action"));
        System.out.print(pedidos);
        String cop = request.getParameter("codigo_pedido");
        String copr = request.getParameter("codigo_proveedor");
        String copo = request.getParameter("codigo_producto");
        String can  = request.getParameter("cantidad");
        String vau = request.getParameter("valor_unitario");
        String iva = request.getParameter("IVA");
        String fe = request.getParameter("fecha_pedido");
        
        
        
        
        
        
        
        
        String User = request.getParameter("Pedidos");
        
         Ent_Pedidos us = new  Ent_Pedidos();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Pedidos negocioU = new N_Pedidos();
            try {
                List< Ent_Pedidos> ListarPedidos=negocioU.ListarPedidos();
                request.setAttribute("ListarPedidos", ListarPedidos);
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.MaestroPedidos.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(Controlador.MaestroPedidos.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Pedidos.jsp");
          }
        
       if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_pedido from Pedidos").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Este pedido ya existe, por favor verifique el código", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
             }
              }
              }
              catch(Exception e){}

             if(cop.equals("")&&copr.equals("")&&copo.equals("")&&can.equals("")&&vau.equals("")&&iva.equals("")&&fe.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                }
            else if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del pedido.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }else if(copr.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del proveedor.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }else if(copo.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del producto.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }else if(can.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la cantidad.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }else if(vau.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el valor unitario.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                }else if(iva.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el IVA.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                }else if(fe.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la fecha del pedido.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            
            }else {
                int resultado = new N_Pedidos().crear(pedidos);
                 try {
                  response.sendRedirect("Pedidos.jsp");
                  JOptionPane.showMessageDialog(null, "El pedido se guardó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        
        if ("consultar".equals(accion)){
            if (cop.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese el código del pedido","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            } else {
                N_Pedidos negocioC = new N_Pedidos();
                try{
                    Ent_Pedidos cli= negocioC.Buscar(cop);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El pedido fue encontrado con éxito" );
                          request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroPedidos.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del pedido.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }else if(cop.equals("")||copr.equals("")||copo.equals("")||can.equals("")||vau.equals("")||iva.equals("")||fe.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                }else if(cop!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_pedido from Pedidos").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este pedido?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Pedidos().modificar(pedidos);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "Se modificó correctamente la información del pedido", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Pedidos.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_pedido from Pedidos").executeQuery();
           while(r1.next()){
           if(!cop.equals(r1.getString(1))&&(!cop.equals(""))){
            request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Pedido inexistente, por favor verifique el código del pedido", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(cop.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del pedido.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_pedido from Pedidos").executeQuery();
                while(r.next()){
                    if(cop.equals(r.getString(1))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este pedido?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Pedidos().eliminar(pedidos);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente la información del pedido", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("./Pedidos.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_pedido from Pedidos").executeQuery();
           while(r1.next()){
           if(!cop.equals(r1.getString(1))&&(!cop.equals(""))){
            request.getRequestDispatcher("./Pedidos.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Pedido inexistente, por favor verifique código del pedido", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
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
