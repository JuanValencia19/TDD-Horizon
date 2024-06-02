package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    Integer id;
    String nombre;
    String correo;
    Integer celular;
    List<Libro> biblioteca_privada;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", celular=" + celular +
                ", biblioteca_privada=" + biblioteca_privada +
                '}';
    }


    public Usuario(Integer id, String nombre, String correo, Integer celular) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }



    public Usuario(String nombre, String correo, Integer celular, List<String> biblioteca_privada) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.biblioteca_privada = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
    public List<Libro> getBiblioteca_privada() {
        return biblioteca_privada;
    }

    public void setBiblioteca_privada(List<Libro> biblioteca_privada) {
        this.biblioteca_privada = biblioteca_privada;
    }

    public void agregarLibroALaBiblioteca(Libro libro) {
        biblioteca_privada.add(libro);
    }

    public void eliminarLibroDeLaBiblioteca(Libro libro) {
        biblioteca_privada.remove(libro);
    }
}

