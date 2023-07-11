/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Post {
    // ATRIBUTOS
    private ObjectId id;
    private String fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private String fechaHoraEdicion;
    private Usuario autor;
    private List<Comentario> com;
    
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Post() {
    }
    /**
     * Constructor para agregar publicaciones a la base de datos
     * @param titulo
     * @param contenido 
     */
    public Post(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
    /**
     * Constructor para agregar publicaciones a la base de datos
     * @param fechaHoraCreacion Fecha y hora de creación de la publicación
     * @param titulo Titulo de la publicación
     * @param contenido Contenido de la publicación
     */
    public Post(String titulo, String contenido, String fechaHoraCreacion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraCreacion = fechaHoraCreacion;
    }
    /**
     * Constructor que agrega publicaciones a la base de datos con comentarios
     * @param fechaHoraCreacion Fecha y hora de creación de la publicación
     * @param titulo Titulo de la publicación
     * @param contenido Contenido de la publicación
     * @param com Comentarios de la publicación
     */
    public Post(String fechaHoraCreacion, String titulo, String contenido, 
            List<Comentario> com) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.com = com;
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando el id
     * @param fechaHoraCreacion Fecha y hora de creación de la publicación
     * @param titulo Titulo de la publicación
     * @param contenido Contenido de la publicación
     * @param fechaHoraEdicion Fecha y hora de edición de la publicación
     */
    public Post(String fechaHoraCreacion, String titulo, String contenido, 
            String fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Identificador de la clase
     * @param fechaHoraCreacion Fecha y hora de creación de la publicación
     * @param titulo Titulo de la publicación
     * @param contenido Contenido de la publicación
     * @param fechaHoraEdicion Fecha y hora de edición de la publicación
     * @param com Comentarios de la publicación
     */
    public Post(ObjectId id, String fechaHoraCreacion, String titulo, String contenido, String fechaHoraEdicion, List<Comentario> com) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
        this.com = com;
    }

    // GETTERS Y SETTERS
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }
    public void setFechaHoraCreacion(String fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }
    public void setFechaHoraEdicion(String fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }
    public List<Comentario> getCom() {
        return com;
    }
    public void setCom(List<Comentario> com) {
        this.com = com;
    }
    public Usuario getAutor() {
        return autor;
    }
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    
    // MËTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }
    /**
     * Método equals
     * @param obj Objeto a comparar
     * @return True si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + 
                fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + 
                contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + 
                ", autor=" + autor + ", com=" + com + '}';
    }   
}