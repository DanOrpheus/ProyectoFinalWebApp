/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Usuario;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IUsuariosDAO {
    /**
     * Método que agrega un objeto de tipo Usuario
     * @param usuario Objeto a agregar
     * @return El objeto Usuario agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Usuario agregar(Usuario usuario) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Usuario
     * @param usuario Objeto a eliminar
     * @return El objeto Usuario eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Usuario eliminar(Usuario usuario) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Usuario creados
     * @return La lista de objetos Usuario
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Usuario> consultarUsuarios() throws PersistenciaException;
}