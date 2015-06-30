/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.MaestroFactura;
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

public class MaestroFactura2 extends HttpServlet {
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
        
      
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Factura2.jsp");
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
                          request.setAttribute("mensaje", "La factura fue encontrado con exito" );
                          request.getRequestDispatcher("./Factura2.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroFactura.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
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