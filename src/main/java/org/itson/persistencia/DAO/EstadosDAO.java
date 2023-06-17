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
import org.itson.dominio.Estado;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IEstadosDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class EstadosDAO implements IEstadosDAO {
    //Atributos
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public EstadosDAO(){
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Estado
     * @param estado Objeto a agregar
     * @return El objeto Estado agregado
     */
    @Override
    public Estado agregar(Estado estado) {
        // Obtener la colección "estados" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("estados");
        // Crear un nuevo documento para el estado
        Document docEstado = new Document();
        docEstado.append("_id", new ObjectId());
        docEstado.append("nombre", estado.getNombre());
        // Insertar el documento en la colección
        collection.insertOne(docEstado);
        // Establecer el id generado en el objeto estado
        estado.setId(docEstado.getObjectId("_id"));
        return estado;
    }
    /**
     * Método que elimina un objeto de tipo Estado
     * @param estado Objeto a eliminar
     * @return El objeto Estado eliminado
     */
    @Override
    public Estado eliminar(Estado estado) {
        // Obtener la colección donde se guardan los estados
        MongoCollection<Document> collection = 
                baseDatos.getCollection("estados");
        // Crear un filtro para encontrar el estado por su ID
        Document filtro = new Document("nombre", 
                estado.getNombre());
        // Eliminar el estado de la colección
        collection.deleteOne(filtro);
        // Devolver el estado eliminada
        return estado;
    }
    /**
     * Método que crea una lista con todos los objetos Estado creados
     * @return La lista de objetos Estado
     */
    @Override
    public List<Estado> consultarEstados() {
        List<Estado> estados = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("estados");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Estado estado = new Estado();
            estado.setId(documento.getObjectId("_id"));
            estado.setNombre(documento.getString("nombre"));
            estados.add(estado);
        }
        return estados;
    }
}