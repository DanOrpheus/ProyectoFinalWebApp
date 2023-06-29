/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Normal extends Usuario {

    public Normal() {
    }

    public Normal(String nombreCompleto, String correo, String contrasenia, 
            String telefono, String avatar, String ciudad, 
            String fechaNacimiento, String genero, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, 
                fechaNacimiento, genero, municipio);
    }
    
}
