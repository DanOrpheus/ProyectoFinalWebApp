/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Post;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IPostsDAO {
    /**
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Post agregar(Post post) throws PersistenciaException;
    /**
     * Método que modifica un objeto de tipo Post
     * @param post Objeto a modificar
     * @return El objeto Post modificado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Post modificar(Post post) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Post
     * @param post Objeto a eliminar
     * @return El objeto Post eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Post eliminar(Post post) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Post creados
     * @return La lista de objetos Post
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Post> consultarPosts() throws PersistenciaException;
}