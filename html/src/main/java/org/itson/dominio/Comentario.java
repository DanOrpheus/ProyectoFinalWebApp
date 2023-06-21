/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Comentario {
    // ATRIBUTOS
    private ObjectId id;
    private Date fechaHora;
    private String contenido;
    
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Comentario() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando id
     * @param fechaHora Fecha y hora del comentario
     * @param contenido Contenido del comentario
     */
    public Comentario(Date fechaHora, String contenido) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Identificador de la clase
     * @param fechaHora Fecha y hora del comentario
     * @param contenido Contenido del comentario
     */
    public Comentario(ObjectId id, Date fechaHora, String contenido) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
    }
    
    // GETTERS Y SETTERS
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    /**
     * Método equals
     * @param obj Objeto a comparar
     * @return True si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + 
                ", contenido=" + contenido + '}';
    } 
}