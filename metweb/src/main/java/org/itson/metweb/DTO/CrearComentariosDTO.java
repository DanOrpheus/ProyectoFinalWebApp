/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.DTO;

import java.util.Date;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class CrearComentariosDTO {
    // ATRIBUTOS
    private String contenido;
    private Date fechaHoraCreacion;
    
    // GETTERS & SETTERS
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }
}