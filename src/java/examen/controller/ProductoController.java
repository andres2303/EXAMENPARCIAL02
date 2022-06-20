/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package examen.controller;

import com.google.gson.Gson;
import examen.dao.ProductoDao;
import examen.daoImpl.ProductoDaoImpl;
import examen.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ProductoController extends HttpServlet {
    private ProductoDao productoDao = new ProductoDaoImpl();
    private Gson gson = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        switch (opcion) {
            case 1:
                out.println(gson.toJson(productoDao.readAll()));
                break;
            case 2:

 
                /**
                 * caso para crear producto
                 */
                
                String json = request.getParameter("nuevoProducto");
                
                Producto prodNuevo = gson.fromJson(json, Producto.class);
                
                /*Producto productoNuevo = new Producto();
               
                productoNuevo.setNombre(request.getParameter("nombre"));
                productoNuevo.setPrecio(Float.parseFloat(request.getParameter("precio")));
                productoNuevo.setStock(Integer.parseInt(request.getParameter("stock")));
                productoNuevo.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
                productoNuevo.setIdcategoria(Integer.parseInt(request.getParameter("idcategoria")));*/
                
                System.out.println(prodNuevo);
                productoDao.create(prodNuevo);
                break;
        } 

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
