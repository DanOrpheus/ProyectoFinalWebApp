/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.metweb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itson.dominio.Usuario;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.implementaciones.UsuariosBO;
import org.itson.metweb.negocio.interfaces.IUsuariosBO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
@WebServlet(name = "Users", urlPatterns = {"/user"})
public class Users extends HttpServlet {

    /**
     * Procesa el método de acceso a la página principal del sitio web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processCreate(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, 
            IOException {
        // ATRIBUTOS
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String fullname = firstname + " " + lastname;
        String pass = request.getParameter("pass");
        String birthdate = request.getParameter("birthdate");
        String city = request.getParameter("city");
        String passConfirm = request.getParameter("passConfirm");
        // PÁGINAS DE REDIRECCIÓN
        String pagReturn = "/register.jsp";
        String pagSuccess = "/success.jsp";
        String pagError = "/errorHttp.jsp";
        // VALIDACIONES
        if (username == null || username.isEmpty()
                || mail == null || mail.isEmpty()
                || fullname == null || fullname.isEmpty()
                || pass == null || pass.isEmpty()
                || passConfirm == null || passConfirm.isEmpty()
                || birthdate == null || birthdate.isEmpty()
                || city == null || city.isEmpty()){
            getServletContext().getRequestDispatcher(pagReturn).
                    forward(request, response);
        
        }
        if (!pass.equalsIgnoreCase(passConfirm)) {
            request.setAttribute("errorPass", "Las contraseñas no coinciden. Por favor ingrésalas de nuevo.");
            //Guardamos los demás datos ya ingresados.
            request.setAttribute("username", username);
            request.setAttribute("mail", mail);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("birthdate", birthdate);
            request.setAttribute("city", city);
            //Redireccionamos a la misma página
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        // LÓGICA DE NEGOCIO
        Usuario user = new Usuario(fullname, mail, 
                pass, username, city, birthdate);
        IUsuariosBO usuarioBO = new UsuariosBO();
        try {
            Usuario savedUser = usuarioBO.agregar(user);
            request.setAttribute("usuario", savedUser);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
            getServletContext().getRequestDispatcher(pagError)
                    .forward(request, response);
        }
        getServletContext().getRequestDispatcher(pagSuccess)
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
        if (action == null || action.equalsIgnoreCase("create")){
            processCreate(request, response);
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
