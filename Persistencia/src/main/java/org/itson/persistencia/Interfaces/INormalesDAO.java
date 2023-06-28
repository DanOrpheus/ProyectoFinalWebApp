/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Normal;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface INormalesDAO {
    /**
     * Método que agrega un objeto de tipo Normal
     * @param normal Objeto a agregar
     * @return El objeto Normal agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Normal agregar(Normal normal) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Normal
     * @param normal Objeto a eliminar
     * @return El objeto Normal eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Normal eliminar(Normal normal) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Normal creados
     * @return La lista de objetos Normal
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Normal> consultarNormales() throws PersistenciaException;
}