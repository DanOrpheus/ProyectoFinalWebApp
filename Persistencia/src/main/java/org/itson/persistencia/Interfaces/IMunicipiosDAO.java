/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Municipio;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IMunicipiosDAO {
    /**
     * Método que agrega un objeto de tipo Municipio
     * @param municipio Objeto a agregar
     * @return El objeto Municipio agregado
     */
    public Municipio agregar(Municipio municipio);
    /**
     * Método que elimina un objeto de tipo Municipio
     * @param municipio Objeto a eliminar
     * @return El objeto Municipio eliminado
     */
    public Municipio eliminar(Municipio municipio);
    /**
     * Método que crea una lista con todos los objetos Municipio creados
     * @return La lista de objetos Municipio
     */
    public List<Municipio> consultarMunicipios();
}