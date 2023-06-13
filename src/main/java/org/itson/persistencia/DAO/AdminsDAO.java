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
import org.itson.dominio.Post;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IAdminsDAO;
/**
 *
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class AdminsDAO implements IAdminsDAO{
    //ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
   
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public AdminsDAO() {
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
    public Post agregar(){
        // Obtener la colección "posts" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("admins");
        //Crear un nuevo documento para el post
        Document docPost = new Document();
        docPost.append("_id", new ObjectId());
    }
}
