/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package org.itson.metweb.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Victor
 * @version IDE 17
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    // ATRIBUTOS DE LA CLASE
    private final static String[] pathsPublicos = 
    { "login.jsp" , "/auth" , "register.jsp", "index.jsp"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void destroy() {
    }

    /**
     * Método que realiza el filtrado
     * @param sr
     * @param sr1
     * @param fc
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) 
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)sr;
        String path = this.getPathSolicited(httpRequest);
        boolean isPathPrivate = this.isPathPrivate(path);
        boolean isUserLogged = this.isUserLoggedIn(httpRequest);
        if(isPathPrivate && !isUserLogged){
            sr.getServletContext().getRequestDispatcher(
                    "/login.jsp").forward(sr, sr1);
            return;
        }
        fc.doFilter(sr, sr1);
    }
    
    /**
     * Método que obtiene el path de la URI que se solicita
     * @param request
     * @return 
     */
    private String getPathSolicited(HttpServletRequest request){
        String uriSolicited = request.getRequestURI();
        String path = uriSolicited.substring(
                request.getContextPath().length());
        return path;
    }
    
    /**
     * Método que verifica si un path es público o no
     * @param path
     * @return 
     */
    private boolean isPathPrivate(String path){
        for(String pathPublico : AuthFilter.pathsPublicos){
            if(path.startsWith(pathPublico)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método que verifica si un usuario esta logeado en una sesión
     * @param request
     * @return 
     */
    private boolean isUserLoggedIn(HttpServletRequest request){
        HttpSession sesion = request.getSession(false);
        return (sesion != null && sesion.getAttribute("usuario") != null);
    }
}