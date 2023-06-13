/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Comun;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IComunesDAO {
    /**
     * Método que agrega un objeto de tipo Comun
     * @param comun Objeto a agregar
     * @return El objeto Comun agregado
     */
    public Comun agregar(Comun comun);
    /**
     * Método que elimina un objeto de tipo Comun
     * @param comun Objeto a eliminar
     * @return El objeto Comun eliminado
     */
    public Comun eliminar(Comun comun);
    /**
     * Método que crea una lista con todos los objetos Comun creados
     * @return La lista de objetos Comun
     */
    public List<Comun> consultarComunes();
}