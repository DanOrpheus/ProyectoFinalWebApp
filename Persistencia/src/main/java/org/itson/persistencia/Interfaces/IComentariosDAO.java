/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Comentario;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IComentariosDAO {
    /**
     * Método que agrega un objeto de tipo Comentario
     * @param comentario Objeto a agregar
     * @return El objeto Comentario agregado
     */
    public Comentario agregar(Comentario comentario);
    /**
     * Método que elimina un objeto de tipo Comentario
     * @param comentario Objeto a eliminar
     * @return El objeto Comentario eliminado
     */
    public Comentario eliminar(Comentario comentario);
    /**
     * Método que crea una lista con todos los objetos Comentario creados
     * @return La lista de objetos Comentario
     */
    public List<Comentario> consultarComentarios();
}