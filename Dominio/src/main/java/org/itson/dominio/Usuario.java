/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Victoria, Daniel y Nadia
 * @version IDE 17
 */
public class Usuario {
    // ATRIBUTOS
    private ObjectId id;
    private String nombreCompleto;
    private String correo;
    private String contrasenia;
    private String telefono;
    private String avatar;
    private String ciudad;
    private String fechaNacimiento;
    private String genero;
    private Municipio municipio;
    
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Usuario() {
    }
    /**
     * Constructor para cuando se deba iniciar sesión
     * @param contrasenia
     * @param avatar 
     */
    public Usuario(String contrasenia, String avatar) {
        this.contrasenia = contrasenia;
        this.avatar = avatar;
    }
    /**
     * Constructor para registrarse como usuario nuevo
     * @param nombreCompleto
     * @param correo
     * @param contrasenia
     * @param avatar
     * @param ciudad
     * @param fechaNacimiento 
     */
    public Usuario(String nombreCompleto, String correo, String contrasenia, String avatar, String ciudad, String fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando el id
     * @param nombreCompleto Nombre completo del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     * @param telefono Teléfono del usuario
     * @param avatar Avatar que desea utilizar el usuario
     * @param ciudad Ciudad actual
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param genero Género del usuario
     * @param municipio Municipio al que pertenece el usuario
     */
    public Usuario(String nombreCompleto, String correo, String contrasenia, 
            String telefono, String avatar, String ciudad, 
            String fechaNacimiento, String genero, Municipio municipio) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;    
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Identificador de la clase
     * @param nombreCompleto Nombre completo del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     * @param telefono Teléfono del usuario
     * @param avatar Avatar que desea utilizar el usuario
     * @param ciudad Ciudad donde vive el usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param genero Género del usuario
     * @param municipio Municipio al que pertenece el usuario
     */
    public Usuario(ObjectId id, String nombreCompleto, String correo, 
            String contrasenia, String telefono, String avatar, 
            String ciudad, String fechaNacimiento, 
            String genero, Municipio municipio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.municipio = municipio;
    }
    
    // GETTERS Y SETTERS
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Municipio getMunicipio() {
        return municipio;
    }
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto 
                + ", correo=" + correo + ", contrasenia=" + contrasenia + 
                ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" 
                + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" 
                + genero + ", municipio=" + municipio + '}';
    }
}