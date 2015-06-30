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
import entidades.Ent_Productos;
import Negocio.*;
import utilidades.Conexion;

/**
 *
 * @author USUARIO
 */
 public class MaestroProduc extends HttpServlet {
     int i = 0;
    int nfilas = 0;
    Connection c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Ent_Productos productos = new Ent_Productos();
        productos.setCodigo_producto(request.getParameter("codigo_producto"));
       productos.setNombre_producto(request.getParameter("nombre_producto"));
       productos.setPrecio(request.getParameter("precio"));
       productos.setCantidad_disponible(request.getParameter("cantidad_disponible"));
       productos.setMarca(request.getParameter("marca"));
       
           
        
        String accion = (request.getParameter("action"));
        System.out.print(productos);
        String cd = request.getParameter("codigo_producto");
        String nom = request.getParameter("nombre_producto");
        String pr = request.getParameter("precio");
        String cad = request.getParameter("cantidad_disponible");
        String mr = request.getParameter("marca");
        
        
        
        
        
        
        
        
        String User = request.getParameter("Productos");
        
         Ent_Productos us = new  Ent_Productos();
        
        if ("Listar".equals(request.getParameter("Lista"))) {
            N_Productos negocioU = new N_Productos();
            try {
                List< Ent_Productos> ListarProductos=negocioU.ListarProductos();
                request.setAttribute("ListarProductos", ListarProductos);
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.MaestroProduc.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            } catch (ServletException ex){
                Logger.getLogger(Controlador.MaestroProduc.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }
        
        if("limpiar".equals(request.getParameter("action"))){
            response.sendRedirect("Productos.jsp");
          }
        
       if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_producto from Productos").executeQuery();
                while(r.next()){
                    if(cd.equals(r.getString(1))){
                       JOptionPane.showMessageDialog(null, "Éste producto ya existe, por favor verifique el código", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
                       request.getRequestDispatcher("./Productos.jsp").forward(request, response);
             }
              }
              }
              catch(Exception e){}

             if(cd.equals("")&&nom.equals("")&&pr.equals("")&&cad.equals("")&&mr.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                }
            else if(cd.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del producto.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }else if(nom.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del producto.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }else if(pr.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el valor unitario.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }else if(cad.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la cantidad.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }else if(mr.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la marca.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            
            }else {
                int resultado = new N_Productos().crear(productos);
                 try {
                  response.sendRedirect("Productos.jsp");
                  JOptionPane.showMessageDialog(null, "El producto se guardó correctamente", "Covse", JOptionPane.INFORMATION_MESSAGE );
                  request.setAttribute("cli",resultado);
                 } catch (Exception e) {
                     System.out.println(e.getMessage());
                     e.printStackTrace();
                 }
               }
        }
        
        
        if ("consultar".equals(accion)){
            if (cd.equals("")){
                JOptionPane.showMessageDialog (null, "Por favor ingrese el código del producto","Advertencia - Covse", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            } else {
                N_Productos negocioC = new N_Productos();
                try{
                    Ent_Productos cli= negocioC.Buscar(cd);
                          request.setAttribute("cli", cli);
                          request.setAttribute("mensaje", "El producto fue encontrado con éxito" );
                          request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                       } catch (Exception ex) {
                           Logger.getLogger(MaestroClientes.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }
        
        if ("modificar".equals(accion)) {

            if(cd.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del producto.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }else if(cd.equals("")||nom.equals("")||pr.equals("")||cad.equals("")||mr.equals("")){
                JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                }else if(cd!=null){
            Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_producto from Productos").executeQuery();
                while(r.next()){
                    if(cd.equals(r.getString(1))){
                      int confirma = JOptionPane.showConfirmDialog( null, "¿Desea actualizar la información de este producto?");

               if(confirma == JOptionPane.YES_OPTION){
                     int resultadoModificar = new N_Productos().modificar(productos);
                     request.setAttribute("cli", resultadoModificar);
                     JOptionPane.showMessageDialog(null, "Se modificó correctamente la información del producto", "Covse", JOptionPane.INFORMATION_MESSAGE );
                     response.sendRedirect("Productos.jsp");
                   }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }
                }
                }
                } catch (Exception e) {}
            }

       Conexion Connection= new Conexion();
                   try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_producto from Productos").executeQuery();
           while(r1.next()){
           if(!cd.equals(r1.getString(1))&&(!cd.equals(""))){
            request.getRequestDispatcher("./Productos.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Producto inexistente, por favor verifique el número de documento", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
           }
           }
             }
              catch (Exception e) {}

        }
        
        if ("eliminar".equals(request.getParameter("action"))) {

             if(cd.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el código del producto.", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE );
                request.getRequestDispatcher("./Productos.jsp").forward(request, response);
            }

             Conexion Connection= new Conexion();
              try{
                ResultSet r=Connection.getCon().prepareStatement("Select codigo_producto from Productos").executeQuery();
                while(r.next()){
                    if(cd.equals(r.getString(1))){

               int confirma = JOptionPane.showConfirmDialog( null, "¿Desea eliminar la información de este producto?");

               if(confirma == JOptionPane.YES_OPTION){
                int resultadoEliminar = new N_Productos().eliminar(productos);
                request.setAttribute("cli", resultadoEliminar);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente la información del producto", "Covse", JOptionPane.INFORMATION_MESSAGE );
                response.sendRedirect("./Productos.jsp");
                 }else if(confirma == JOptionPane.NO_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CLOSED_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }else if(confirma == JOptionPane.CANCEL_OPTION){
                 request.getRequestDispatcher("./Productos.jsp").forward(request, response);
                 }
                }
                }
                }catch(Exception e) {}

             try{
            ResultSet r1=Connection.getCon().prepareStatement("Select codigo_producto from Productos").executeQuery();
           while(r1.next()){
           if(!cd.equals(r1.getString(1))&&(!cd.equals(""))){
            request.getRequestDispatcher("./Productos.jsp").forward(request, response);
           JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique código del producto", "Advertencia - Covse", JOptionPane.WARNING_MESSAGE  );
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
