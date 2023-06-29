/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.negocio.implementaciones;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Anclado;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.interfaces.IAncladosBO;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.FachadaPersistencia;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class AncladosBO implements IAncladosBO {
    // ATRIBUTOS
    FachadaPersistencia fachada;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa el atributo de fachada
     */
    public AncladosBO() {
        this.fachada = new FachadaPersistencia();
    }

    // MÉTODOS
    /**
     * Método que agrega un post anclado a la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */    
    @Override
    public Anclado agregar(Anclado anclado) throws NegocioException {
        try {
            Anclado nAnclado = this.fachada.guardarAnclados(anclado);
            ObjectId id = new ObjectId();
            nAnclado.setId(id);
            return nAnclado;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que modifica un post anclado de la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */
    @Override
    public Anclado modificar(Anclado anclado) throws NegocioException {
        try {
            Anclado mAnclado = this.fachada.modificarAnclado(anclado);
            return mAnclado;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que elimina un post anclado de la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */
    @Override
    public Anclado eliminar(Anclado anclado) throws NegocioException {
        try {
            Anclado eAnclado = this.fachada.eliminarAnclado(anclado);
            return eAnclado;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consultar los posts anclados de la 
     * base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Anclado> consultarAnclados() throws NegocioException {
        try {
            List<Anclado> anclados = this.fachada.consultarAnclados();
            return anclados;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
}