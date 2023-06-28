/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Municipio;
import org.itson.dominio.Usuario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.Interfaces.IUsuariosDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class UsuariosDAO implements IUsuariosDAO{
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public UsuariosDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Usuario
     * @param usuario Objeto a agregar
     * @return El objeto Usuario agregado
     */
    @Override
    public Usuario agregar(Usuario usuario) throws PersistenciaException {
        try {
            // Obtener la colección "usuarios" de la base de datos
            MongoCollection<Document> collection = 
                baseDatos.getCollection("usuarios");
            // Crear un nuevo documento para el usuario
            Document docUsuario = new Document();
            docUsuario.append("_id", new ObjectId());
            docUsuario.append("nombreCompleto", 
                usuario.getNombreCompleto());
            docUsuario.append("correo", usuario.getCorreo());
            docUsuario.append("contrasenia", usuario.getContrasenia());
            docUsuario.append("telefono", usuario.getTelefono());
            docUsuario.append("avatar", usuario.getAvatar());
            docUsuario.append("ciudad", usuario.getCiudad());
            docUsuario.append("fechaNacimiento", 
                usuario.getFechaNacimiento());
            docUsuario.append("genero", usuario.getGenero());
            docUsuario.append("municipio", usuario.getMunicipio());
            // Insertar el documento en la colección
            collection.insertOne(docUsuario);
            // Establecer el id generado en el objeto usuario
            usuario.setId(docUsuario.getObjectId("_id"));
            return usuario;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al crear el usuario" + me.getMessage());
        }
    }
    /**
     * Método que elimina un objeto de tipo Usuario
     * @param usuario Objeto a eliminar
     * @return El objeto Usuario eliminado
     */
    @Override
    public Usuario eliminar(Usuario usuario) throws PersistenciaException {
        try{
            // Obtener la colección donde se guardan los usuarios
            MongoCollection<Document> collection = 
                baseDatos.getCollection("usuarios");
            // Crear un filtro para encontrar el usuario por su ID
            Document filtro = new Document("nombre", 
                usuario.getNombreCompleto());
            // Eliminar el usuario de la colección
            collection.deleteOne(filtro);
            // Devolver el usuario eliminada
            return usuario;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al eliminar el usuario" + me.getMessage());
        }
    }
    /**
     * Método que crea una lista con todos los objetos Usuario creados
     * @return La lista de objetos Usuario
     */
    @Override
    public List<Usuario> consultarUsuarios() throws PersistenciaException {
        try{
            List<Usuario> usuarios = new ArrayList<>();
            MongoCollection<Document> collection = 
                baseDatos.getCollection("usuarios");
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                Usuario usuario = new Usuario();
                usuario.setId(documento.getObjectId("_id"));
                usuario.setNombreCompleto(
                    documento.getString("nombreCompleto"));
                usuario.setCorreo(documento.getString("correo"));
                usuario.setContrasenia(
                    documento.getString("contrasenia"));
                usuario.setTelefono(documento.getString("telefono"));
                usuario.setAvatar(documento.getString("avatar"));
                usuario.setCiudad(documento.getString("ciudad"));
                usuario.setFechaNacimiento(
                    documento.getDate("fechaNacimiento"));
                usuario.setGenero(documento.getString("genero"));
                usuario.setMunicipio(documento.get("municipio", 
                    Municipio.class));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch(MongoException me){
            throw new PersistenciaException(
                    "Error al consultar los usuarios" + me.getMessage());
        }
    }
}