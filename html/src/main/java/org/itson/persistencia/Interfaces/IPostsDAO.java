/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Post;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IPostsDAO {
    /**
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     */
    public Post agregar(Post post);
    /**
     * Método que modifica un objeto de tipo Post
     * @param post Objeto a modificar
     * @return El objeto Post modificado
     */
    public Post modificar(Post post);
    /**
     * Método que elimina un objeto de tipo Post
     * @param post Objeto a eliminar
     * @return El objeto Post eliminado
     */
    public Post eliminar(Post post);
    /**
     * Método que crea una lista con todos los objetos Post creados
     * @return La lista de objetos Post
     */
    public List<Post> consultarPosts();
}