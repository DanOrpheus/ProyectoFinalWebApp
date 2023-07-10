/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.metweb;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.itson.dominio.Post;
import org.itson.metweb.DTO.CrearPostsDTO;
import org.itson.metweb.DTO.EliminarPostsDTO;
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
        String pagReturn = "/inicio.jsp";
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
        // Convertir flujo de datos (bytes) a texto formato JSON
        String datosJSON = IOUtils.toString(
                request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        CrearPostsDTO postDTO = serializadorJSON.fromJson(
                datosJSON, CrearPostsDTO.class);
        // Validar datos de entrada
        if (postDTO.getTitulo() == null 
                || postDTO.getTitulo().isEmpty()
                || postDTO.getContenido() == null 
                || postDTO.getContenido().isEmpty()){
            response.setStatus(400);
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson("Los datos son inválidos"));
            }
            return;
        }
        // Lógica de negocio
        Post postNew = new Post(postDTO.getTitulo(), 
                postDTO.getContenido(), 
                postDTO.getFechaHoraCreacion().toString());   
        IPostsBO postBO = new PostsBO();
        try {
            Post savedPost = postBO.agregar(postNew);
            request.setAttribute("post", savedPost);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
        }
        // Devolver datos
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(serializadorJSON.toJson(postNew));
        }
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
        // Convertir flujo de datos (bytes) a texto formato JSON
        String datosJSON = IOUtils.toString(
                request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        EliminarPostsDTO postDTO = serializadorJSON.fromJson(
                datosJSON, EliminarPostsDTO.class);
        // Lógica de negocio
        ObjectId postId = postDTO.getId();
        IPostsBO postBO = new PostsBO();
        Post postElim = null;
        try {
            postElim = postBO.consultarPostPorId(postId);
        } catch (NegocioException ex) {
            request.setAttribute("error", ex.getMessage());
        }
        try {
            Post elimPost = postBO.eliminar(postElim);
            request.setAttribute("post", elimPost);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
        }
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(serializadorJSON.toJson(postElim));
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
        if (action != null && action.equalsIgnoreCase("create")){
            this.processCreate(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("delete")){
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
