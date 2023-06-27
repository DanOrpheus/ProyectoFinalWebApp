/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Anclado;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public interface IAncladosDAO {
    /**
     * Método que agrega un objeto de tipo Anclado
     * @param anclado Objeto a agregar
     * @return El objeto Anclado agregado
     */
    public Anclado agregar(Anclado anclado);
    /**
     * Método que modifica un objeto de tipo Anclado
     * @param anclado Objeto a modificar
     * @return El objeto Anclado modificado
     */
    public Anclado modificar(Anclado anclado);
    /**
     * Método que elimina un objeto de tipo Anclado
     * @param anclado Objeto a eliminar
     * @return El objeto Anclado eliminado
     */
    public Anclado eliminar(Anclado anclado);
    /**
     * Método que crea una lista con todos los objetos Anclado creados
     * @return La lista de objetos Anclado
     */
    public List<Anclado> consultarPosts();
}