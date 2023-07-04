/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.metweb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.itson.dominio.Post;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.implementaciones.PostsBO;
import org.itson.metweb.negocio.interfaces.IPostsBO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
@WebServlet(name = "Posts", urlPatterns = {"/posts"})
public class Posts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processFindAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IPostsBO postBO = new PostsBO();
        String pagReturn = "/publicaciones.jsp";
        String pagError = "/errorHttp.jsp";
        try {
            List<Post> posts = postBO.consultarPosts();
            request.setAttribute("posts", posts);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
            getServletContext().getRequestDispatcher(pagError).
                    forward(request, response);
        }
        getServletContext().getRequestDispatcher(pagReturn).
                forward(request, response);        
    }
    
    /**
     * Proceso para crear un post en la página web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ATRIBUTOS
        String datetimeCreation = request.getParameter("datetimeCreation");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String datetimeEdit = request.getParameter("datetimeEdit");
        // PÁGINAS DE REDIRECCIÓN
        String pagReturn = "/register.jsp";
        String pagSuccess = "/success.jsp";
        String pagError = "/errorHttp.jsp";
        // VALIDACIONES
        if (datetimeCreation == null || datetimeCreation.trim().length() != 0
                || title == null || title.trim().length() != 0
                || content == null || content.trim().length() != 0
                || datetimeEdit == null || datetimeEdit.trim().length() != 0){
            getServletContext().getRequestDispatcher(pagReturn).
                    forward(request, response);
        }
        // LÓGICA DE NEGOCIO
        Post post = new Post();
        IPostsBO postBO = new PostsBO();
        try {
            Post savedPost = postBO.agregar(post);
            request.setAttribute("post", savedPost);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
            getServletContext().getRequestDispatcher(pagError)
                    .forward(request, response);
        }
        getServletContext().getRequestDispatcher(pagSuccess)
                .forward(request, response);
    }
    
    /**
     * Proceso para modificar un post en la página web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    /**
     * Proceso para eliminar un post en la página web
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("findall")){
            this.processFindAll(request, response);
            return;
        }
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
        String action = request.getParameter("action");
        if (action == null || action.equalsIgnoreCase("create")){
            this.processCreate(request, response);
            return;
        }
        if (action == null || action.equalsIgnoreCase("update")){
            this.processModify(request, response);
            return;
        }
        if (action == null || action.equalsIgnoreCase("delete")){
            this.processDelete(request, response);
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
