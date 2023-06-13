/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Municipio {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private Estado estado;
    
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Municipio() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando el id
     * @param nombre Nombre del municipio
     * @param estado Estado al que pertenece el municipio
     */
    public Municipio(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Identificador de la clase
     * @param nombre Nombre del municipio
     * @param estado Estado al que pertenece el municipio
     */
    public Municipio(ObjectId id, String nombre, Estado estado) {
        this.id = id;
        this.nombre = nombre;
    }

    public ObjectId getId() {
        return id;
    }
    // GETTERS Y SETTERS
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Municipio other = (Municipio) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + 
                ", estado=" + estado + '}';
    }
}