/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.negocio.implementaciones;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Comentario;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.interfaces.IComentariosBO;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.FachadaPersistencia;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class ComentariosBO implements IComentariosBO {
    // ATRIBUTOS
    FachadaPersistencia fachada;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa el atributo de fachada 
     */
    public ComentariosBO() {
        this.fachada = new FachadaPersistencia();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un comentario a la base de datos con validaciones
     * @param com
     * @return
     * @throws NegocioException 
     */
    @Override
    public Comentario agregar(Comentario com) throws NegocioException {
        try {
            Comentario nCom = this.fachada.guardarComentario(com);
            ObjectId id = new ObjectId();
            nCom.setId(id);
            return nCom;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que eliminar un comentario de la base de datos con validaciones
     * @param com
     * @return
     * @throws NegocioException 
     */
    @Override
    public Comentario eliminar(Comentario com) throws NegocioException {
        try {
            Comentario eCom = this.fachada.eliminarComentario(com);
            return eCom;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consulta los comentarios de la base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Comentario> consultarComentarios() throws NegocioException {
        try {
            List<Comentario> coms = this.fachada.consultarComentarios();
            return coms;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
}