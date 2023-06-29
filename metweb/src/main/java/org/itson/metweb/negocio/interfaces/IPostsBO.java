/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.metweb.negocio.interfaces;

import java.util.List;
import org.itson.dominio.Post;
import org.itson.metweb.Excepciones.NegocioException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IPostsBO {
    // MÉTODOS
    /**
     * Método que agrega un post a la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    Post agregar(Post post) throws NegocioException;
    /**
     * Método que modifica un post de la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    Post modificar(Post post) throws NegocioException;
    /**
     * Método que eliminar un post de la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    Post eliminar(Post post) throws NegocioException;
    /**
     * Método que consulta los posts de la base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    List<Post> consultarPosts() throws NegocioException;
}