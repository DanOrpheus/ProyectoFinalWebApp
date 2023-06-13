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
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     */
    @Override
    public Municipio agregar(Municipio municipio) {
        // Obtener la colección "municipios" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("municipios");
        // Crear un nuevo documento para el post
        Document docMunicipio = new Document();
        docMunicipio.append("_id", new ObjectId());
        docMunicipio.append("nombre", municipio.getNombre());
        // Insertar el documento en la colección
        collection.insertOne(docMunicipio);
        // Establecer el id generado en el objeto usuario
        municipio.setId(docMunicipio.getObjectId("_id"));
        return municipio;
    }

    public Municipio modificar(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Municipio eliminar(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Municipio> consultarMunicipios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
