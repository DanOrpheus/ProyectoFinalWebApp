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
import org.itson.dominio.Admin;
import org.itson.dominio.Municipio;
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
     * Método que agrega un objeto de tipo Admin
     * @param admin Objeto a agregar
     * @return El objeto Admin agregado
     */
    @Override
    public Admin agregar(Admin admin) {
        // Obtener la colección "admins" de la base de datos
        MongoCollection<Document> collection = 
                baseDatos.getCollection("admins");
        // Crear un nuevo documento para el admin
        Document docAdmin = new Document();
        docAdmin.append("_id", new ObjectId());
        docAdmin.append("nombreCompleto", 
                admin.getNombreCompleto());
        docAdmin.append("correo", admin.getCorreo());
        docAdmin.append("contrasenia", admin.getContrasenia());
        docAdmin.append("telefono", admin.getTelefono());
        docAdmin.append("avatar", admin.getAvatar());
        docAdmin.append("ciudad", admin.getCiudad());
        docAdmin.append("fechaNacimiento", 
                admin.getFechaNacimiento());
        docAdmin.append("genero", admin.getGenero());
        docAdmin.append("municipio", admin.getMunicipio());
        // Insertar el documento en la colección
        collection.insertOne(docAdmin);
        // Establecer el id generado en el objeto admin
        admin.setId(docAdmin.getObjectId("_id"));
        return admin;
    }
    /**
     * Método que elimina un objeto de tipo Admin
     * @param admin Objeto a eliminar
     * @return El objeto Admin eliminado
     */
    @Override
    public Admin eliminar(Admin admin) {
        // Obtener la colección donde se guardan los admins
        MongoCollection<Document> collection = 
                baseDatos.getCollection("admins");
        // Crear un filtro para encontrar el admin por su ID
        Document filtro = new Document("nombre", 
                admin.getNombreCompleto());
        // Eliminar el admin de la colección
        collection.deleteOne(filtro);
        // Devolver el admin eliminada
        return admin;
    }
    /**
     * Método que crea una lista con todos los objetos Admin creados
     * @return La lista de objetos Admin
     */
    @Override
    public List<Admin> consultarAdmins() {
        List<Admin> admins = new ArrayList<>();
        MongoCollection<Document> collection = 
                baseDatos.getCollection("admins");
        FindIterable<Document> documentos = collection.find();
        for (Document documento : documentos) {
            Admin admin = new Admin();
            admin.setId(documento.getObjectId("_id"));
            admin.setNombreCompleto(
                    documento.getString("nombreCompleto"));
            admin.setCorreo(documento.getString("correo"));
            admin.setContrasenia(
                    documento.getString("contrasenia"));
            admin.setTelefono(documento.getString("telefono"));
            admin.setAvatar(documento.getString("avatar"));
            admin.setCiudad(documento.getString("ciudad"));
            admin.setFechaNacimiento(
                    documento.getDate("fechaNacimiento"));
            admin.setGenero(documento.getString("genero"));
            admin.setMunicipio(documento.get("municipio", 
                    Municipio.class));
            admins.add(admin);
        }
        return admins;
    }
}