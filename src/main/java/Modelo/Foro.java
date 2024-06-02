package Modelo;

public class Foro {
    Integer id;
    String nombre;
    String descripcion;

    public Foro(Integer id, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
