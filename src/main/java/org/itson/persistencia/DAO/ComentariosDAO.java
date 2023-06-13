/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Comentario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IComentariosDAO;

public class ComentariosDAO implements IComentariosDAO {
   
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    
    public ComentariosDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

   
    @Override
    public Comentario agregar(Comentario comentario) {
       
        MongoCollection<Document> collection
                = baseDatos.getCollection("comentarios");
        
        Document docComentario = new Document();
        docComentario.append("_id", new ObjectId());
        docComentario.append("fechaHora", comentario.getFechaHora());
        docComentario.append("contenido", comentario.getContenido());
        
        collection.insertOne(docComentario);
        
        comentario.setId(docComentario.getObjectId("_id"));
        return comentario;
    }
   

   
    
    @Override
    public Comentario eliminar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Comentario> consultarComentarios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


