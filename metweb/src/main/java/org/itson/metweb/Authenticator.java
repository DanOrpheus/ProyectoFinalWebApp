/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.metweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.itson.dominio.Usuario;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.implementaciones.UsuariosBO;
import org.itson.metweb.negocio.interfaces.IUsuariosBO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
@WebServlet(name = "Authenticator", urlPatterns = {"/auth"})
public class Authenticator extends HttpServlet {

    /**
     * Procesa el método de login a la página web
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processLogin(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // ATRIBUTOS
        String avatar = request.getParameter("avatar");
        String password = request.getParameter("pass");
        String pagReturn = "/login.jsp";
        String pagSuccess = "/index.jsp";
        String pagError = "/errorHttp.jsp";
        // VALIDACIONES
        if (avatar == null 
                || avatar.isEmpty()
                || password == null 
                || password.isEmpty()){
            getServletContext().getRequestDispatcher(pagReturn)
                    .forward(request, response);
        }
        // LÓGICA DE NEGOCIO
        Usuario nUsuario = new Usuario(password, avatar);
        IUsuariosBO usuarioBO = new UsuariosBO();
        try {
            Usuario savedUser = usuarioBO.agregar(nUsuario);
            request.setAttribute("usuario", savedUser);
        // SI NO PUEDE INICIAR
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
            getServletContext().getRequestDispatcher(pagError)
                    .forward(request, response);
        }
        // SI PUEDE INICIAR
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", nUsuario);
        getServletContext().getRequestDispatcher(pagSuccess)
                .forward(request, response);
    }
    
    /**
     * Procesa el método de logout de la página web
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processLogout(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String pagReturn = "/login.jsp";
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        getServletContext().getRequestDispatcher(pagReturn)
                .forward(request, response);
    }
    
    /**
     * Procesa el método de acceso a la página principal del sitio web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processStartPage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String pagStart = "/inicio.jsp";
        getServletContext().getRequestDispatcher(pagStart)
                .forward(request, response);
    }
    
    /**
     * Procesa el método de registro de usuarios al sitio web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRegisterPage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String pagStart = "/register.jsp";
        getServletContext().getRequestDispatcher(pagStart)
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("login")){
            processLogin(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("logout")){
            processLogout(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("start")){
            processStartPage(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("register")){
            processRegisterPage(request, response);
            return;
        }            
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
