/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Usuario;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IUsuariosDAO {
    /**
     * Método que agrega un objeto de tipo Usuario
     * @param usuario Objeto a agregar
     * @return El objeto Usuario agregado
     */
    public Usuario agregar(Usuario usuario);
    /**
     * Método que elimina un objeto de tipo Usuario
     * @param usuario Objeto a eliminar
     * @return El objeto Usuario eliminado
     */
    public Usuario eliminar(Usuario usuario);
    /**
     * Método que crea una lista con todos los objetos Usuario creados
     * @return La lista de objetos Usuario
     */
    public List<Usuario> consultarUsuarios();
}