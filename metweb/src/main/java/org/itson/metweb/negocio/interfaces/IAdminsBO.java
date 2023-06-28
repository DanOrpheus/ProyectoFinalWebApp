/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.metweb.negocio.interfaces;

import java.util.List;
import org.itson.dominio.Admin;
import org.itson.metweb.Excepciones.NegocioException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IAdminsBO {
    // MÉTODOS
    /**
     * Método que agrega un admin a la base con validaciones
     * @param admin
     * @return
     * @throws NegocioException 
     */
    Admin agregar(Admin admin) throws NegocioException;
    /**
     * Método que elimina un admin de la base con validaciones
     * @param admin
     * @return
     * @throws NegocioException 
     */
    Admin eliminar(Admin admin) throws NegocioException;
    /**
     * Método que consulta los admins de la base con validaciones
     * @return
     * @throws NegocioException 
     */
    List<Admin> consultarAdmins() throws NegocioException;
}
