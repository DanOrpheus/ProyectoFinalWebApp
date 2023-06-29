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
public class Admin extends Usuario {
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Admin() {
    }
    /**
     * Constructor para iniciar sesión como admininstrador
     * @param contrasenia
     * @param avatar 
     */
    public Admin(String contrasenia, String avatar) {
        super(contrasenia, avatar);
    }
    /**
     * Constructor que inicializa los atributos de la clase padre
     * @param id
     * @param nombreCompleto
     * @param correo
     * @param contrasenia
     * @param telefono
     * @param avatar
     * @param ciudad
     * @param fechaNacimiento
     * @param genero
     * @param municipio 
     */
    public Admin(ObjectId id, String nombreCompleto, String correo, 
            String contrasenia, String telefono, String avatar, String ciudad, 
            String fechaNacimiento, String genero, Municipio municipio) {
        super(id, nombreCompleto, correo, contrasenia, telefono, 
                avatar, ciudad, fechaNacimiento, genero, municipio);
    }
}