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
import org.itson.dominio.Municipio;
import org.itson.dominio.Normal;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.INormalesDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class NormalesDAO implements INormalesDAO {
    //ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
   
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public NormalesDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Normal
     * @param normal Objeto a agregar
     * @return El objeto Normal agregado
     */
    @Override
    public Normal agregar(Normal normal) {
        // Obtener la colección "normales" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("normales");
        // Crear un nuevo documento para el objeto normal
        Document docNormal = new Document();
        docNormal.append("_id", new ObjectId());
        docNormal.append("nombreCompleto", 
                normal.getNombreCompleto());
        docNormal.append("correo", normal.getCorreo());
        docNormal.append("contrasenia", normal.getContrasenia());
        docNormal.append("telefono", normal.getTelefono());
        docNormal.append("avatar", normal.getAvatar());
        docNormal.append("ciudad", normal.getCiudad());
        docNormal.append("fechaNacimiento", 
                normal.getFechaNacimiento());
        docNormal.append("genero", normal.getGenero());
        docNormal.append("municipio", normal.getMunicipio());
        // Insertar el documento en la colección
        collection.insertOne(docNormal);
        // Establecer el id generado en el objeto normal
        normal.setId(docNormal.getObjectId("_id"));
        return normal;
    }
    /**
     * Método que elimina un objeto de tipo Normal
     * @param normal Objeto a eliminar
     * @return El objeto Normal eliminado
     */
    @Override
    public Normal eliminar(Normal normal) {
        // Obtener la colección donde se guardan los normales
        MongoCollection<Document> collection = 
                baseDatos.getCollection("normales");
        // Crear un filtro para encontrar el normal por su ID
        Document filtro = new Document("nombre", 
                normal.getNombreCompleto());
        // Eliminar el normal de la colección
        collection.deleteOne(filtro);
        // Devolver el normal eliminada
        return normal;
    }
    /**
     * Método que crea una lista con todos los objetos Normal creados
     * @return La lista de objetos Normal
     */
    @Override
    public List<Normal> consultarNormales() {
        List<Normal> normales = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("normales");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Normal normal = new Normal();
            normal.setId(documento.getObjectId("_id"));
            normal.setNombreCompleto(
                    documento.getString("nombreCompleto"));
            normal.setCorreo(documento.getString("correo"));
            normal.setContrasenia(
                    documento.getString("contrasenia"));
            normal.setTelefono(documento.getString("telefono"));
            normal.setAvatar(documento.getString("avatar"));
            normal.setCiudad(documento.getString("ciudad"));
            normal.setFechaNacimiento(
                    documento.getDate("fechaNacimiento"));
            normal.setGenero(documento.getString("genero"));
            normal.setMunicipio(documento.get("municipio", 
                    Municipio.class));
            normales.add(normal);
        }
        return normales;
    }
}