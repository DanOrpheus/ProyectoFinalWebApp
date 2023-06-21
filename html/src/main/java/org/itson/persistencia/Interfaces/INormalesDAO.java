/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Normal;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface INormalesDAO {
    /**
     * Método que agrega un objeto de tipo Normal
     * @param normal Objeto a agregar
     * @return El objeto Normal agregado
     */
    public Normal agregar(Normal normal);
    /**
     * Método que elimina un objeto de tipo Normal
     * @param normal Objeto a eliminar
     * @return El objeto Normal eliminado
     */
    public Normal eliminar(Normal normal);
    /**
     * Método que crea una lista con todos los objetos Normal creados
     * @return La lista de objetos Normal
     */
    public List<Normal> consultarNormales();
}