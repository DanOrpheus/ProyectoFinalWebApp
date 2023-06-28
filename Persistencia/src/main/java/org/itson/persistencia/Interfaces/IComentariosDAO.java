/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Comentario;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IComentariosDAO {
    /**
     * Método que agrega un objeto de tipo Comentario
     * @param comentario Objeto a agregar
     * @return El objeto Comentario agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Comentario agregar(Comentario comentario) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Comentario
     * @param comentario Objeto a eliminar
     * @return El objeto Comentario eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Comentario eliminar(Comentario comentario) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Comentario creados
     * @return La lista de objetos Comentario
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Comentario> consultarComentarios() throws PersistenciaException;
}