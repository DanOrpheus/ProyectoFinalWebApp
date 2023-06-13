/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.Persistencia;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class ConexionMongoDB {
    // ATRIBUTOS
    private final String nombreBD = "redSocialBD";
    private MongoDatabase baseDatos;
    private static ConexionMongoDB instancia;
    
    // CONSTRUCTORES
    private ConexionMongoDB(){
    }
    
    // MÉTODOS
    /**
     * Método Singleton que crea una instancia de la clase
     * @return Un objeto ConexionMongoDB
     */
    public static ConexionMongoDB instance(){
        if(instancia == null){
            instancia = new ConexionMongoDB();
        }
        return instancia;
    }
    /**
     * Método que nos permite obtener una base de datos en MongoDB
     * @return Una conexión a una base de datos en MongoDB
     */
    public MongoDatabase getBaseDatos(){
        if(baseDatos == null){
            // Codec Registry
            CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder()
                .automatic(true).build()));
            // Mongo Client
            MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry).build();
            MongoClient mClient = MongoClients.create(settings);
            // Mongo Database
            baseDatos = mClient.getDatabase(nombreBD);
        }
        return baseDatos;
    }
}