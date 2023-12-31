/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Post;
import org.itson.dominio.Usuario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Excepciones.PersistenciaException;
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
    public Post agregar(Post post) throws PersistenciaException {
        try {
            // Obtener la colección "posts" de la base de datos
            MongoCollection<Document> collection = 
                baseDatos.getCollection("posts");
            // Crear un nuevo documento para el post
            Document docPost = new Document();
            docPost.append("_id", new ObjectId());
            docPost.append("titulo", post.getTitulo());
            docPost.append("contenido", post.getContenido());
            docPost.append("fechaHoraCreacion", post.getFechaHoraCreacion());
            docPost.append("autor", post.getAutor());
            // Insertar el documento en la colección
            collection.insertOne(docPost);
            // Establecer el id generado en el objeto post
            post.setId(docPost.getObjectId("_id"));
            return post;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al crear el post" + me.getMessage());
        }
    }
    /**
     * Método que modifica un objeto de tipo Post
     * @param post Objeto a modificar
     * @return El objeto Post modificado
     */
    @Override
    public Post modificar(Post post) throws PersistenciaException {
        try {
            // Obtener la colección donde se guardan los posts
            MongoCollection<Document> collection = 
                baseDatos.getCollection("posts");
            // Crear un filtro para encontrar el post por su ID
            Document filtro = new Document("_id", post.getId());
            Document update = new Document();
            update.append("$set", 
                new Document("titulo", post.getTitulo())
                    .append("contenido", post.getContenido())
                    .append("fechaHoraCreacion", post.getFechaHoraCreacion()));
            // Actualizar el post de la colección
            collection.updateOne(filtro, update);
            // Devolver el post eliminado
            return post;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al modificar el post" + me.getMessage());
        }
    }
    /**
     * Método que elimina un objeto de tipo Post
     * @param post Objeto a eliminar
     * @return El objeto Post eliminado
     */
    @Override
    public Post eliminar(Post post) throws PersistenciaException {
        try {
            // Obtener la colección donde se guardan los posts
            MongoCollection<Document> collection = 
                baseDatos.getCollection("post");
            // Crear un filtro para encontrar el post por su ID
            Document filtro = new Document("titulo", 
                post.getTitulo());
            // Eliminar el post de la colección
            collection.deleteOne(filtro);
            // Devolver el post eliminada
            return post;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al eliminar el post" + me.getMessage());
        }
    }
    /**
     * Método que crea una lista con todos los objetos Post creados
     * @return La lista de objetos Post
     */
    @Override
    public List<Post> consultarPosts() throws PersistenciaException {
        try {
            List<Post> posts = new ArrayList<>();
            MongoCollection<Document> collection = 
                baseDatos.getCollection("post");
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                Post post=new Post();
                post.setId(documento.getObjectId("_id"));
                post.setTitulo(documento.getString("titulo"));
                post.setContenido(documento.getString("contenido"));
                post.setFechaHoraCreacion(
                    documento.getString("fechaHoraCreacion"));
                post.setAutor(documento.get("autor", Usuario.class));
                posts.add(post);
            }
            return posts;
        } catch(MongoException me){
            throw new PersistenciaException("Error al consultar los posts" + me.getMessage());
        }
    }
    /**
     * Método que consulta un objeto por su Id
     * @param id Id del objeto
     * @return El objeto con la id consultada
     * @throws PersistenciaException 
     */
    @Override
    public Post consultarPostPorId(ObjectId id) throws PersistenciaException {
        try {
            Post post = new Post();
            MongoCollection<Document> collection = 
                baseDatos.getCollection("post");            
            // Crear el filtro para la consulta
            Document filter = new Document("_id", id);
            // Realizar la consulta
            Document docPost = collection.find(filter).first();
            // Consultar el post de la colección
            if (docPost != null) {
                // El post fue encontrado
                String title = docPost.getString("title");
                String content = docPost.getString("content");
                String fechaHora = docPost.getString("fechaHoraCreacion");
                post.setTitulo(title);
                post.setContenido(content);
                post.setFechaHoraCreacion(fechaHora);
            } else {
                // El post no fue encontrado
                System.out.println("El post no existe.");
            }
            return post;
        } catch(MongoException me){
            throw new PersistenciaException("Error al consultar el post" + me.getMessage());
        }
    }
}