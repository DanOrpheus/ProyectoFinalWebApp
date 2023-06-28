/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
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
import org.itson.persistencia.Excepciones.PersistenciaException;

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
    
    // CONSTRUCTORES
    public FachadaPersistencia() {
        this.usDAO = new UsuariosDAO();
        this.posDAO = new PostsDAO();
        this.adDAO = new AdminsDAO();
        this.ancDAO = new AncladosDAO();
        this.comDAO = new ComentariosDAO();
    }

    // MÉTODOS
    /**
     * Método que guarda un usuario en la base de datos
     * @param usuario 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Usuario guardarUsuario(Usuario usuario) 
            throws PersistenciaException {
        return this.usDAO.agregar(usuario);
    }
    /**
     * Método que guarda un post en la base de datos
     * @param post 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Post guardarPost(Post post) 
            throws PersistenciaException {
        return this.posDAO.agregar(post);
    }
    /**
     * Método que guarda un admin en la base de datos
     * @param admin 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Admin guardarAdmin(Admin admin) 
            throws PersistenciaException {
        return this.adDAO.agregar(admin);
    }
    /**
     * Método que guarda un post anclado en la base de datos
     * @param anclado 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Anclado guardarAnclados(Anclado anclado) 
            throws PersistenciaException {
        return this.ancDAO.agregar(anclado);
    }
    /**
     * Método que guarda un comentario en la base de datos
     * @param comentario 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Comentario guardarComentario(Comentario comentario) 
            throws PersistenciaException {
        return this.comDAO.agregar(comentario);
    }
    /**
     * Método que modifica un post de la base de datos
     * @param post 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Post modificarPost(Post post) 
            throws PersistenciaException {
        return this.posDAO.modificar(post);
    }
    /**
     * Método que modifica un anclado de la base de datos
     * @param anclado 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Anclado modificarAnclado(Anclado anclado) 
            throws PersistenciaException {
        return this.ancDAO.modificar(anclado);
    }
    /**
     * Método que elimina un post de la base de datos
     * @param post 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Post eliminarPost(Post post) 
            throws PersistenciaException {
        return this.posDAO.eliminar(post);
    }
    /**
     * Método que elimina un post anclado de la base de datos
     * @param anclado 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Anclado eliminarAnclado(Anclado anclado) 
            throws PersistenciaException {
        return this.ancDAO.eliminar(anclado);
    }
    /**
     * Método que elimina un comentario de la base de datos
     * @param comentario 
     * @return  
     * @throws org.itson.persistencia.Excepciones.PersistenciaException  
     */
    public Comentario eliminarComentario(Comentario comentario) 
            throws PersistenciaException {
        return this.comDAO.eliminar(comentario);
    }
    /**
     * Método que elimina un usuario de la base de datos
     * @param usuario
     * @return
     * @throws PersistenciaException 
     */
    public Usuario eliminarUsuario(Usuario usuario) 
            throws PersistenciaException {
        return this.usDAO.eliminar(usuario);
    }
    /**
     * Método que elimina un admin de la base de datos
     * @param admin
     * @return
     * @throws PersistenciaException 
     */
    public Admin eliminarAdmin(Admin admin) 
            throws PersistenciaException {
        return this.adDAO.eliminar(admin);
    }
    /**
     * Método que consulta los usuarios de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    public List<Usuario> consultarUsuarios() 
            throws PersistenciaException {
        return this.usDAO.consultarUsuarios();
    }
    /**
     * Método que consulta los admins de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    public List<Admin> consultarAdmins() 
            throws PersistenciaException {
        return this.adDAO.consultarAdmins();
    }
    /**
     * Método que consulta los comentarios de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    public List<Comentario> consultarComentarios() 
            throws PersistenciaException {
        return this.comDAO.consultarComentarios();
    }
    /**
     * Método que consulta los posts de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    public List<Post> consultarPosts() 
            throws PersistenciaException {
        return this.posDAO.consultarPosts();
    }
    /**
     * Método que consulta los posts anclados de la base de datos
     * @return
     * @throws PersistenciaException 
     */
    public List<Anclado> consultarAnclados() 
            throws PersistenciaException {
        return this.ancDAO.consultarAnclados();
    }
}