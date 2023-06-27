/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import org.itson.dominio.Admin;
import org.itson.dominio.Normal;
import org.itson.dominio.Usuario;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class UsuarioFactory {
    // MÉTODOS
    /**
     * Método para crear ciertos tipos de objetos Usuario
     * @param tipo
     * @return 
     */
    public static Usuario getUsuario(String tipo){
        if (tipo.equalsIgnoreCase("Admin")){
            return new Admin();
        } else if(tipo.equalsIgnoreCase("Normal")){
            return new Normal();
        }
        return null;
    }
}
