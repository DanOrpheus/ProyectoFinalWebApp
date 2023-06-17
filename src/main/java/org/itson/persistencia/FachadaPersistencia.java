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
    // MÉTODOS
    /**
     * Método que guarda un usuario en la base de datos
     * @param usuario 
     */
    public void guardarUsuario(Usuario usuario){
        UsuariosDAO usuariosDAO=new UsuariosDAO();
        usuariosDAO.agregar(usuario);
    }
    /**
     * Método que guarda un post en la base de datos
     * @param post 
     */
    public void guardarPost(Post post){
        PostsDAO postsDAO=new PostsDAO();
        postsDAO.agregar(post);
    }
    /**
     * Método que guarda un admin en la base de datos
     * @param admin 
     */
    public void guardarAdmin(Admin admin){
        AdminsDAO adminsDAO=new AdminsDAO();
        adminsDAO.agregar(admin);
    }
    /**
     * Método que guarda un post anclado en la base de datos
     * @param anclado 
     */
    public void guardarAnclados(Anclado anclado){
        AncladosDAO ancladosDAO=new AncladosDAO();
        ancladosDAO.agregar(anclado);
    }
    /**
     * Método que guarda un comentario en la base de datos
     * @param comentario 
     */
    public void guardarComentario(Comentario comentario){
        ComentariosDAO comentariosDAO=new ComentariosDAO();
        comentariosDAO.agregar(comentario);
    }
    /**
     * Método que modifica un post de la base de datos
     * @param post 
     */
    public void modificarPost(Post post){
        PostsDAO postsDAO=new PostsDAO();
        postsDAO.modificar(post);
    }
    /**
     * Método que modifica un anclado de la base de datos
     * @param anclado 
     */
    public void modificarAnclado(Anclado anclado){
        AncladosDAO ancladosDAO=new AncladosDAO();
        ancladosDAO.modificar(anclado);
    }
    /**
     * Método que elimina un post de la base de datos
     * @param post 
     */
    public void eliminarPost(Post post){
        PostsDAO postsDAO=new PostsDAO();
        postsDAO.eliminar(post);
    }
    /**
     * Método que elimina un post anclado de la base de datos
     * @param anclado 
     */
    public void eliminarAnclado(Anclado anclado){
        AncladosDAO ancladosDAO=new AncladosDAO();
        ancladosDAO.eliminar(anclado);
    }
    /**
     * Método que elimina un comentario de la base de datos
     * @param comentario 
     */
    public void eliminarComentario(Comentario comentario){
        ComentariosDAO comentariosDAO=new ComentariosDAO();
        comentariosDAO.eliminar(comentario);
    }
}