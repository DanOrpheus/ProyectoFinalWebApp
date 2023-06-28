/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Comun;
import org.itson.persistencia.Excepciones.PersistenciaException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IComunesDAO {
    /**
     * Método que agrega un objeto de tipo Comun
     * @param comun Objeto a agregar
     * @return El objeto Comun agregado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Comun agregar(Comun comun) throws PersistenciaException;
    /**
     * Método que modifica un objeto de tipo Comun
     * @param comun Objeto a modificar
     * @return El objeto Comun modificado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Comun modificar(Comun comun) throws PersistenciaException;
    /**
     * Método que elimina un objeto de tipo Comun
     * @param comun Objeto a eliminar
     * @return El objeto Comun eliminado
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public Comun eliminar(Comun comun) throws PersistenciaException;
    /**
     * Método que crea una lista con todos los objetos Comun creados
     * @return La lista de objetos Comun
     * @throws org.itson.persistencia.Excepciones.PersistenciaException
     */
    public List<Comun> consultarComunes() throws PersistenciaException;
}