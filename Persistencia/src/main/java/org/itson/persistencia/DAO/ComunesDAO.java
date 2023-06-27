/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Comun;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IComunesDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class ComunesDAO implements IComunesDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public ComunesDAO(){
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Comun
     * @param comun Objeto a agregar
     * @return El objeto Comun agregado
     */
    @Override
    public Comun agregar(Comun comun) {
        // Obtener la colección "comunes" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("comunes");
        // Crear un nuevo documento para el comun
        Document docComun = new Document();
        docComun.append("_id", new ObjectId());
        docComun.append("fechaHoraCreacion", comun.getFechaHoraCreacion());
        docComun.append("titulo", comun.getTitulo());
        docComun.append("contenido", comun.getContenido());
        docComun.append("fechaHoraEdicion", comun.getFechaHoraEdicion());
        // Insertar el documento en la colección
        collection.insertOne(docComun);
        // Establecer el id generado en el objeto comun
        comun.setId(docComun.getObjectId("_id"));
        return comun;
    }
    /**
     * Método que modifica un objeto de tipo Comun
     * @param comun Objeto a modificar
     * @return El objeto Comun modificado
     */
    @Override
    public Comun modificar(Comun comun) {
        // Obtener la colección donde se guardan los comunes
        MongoCollection<Document> collection = 
                baseDatos.getCollection("comunes");
        // Crear un filtro para encontrar el comun por su ID
        Document filtro = new Document("_id", comun.getId());
        Document update = new Document();
        update.append("$set", 
                new Document("fechaHoraCreacion", comun.getFechaHoraCreacion())
                    .append("titulo", comun.getTitulo())
                    .append("contenido", comun.getContenido())
                    .append("fechaHoraEdicion", comun.getFechaHoraEdicion()));
        // Actualizar el comun de la colección
        collection.updateOne(filtro, update);
        // Devolver el comun eliminado
        return comun;
    }
    /**
     * Método que elimina un objeto de tipo Comun
     * @param comun Objeto a eliminar
     * @return El objeto Comun eliminado
     */
    @Override
    public Comun eliminar(Comun comun) {
        // Obtener la colección donde se guardan los comunes
        MongoCollection<Document> collection = 
                baseDatos.getCollection("comunes");
        // Crear un filtro para encontrar el comun por su ID
        Document filtro = new Document("titulo", 
                comun.getTitulo());
        // Eliminar el comun de la colección
        collection.deleteOne(filtro);
        // Devolver el comun eliminada
        return comun;
    }
    /**
     * Método que crea una lista con todos los objetos Comun creados
     * @return La lista de objetos Comun
     */
    @Override
    public List<Comun> consultarComunes() {
        List<Comun> comunes = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("comunes");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Comun comun = new Comun();
            comun.setId(documento.getObjectId("_id"));
            comun.setFechaHoraCreacion(
                    documento.getDate("fechaHoraCreacion"));
            comun.setTitulo(documento.getString("titulo"));
            comun.setContenido(documento.getString("contenido"));
            comun.setFechaHoraEdicion(documento.getDate("fechaHoraEdicion"));
            comunes.add(comun);
        }
        return comunes;
    }
}