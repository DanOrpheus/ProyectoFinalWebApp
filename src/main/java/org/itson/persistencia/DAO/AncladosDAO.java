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
import org.itson.dominio.Anclado;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IAncladosDAO;
/**
 *
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class AncladosDAO implements IAncladosDAO { 
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public AncladosDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Anclado
     * @param anclado Objeto a agregar
     * @return El objeto Anclado agregado
     */
    @Override
    public Anclado agregar(Anclado anclado) {
        // Obtener la colección "anclados" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("anclados");
        // Crear un nuevo documento para el anclado
        Document docAnclado = new Document();
        docAnclado.append("_id", new ObjectId());
        docAnclado.append("fechaHoraCreacion", anclado.getFechaHoraCreacion());
        docAnclado.append("titulo", anclado.getTitulo());
        docAnclado.append("contenido", anclado.getContenido());
        docAnclado.append("fechaHoraEdicion", anclado.getFechaHoraEdicion());
        // Insertar el documento en la colección
        collection.insertOne(docAnclado);
        // Establecer el id generado en el objeto anclado
        anclado.setId(docAnclado.getObjectId("_id"));
        return anclado;        
    }
    /**
     * Método que modifica un objeto de tipo Anclado
     * @param anclado Objeto a modificar
     * @return El objeto Anclado modificado
     */
    @Override
    public Anclado modificar(Anclado anclado) {
       MongoCollection<Document> collection = baseDatos.getCollection("anclados");
    Document filtro = new Document("_id", anclado.getId());
    Document nuevosValores = new Document();
    nuevosValores.append("titulo", anclado.getTitulo());
    nuevosValores.append("contenido", anclado.getContenido());
    nuevosValores.append("fechaHoraEdicion", anclado.getFechaHoraEdicion());
    UpdateOptions opciones = new UpdateOptions().upsert(true);
    collection.updateOne(filtro, new Document("$set", nuevosValores), opciones);
    
    return anclado;}
    /**
     * Método que elimina un objeto de tipo Anclado
     * @param anclado Objeto a eliminar
     * @return El objeto Anclado eliminado
     */
    @Override
    public Anclado eliminar(Anclado anclado) {
        // Obtener la colección donde se guardan los anclados
        MongoCollection<Document> collection = 
                baseDatos.getCollection("anclados");
        // Crear un filtro para encontrar el anclado por su ID
        Document filtro = new Document("titulo", 
                anclado.getTitulo());
        // Eliminar el anclado de la colección
        collection.deleteOne(filtro);
        // Devolver el anclado eliminado
        return anclado;
    }
    /**
     * Método que crea una lista con todos los objetos Anclado creados
     * @return La lista de objetos Anclado
     */
    @Override
    public List<Anclado> consultarPosts() {
        List<Anclado> anclados = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("anclados");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Anclado anclado=new Anclado();
            anclado.setId(documento.getObjectId("_id"));
            anclado.setFechaHoraCreacion(
                    documento.getDate("fechaHoraCreacion"));
            anclado.setTitulo(documento.getString("titulo"));
            anclado.setContenido(documento.getString("contenido"));
            anclado.setFechaHoraEdicion(documento.getDate("fechaHoraEdicion"));
            anclados.add(anclado);
        }
        return anclados;
    }
}