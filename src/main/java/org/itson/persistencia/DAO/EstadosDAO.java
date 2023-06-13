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
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     */
    @Override
    public Estado agregar(Estado estado) {
        // Obtener la colección "estados" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("estados");
        // Crear un nuevo documento para el post
        Document docEstado = new Document();
        docEstado.append("_id", new ObjectId());
        docEstado.append("nombre", estado.getNombre());
        // Insertar el documento en la colección
        collection.insertOne(docEstado);
        // Establecer el id generado en el objeto usuario
        estado.setId(docEstado.getObjectId("_id"));
        return estado;
    }

    public Estado modificar(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Estado eliminar(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Estado> consultarEstados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
