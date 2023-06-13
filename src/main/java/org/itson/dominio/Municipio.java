/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;
import org.bson.types.ObjectId;
/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Municipio {
    private ObjectId id;
    private String nombre;

    // Constructor
    public Municipio(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
