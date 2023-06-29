/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.metweb.negocio.implementaciones;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Admin;
import org.itson.metweb.Excepciones.NegocioException;
import org.itson.metweb.negocio.interfaces.IAdminsBO;
import org.itson.persistencia.Excepciones.PersistenciaException;
import org.itson.persistencia.FachadaPersistencia;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class AdminsBO implements IAdminsBO {
    // ATRIBUTOS
    FachadaPersistencia fachada;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa el atributo de fachada
     */
    public AdminsBO() {
        this.fachada = new FachadaPersistencia();
    }
    
    // MÉTODOS
    /**
     * Método que agrega un admin a la base con validaciones
     * @param admin
     * @return
     * @throws NegocioException 
     */
    @Override
    public Admin agregar(Admin admin) throws NegocioException {
        try {
            Admin nAdmin = this.fachada.guardarAdmin(admin);
            ObjectId id = new ObjectId();
            nAdmin.setId(id);
            return nAdmin;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que elimina un admin de la base con validaciones
     * @param admin
     * @return
     * @throws NegocioException 
     */
    @Override
    public Admin eliminar(Admin admin) throws NegocioException {
        try {
            Admin eAdmin = this.fachada.eliminarAdmin(admin);
            return eAdmin;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
    /**
     * Método que consulta los admins de la base con validaciones
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Admin> consultarAdmins() throws NegocioException {
        try {
            List<Admin> admins = this.fachada.consultarAdmins();
            return admins;
        } catch(PersistenciaException ex){
            throw new NegocioException(ex);
        }
    }
}