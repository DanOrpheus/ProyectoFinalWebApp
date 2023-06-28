/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.metweb.negocio.interfaces;

import java.util.List;
import org.itson.dominio.Usuario;
import org.itson.metweb.Excepciones.NegocioException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IUsuariosBO {
    // MÉTODOS
    /**
     * Método que agrega un usuario a la base con validaciones
     * @param usuario
     * @return
     * @throws NegocioException 
     */
    Usuario agregar(Usuario usuario) throws NegocioException;
    /**
     * Método que elimina un usuario de la base con validaciones
     * @param usuario
     * @return
     * @throws NegocioException 
     */
    Usuario eliminar(Usuario usuario) throws NegocioException;
    /**
     * Método que consulta los usuarios de la base con validaciones
     * @return
     * @throws NegocioException 
     */
    List<Usuario> consultarUsuarios() throws NegocioException;
}
