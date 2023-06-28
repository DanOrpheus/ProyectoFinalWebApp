/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Admin;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IAdminsDAO {
    /**
     * Método que agrega un objeto de tipo Admin
     * @param admin Objeto a agregar
     * @return El objeto Admin agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Admin agregar(Admin admin) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Admin
     * @param admin Objeto a eliminar
     * @return El objeto Admin eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Admin eliminar(Admin admin) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Admin creados
     * @return La lista de objetos Admin
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Admin> consultarAdmins() throws PersistenciaException;
}