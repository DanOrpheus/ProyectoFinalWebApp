/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Anclado extends Post {
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Anclado() {
    }
    /**
     * Constructor que inicializa los atributos de la clase padre
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     * @param fechaHoraEdicion 
     */
    public Anclado(String fechaHoraCreacion, String titulo, String contenido, 
            String fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }
}