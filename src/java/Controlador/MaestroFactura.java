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
import entidades.Ent_Factura;
import Negocio.*;
import utilidades.Conexion;
import java.awt.HeadlessException;

/**
 *
 * @author Equipo ELECTROSOFT
 */

public class MaestroFactura extends HttpServlet {
    int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_Factura factura = new Ent_Factura();
        factura.setcodigo_factura(request.getParameter("codigo_factura"));
        factura.setfecha_factura(request.getParameter("fecha_factura"));
        factura.setvalor_total(request.getParameter("valor_total"));
        factura.setIVA(request.getParameter("IVA"));
        factura.setcodigo_cliente(request.getParameter("codigo_cliente"));
        factura.setcodigo_producto(request.getParameter("codigo_producto"));
        factura.setcantidad(request.getParameter("cantidad"));
        factura.setvalor_unitario(request.getParameter("valor_unitario"));
        
        
        
        
        
        
        
        String accion = (request.getParameter("action"));
        System.out.print(factura);
        String codfac = request.getParameter("codigo_factura");
        String fechfac = request.getParameter("fecha_factura");
        String valto = request.getParameter("valor_total");
        String IVA = request.getParameter("IVA");
        String codcli = request.getParameter("codigo_cliente");
        String codpr = request.getParameter("codigo_producto");
        String cant = request.getParameter("cantidad");
        String vu = request.getParameter("valor_unitario");
       
        
        
        
        
        
        
        
        String User = request.getParameter("factura");
        
        Ent_Factura pe = new Ent_Factura();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Factura negociofac = new N_Factura();
            try {
                List<Ent_Factura> Listarfactura=negociofac.ListarFactura();
                request.setAttribute("Listarfactura", Listarfactura);
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(MaestroFactura.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(MaestroFactura.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Factura.jsp");
          }
        
        if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_factura from factura").executeQuery();
                while(r.next()){
                    if(codfac.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Esta factura ya existe, por favor verifique el código", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Factura.jsp").forward(request, response);
             }
            }
              }catch(Exception e){}

            if(codfac.equals("")&&fechfac.equals("")&&valto.equals("")&&IVA.equals("")&&codcli.equals("")&&codpr.equals("")&&cant.equals("")&&vu.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                }
            else if(codfac.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }else if(fechfac.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los nombres.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }else if(valto.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los apellidos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }else if(IVA.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la fecha de nacimiento.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }else if(codcli.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el teléfono.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Facturacion.jsp").forward(request, response);
            }else if(codpr.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el email.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Facturacion.jsp").forward(request, response);
            }else if(cant.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el email.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Facturacion.jsp").forward(request, response);
            }else if(vu.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el email.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Facturacion.jsp").forward(request, response);
            }
            else {
                int resultado = new N_Factura().crear(factura);
                 try {
                  response.sendRedirect("Factura.jsp");
                  JOptionPane.showMessageDialog(null, "Se guardó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        if ("consultar".equals(accion)){
            if (codfac.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese su código","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            } else {
                N_Factura negociofac = new N_Factura();
                try{
                    Ent_Factura cli= negociofac.Buscar(codfac);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El pedido fue encontrado con exito" );
                          request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroFactura.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(codfac.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de documento.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }else if(codfac.equals("")||fechfac.equals("")||valto.equals("")||IVA.equals("")||codcli.equals("")||codpr.equals("")||cant.equals("")||vu.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                }else if(codfac!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_factura from factura").executeQuery();
                while(r.next()){
                    if(codfac.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este usuario?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Factura().modificar(factura);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "Se modificó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Factura.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_factura from factura").executeQuery();
           while(r1.next()){
           if(!codfac.equals(r1.getString(7))&&(!codfac.equals(""))){
            request.getRequestDispatcher("./Factura.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el número de documento", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(codfac.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de documento.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Factura.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_factura from factura").executeQuery();
                while(r.next()){
                    if(codfac.equals(r.getString(7))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este usuario?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Factura().eliminar(factura);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("Factura.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Factura.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_factura from factura").executeQuery();
           while(r1.next()){
           if(!codfac.equals(r1.getString(1))&&(!codfac.equals(""))){
            request.getRequestDispatcher("./Factura.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el número de documento", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
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

