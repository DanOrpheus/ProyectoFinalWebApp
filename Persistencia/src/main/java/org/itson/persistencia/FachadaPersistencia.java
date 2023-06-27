/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import org.itson.dominio.Admin;
import org.itson.dominio.Anclado;
import org.itson.dominio.Comentario;
import org.itson.dominio.Post;
import org.itson.dominio.Usuario;
import org.itson.persistencia.DAO.AdminsDAO;
import org.itson.persistencia.DAO.AncladosDAO;
import org.itson.persistencia.DAO.ComentariosDAO;
import org.itson.persistencia.DAO.PostsDAO;
import org.itson.persistencia.DAO.UsuariosDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class FachadaPersistencia {
    // ATRIBUTOS DE LA CLASE
    private UsuariosDAO usDAO;
    private PostsDAO posDAO;
    private AdminsDAO adDAO;
    private AncladosDAO ancDAO;
    private ComentariosDAO comDAO;
    
    // MÉTODOS
    /**
     * Método que guarda un usuario en la base de datos
     * @param usuario 
     * @return  
     */
    public Usuario guardarUsuario(Usuario usuario){
        return this.usDAO.agregar(usuario);
    }
    /**
     * Método que guarda un post en la base de datos
     * @param post 
     * @return  
     */
    public Post guardarPost(Post post){
        return this.posDAO.agregar(post);
    }
    /**
     * Método que guarda un admin en la base de datos
     * @param admin 
     * @return  
     */
    public Admin guardarAdmin(Admin admin){
        return this.adDAO.agregar(admin);
    }
    /**
     * Método que guarda un post anclado en la base de datos
     * @param anclado 
     * @return  
     */
    public Anclado guardarAnclados(Anclado anclado){
        return this.ancDAO.agregar(anclado);
    }
    /**
     * Método que guarda un comentario en la base de datos
     * @param comentario 
     * @return  
     */
    public Comentario guardarComentario(Comentario comentario){
        return this.comDAO.agregar(comentario);
    }
    /**
     * Método que modifica un post de la base de datos
     * @param post 
     * @return  
     */
    public Post modificarPost(Post post){
        return this.posDAO.modificar(post);
    }
    /**
     * Método que modifica un anclado de la base de datos
     * @param anclado 
     * @return  
     */
    public Anclado modificarAnclado(Anclado anclado){
        return this.ancDAO.modificar(anclado);
    }
    /**
     * Método que elimina un post de la base de datos
     * @param post 
     * @return  
     */
    public Post eliminarPost(Post post){
        return this.posDAO.eliminar(post);
    }
    /**
     * Método que elimina un post anclado de la base de datos
     * @param anclado 
     * @return  
     */
    public Anclado eliminarAnclado(Anclado anclado){
        return this.ancDAO.eliminar(anclado);
    }
    /**
     * Método que elimina un comentario de la base de datos
     * @param comentario 
     * @return  
     */
    public Comentario eliminarComentario(Comentario comentario){
        return this.comDAO.eliminar(comentario);
    }
}