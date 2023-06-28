/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package org.itson.metweb.filtros;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Victor
 * @version IDE 17
 */
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
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
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        String ip = sr.getRemoteAddr();
        Date fecha = new Date();
        String mensaje = String.format("Ip: %s, Fecha: %s", ip, fecha);
        System.err.println(mensaje);
        // Continua la petición
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
    }
}
