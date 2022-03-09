/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
@WebServlet(name = "UsuariosControlador", urlPatterns = {"/Usuarios"})
public class UsuariosControlador extends HttpServlet {

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

        // 1. Recibir datos de la vista
        String Id_Usuarios = request.getParameter("txtId");
        String Documento = request.getParameter("txtDocumento");
        String Contrasena = request.getParameter("txtContrasena"); 
        String Nombre = request.getParameter("txtNombre");
        String Telefono = request.getParameter("txtTelefono");
        String Email = request.getParameter("txtEmail");
        String Direccion = request.getParameter("txtDireccion");
        String Estado = request.getParameter("txtEstado");
        

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        // 2. Quien tiene los datos de forma segura en el sistema? VO
        UsuarioVO usuVO = new UsuarioVO(Id_Usuarios,Nombre, Documento, Telefono, Email, Direccion,
                Estado, Contrasena);

        // 3. Quien hace las operaciones? DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro

                if (usuDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El usuario se registro correctamente!");

                } else {

                    request.setAttribute("mensajeError", "El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;

            case 2:

                if (usuDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El usuario se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El usuario no se actualizo correctamente!");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;

            case 3:

                if (usuDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El usuario se elimino correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El usuario no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case 4:
                if (usuDAO.iniciarSesion(Documento, Contrasena)) {

                    request.getRequestDispatcher("menu.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "Corregir datos!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
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
