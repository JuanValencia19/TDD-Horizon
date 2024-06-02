package Modelo;

public class Libro {
    private int id;
    private String nombre;
    private String genero;
    private String autor;
    private String fechaDePublicacion;



    public Libro(int id, String nombre, String genero, String autor, String fechaDePublicacion) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.fechaDePublicacion = fechaDePublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaDePublicacion='" + fechaDePublicacion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }
}
