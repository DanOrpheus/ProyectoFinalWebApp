/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Comentario;
import org.itson.dominio.Usuario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IComentariosDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class ComentariosDAO implements IComentariosDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public ComentariosDAO(){
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }
   
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Comentario
     * @param comentario Objeto a agregar
     * @return El objeto Comentario agregado
     */
    @Override
    public Comentario agregar(Comentario comentario) {
        // Obtener la colección "comentarios" de la base de datos
        MongoCollection<Document> collection
                = baseDatos.getCollection("comentarios");
        // Crear un nuevo documento para el comentario
        Document docComentario = new Document();
        docComentario.append("_id", new ObjectId());
        docComentario.append("contenido", comentario.getContenido());
        docComentario.append("fechaHora", comentario.getFechaHora());
        docComentario.append("autor", comentario.getAutor());
        // Insertar el documento en la colección
        collection.insertOne(docComentario);
        // Establecer el id generado en el objeto comentario
        comentario.setId(docComentario.getObjectId("_id"));
        return comentario;
    }
    /**
     * Método que elimina un objeto de tipo Comentario
     * @param comentario Objeto a eliminar
     * @return El objeto Comentario eliminado
     */
    @Override
    public Comentario eliminar(Comentario comentario) {
        // Obtener la colección donde se guardan los comentarios
        MongoCollection<Document> collection
                = baseDatos.getCollection("comentarios");
        // Crear un filtro para encontrar el comentario por su ID
        Document filtro = new Document("_id", 
                comentario.getId());
        // Eliminar el comentario de la colección
        collection.deleteOne(filtro);
        // Devolver el comentario eliminado
        return comentario;
    }
    /**
     * Método que crea una lista con todos los objetos Comentario creados
     * @return La lista de objetos Comentario
     */
    @Override
    public List<Comentario> consultarComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("comentarios");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Comentario comentario=new Comentario();
            comentario.setId(documento.getObjectId("_id"));
            comentario.setContenido(documento.getString("contenido"));
            comentario.setFechaHora(documento.getString("fechaHora"));
            comentario.setAutor(documento.get("autor", Usuario.class));
            comentarios.add(comentario);
        }
        return comentarios;
    }
}