/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.metweb.negocio.interfaces;

import java.util.List;
import org.itson.dominio.Anclado;
import org.itson.metweb.Excepciones.NegocioException;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IAncladosBO {
    // MÉTODOS
    /**
     * Método que agrega un post anclado a la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */
    Anclado agregar(Anclado anclado) throws NegocioException;
    /**
     * Método que modifica un post anclado de la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */
    Anclado modificar(Anclado anclado) throws NegocioException;
    /**
     * Método que elimina un post anclado de la base de datos con validaciones
     * @param anclado
     * @return
     * @throws NegocioException 
     */
    Anclado eliminar(Anclado anclado) throws NegocioException;
    /**
     * Método que consultar los posts anclados de la 
     * base de datos con validaciones
     * @return
     * @throws NegocioException 
     */
    List<Anclado> consultarAnclados() throws NegocioException;
}