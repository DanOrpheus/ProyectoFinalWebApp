/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Estado;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IEstadosDAO {
    /**
     * Método que agrega un objeto de tipo Estado
     * @param estado Objeto a agregar
     * @return El objeto Estado agregado
     */
    public Estado agregar(Estado estado);
    /**
     * Método que elimina un objeto de tipo Estado
     * @param estado Objeto a eliminar
     * @return El objeto Estado eliminado
     */
    public Estado eliminar(Estado estado);
    /**
     * Método que crea una lista con todos los objetos Estado creados
     * @return La lista de objetos Estado
     */
    public List<Estado> consultarEstados();
}