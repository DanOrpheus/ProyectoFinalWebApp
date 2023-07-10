/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.negocio.implementaciones;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Post;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.interfaces.IPostsBO;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.FachadaPersistencia;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class PostsBO implements IPostsBO {
    // ATRIBUTOS
    FachadaPersistencia fachada;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa el atributo de fachada
     */
    public PostsBO() {
        this.fachada = new FachadaPersistencia();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un post a la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    @Override
    public Post agregar(Post post) throws NegocioException {
        try {
            Post nPost = this.fachada.guardarPost(post);
            ObjectId id = new ObjectId();
            nPost.setId(id);
            return nPost;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que modifica un post de la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    @Override
    public Post modificar(Post post) throws NegocioException {
        try {
            Post mPost = this.fachada.modificarPost(post);
            return mPost;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que eliminar un post de la base de datos con validaciones
     * @param post
     * @return
     * @throws NegocioException 
     */
    @Override
    public Post eliminar(Post post) throws NegocioException {
        try {
            Post ePost = this.fachada.eliminarPost(post);
            return ePost;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consulta los posts de la base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Post> consultarPosts() throws NegocioException {
        try {
            List<Post> posts = this.fachada.consultarPosts();
            return posts;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consulta un post por su id de la base de 
     * datos con validaciones
     * @param id Id a consultar
     * @return
     * @throws NegocioException
     */
    @Override
    public Post consultarPostPorId(ObjectId id) throws NegocioException {
        try {
            Post cPost = this.fachada.consultarPostPorId(id);
            return cPost;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
}