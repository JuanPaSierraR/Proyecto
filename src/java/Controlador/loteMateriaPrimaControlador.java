/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.loteMateriaPrimaDAO;
import ModeloVO.loteMateriaPrimaVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "loteMateriaPrimaControlador", urlPatterns = {"/loteMateriaPrima"})
public class loteMateriaPrimaControlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String IdLoteMateriaPrima = request.getParameter("txtIdLoteMateriaPrima");
        String Cantidad = request.getParameter("txtCantidad");
        String Observaciones = request.getParameter("txtObservaciones");
        String FechaIngreso = request.getParameter("txtFechaIngreso");
        String FechaSalida = request.getParameter("txtFechaSalida");
        String IdMateriaPrima = request.getParameter("txtIdMateriaPrima");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        // 2. Quien tiene los datos de forma segura en el sistema? VO
        loteMateriaPrimaVO loteMPVO = new loteMateriaPrimaVO(IdLoteMateriaPrima, Cantidad, Observaciones, FechaIngreso, FechaSalida, IdMateriaPrima);

        // 3. Quien hace las operaciones? DAO
        loteMateriaPrimaDAO loteMPDAO = new loteMateriaPrimaDAO(loteMPVO);

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro

                if (loteMPDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se registro correctamente!");

                } else {

                    request.setAttribute("mensajeError", "No se pudo registrar");
                }
                request.getRequestDispatcher("registrarLoteMateriaPrima.jsp").forward(request, response);
                break;

            case 2:

                if (loteMPDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeError", "No se pudo actualizar.");
                }
                request.getRequestDispatcher("actualizarLoteMateriaPrima.jsp").forward(request, response);
                break;

            case 3:

                if (loteMPDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se elimino correctamente!");

                } else {

                    request.setAttribute("mensajeError", "No se pudo eliminar");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
                
                default:
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
