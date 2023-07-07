/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.metweb.negocio.interfaces;

import java.util.List;
import org.itson.dominio.Comentario;
import org.itson.metweb.Excepciones.NegocioException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IComentariosBO {
    // MÉTODOS
    /**
     * Método que agrega un comentario a la base de datos con validaciones
     * @param com
     * @return
     * @throws NegocioException 
     */
    Comentario agregar(Comentario com) throws NegocioException;
    /**
     * Método que eliminar un comentario de la base de datos con validaciones
     * @param com
     * @return
     * @throws NegocioException 
     */
    Comentario eliminar(Comentario com) throws NegocioException;
    /**
     * Método que consulta los comentarios de la base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    List<Comentario> consultarComentarios() throws NegocioException;
}
