/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import org.itson.dominio.Anclado;
import org.itson.dominio.Comun;
import org.itson.dominio.Post;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class PostFactory {
    // MÉTODOS
    /**
     * Método para crear ciertos tipos de objetos Post
     * @param tipo
     * @return 
     */
    public static Post getPost(String tipo){
        if (tipo.equalsIgnoreCase("Anclado")){
            return new Anclado();
        } else if(tipo.equalsIgnoreCase("Comun")){
            return new Comun();
        }
        return null;
    }
}