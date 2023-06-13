/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Post;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IPostsDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class PostsDAO implements IPostsDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public PostsDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     */
    @Override
    public Post agregar(Post post) {
                // Obtener la colección "posts" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("posts");
        // Crear un nuevo documento para el post
        Document docPost = new Document();
        docPost.append("_id", new ObjectId());
        docPost.append("fechaHoraCreacion", post.getFechaHoraCreacion());
        docPost.append("titulo", post.getTitulo());
        docPost.append("contenido", post.getContenido());
        docPost.append("fechaHoraEdicion", post.getFechaHoraEdicion());
        // Insertar el documento en la colección
        collection.insertOne(docPost);
        // Establecer el id generado en el objeto usuario
        post.setId(docPost.getObjectId("_id"));
        return post;
    }
    /**
     * Método que modifica un objeto de tipo Post
     * @param post Objeto a modificar
     * @return El objeto Post modificado
     */
    @Override
    public Post modificar(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método que elimina un objeto de tipo Post
     * @param post Objeto a eliminar
     * @return El objeto Post eliminado
     */
    @Override
    public Post eliminar(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método que crea una lista con todos los objetos Post creados
     * @return La lista de objetos Post
     */
    @Override
    public List<Post> consultarPosts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}