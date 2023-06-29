/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.negocio.implementaciones;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Usuario;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.interfaces.IUsuariosBO;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.FachadaPersistencia;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class UsuariosBO implements IUsuariosBO {
    // ATRIBUTOS
    FachadaPersistencia fachada;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa el atributo de fachada 
     */
    public UsuariosBO() {
        this.fachada = new FachadaPersistencia();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un usuario a la base con validaciones
     * @param usuario
     * @return
     * @throws NegocioException 
     */
    @Override
    public Usuario agregar(Usuario usuario) throws NegocioException {
        try {
            Usuario nUsuario = this.fachada.guardarUsuario(usuario);
            ObjectId id = new ObjectId();
            nUsuario.setId(id);
            return nUsuario;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que elimina un usuario de la base con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public Usuario eliminar(Usuario usuario) throws NegocioException {
        try {
            Usuario eUsuario = this.fachada.eliminarUsuario(usuario);
            return eUsuario;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consulta los usuarios de la base con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Usuario> consultarUsuarios() throws NegocioException {
        try {
            List<Usuario> usuarios = this.fachada.consultarUsuarios();
            return usuarios;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
}