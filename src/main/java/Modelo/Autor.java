package Modelo;


import java.util.Date;
import java.util.List;

public class Autor {
    String nombre;
    String fecha_nacimiento;
    String descripcion;
    List<String> lista_libros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getLista_libros() {
        return lista_libros;
    }

    public void setLista_libros(List<String> lista_libros) {
        this.lista_libros = lista_libros;
    }

    public Autor(String nombre, String fecha_nacimiento, String descripcion, List<String> lista_libros) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.descripcion = descripcion;
        this.lista_libros = lista_libros;
    }
}
