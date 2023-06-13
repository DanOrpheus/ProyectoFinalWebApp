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
import org.itson.dominio.Comun;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IComunesDAO;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 18
 */
public class ComunesDAO implements IComunesDAO {
    //Atributos
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
     * Método que agrega un objeto de tipo Post
     * @param post Objeto a agregar
     * @return El objeto Post agregado
     */
    @Override
    public Comun agregar(Comun comun) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comun eliminar(Comun comun) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Comun> consultarComunes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
