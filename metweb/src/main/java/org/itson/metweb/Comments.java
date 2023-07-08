/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.metweb;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.itson.dominio.Comentario;
import org.itson.metweb.DTO.CrearComentariosDTO;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.implementaciones.ComentariosBO;
import org.itson.metweb.negocio.interfaces.IComentariosBO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
@WebServlet(name = "Comments", urlPatterns = {"/comm"})
public class Comments extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processFindAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Comentario> comentarios = new LinkedList<>();
        Gson serializadorJSON = new Gson();
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(serializadorJSON.toJson(comentarios));
        }
    }
    
    /**
     * Proceso que crea un comentario en la base de datos
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
        CrearComentariosDTO comDTO = serializadorJSON.fromJson(
                datosJSON, CrearComentariosDTO.class);
        // Validar datos de entrada
        if (comDTO.getContenido() == null 
                || comDTO.getContenido().isEmpty()){
            response.setStatus(400);
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson("Los datos son inválidos"));
            }
            return;
        }
        // Lógica de negocio
        Comentario comNew = new Comentario(comDTO.getFechaHoraCreacion()
                .toString(), comDTO.getContenido());   
        IComentariosBO comBO = new ComentariosBO();
        try {
            Comentario savedCom = comBO.agregar(comNew);
            request.setAttribute("comentario", savedCom);
        } catch(NegocioException ne){
            request.setAttribute("error", ne.getMessage());
        }
        // Devolver datos
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(serializadorJSON.toJson(comNew));
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
