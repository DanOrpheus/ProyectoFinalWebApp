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
import org.itson.dominio.Municipio;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IMunicipiosDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class MunicipiosDAO implements IMunicipiosDAO {
    //atributos
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public MunicipiosDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Municipio
     * @param municipio Objeto a agregar
     * @return El objeto Municipio agregado
     */
    @Override
    public Municipio agregar(Municipio municipio) {
        // Obtener la colección "municipios" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("municipios");
        // Crear un nuevo documento para el municipio
        Document docMunicipio = new Document();
        docMunicipio.append("_id", new ObjectId());
        docMunicipio.append("nombre", municipio.getNombre());
        docMunicipio.append("estado", municipio.getEstado());
        // Insertar el documento en la colección
        collection.insertOne(docMunicipio);
        // Establecer el id generado en el objeto municipio
        municipio.setId(docMunicipio.getObjectId("_id"));
        return municipio;
    }
    /**
     * Método que elimina un objeto de tipo Municipio
     * @param municipio Objeto a eliminar
     * @return El objeto Municipio eliminado
     */
    @Override
    public Municipio eliminar(Municipio municipio) {
        // Obtener la colección donde se guardan los municipios
        MongoCollection<Document> collection = 
                baseDatos.getCollection("municipios");
        // Crear un filtro para encontrar el municipio por su ID
        Document filtro = new Document("nombre", 
                municipio.getNombre());
        // Eliminar el municipio de la colección
        collection.deleteOne(filtro);
        // Devolver el municipio eliminada
        return municipio;
    }
    /**
     * Método que crea una lista con todos los objetos Municipio creados
     * @return La lista de objetos Municipio
     */
    @Override
    public List<Municipio> consultarMunicipios() {
        List<Municipio> municipios = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("municipios");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Municipio municipio = new Municipio();
            municipio.setId(documento.getObjectId("_id"));
            municipio.setNombre(documento.getString("nombre"));
            municipio.setEstado(documento.get("estado", Estado.class));
            municipios.add(municipio);
        }
        return municipios;
    }
}