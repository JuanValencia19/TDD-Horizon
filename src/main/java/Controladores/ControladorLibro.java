package Controladores;

import Modelo.Libro;
import Repositorio.AccesoBasedeDatosLibro;

import java.util.List;

public class ControladorLibro {
    private AccesoBasedeDatosLibro accesoBasedeDatosLibro;

    public ControladorLibro(AccesoBasedeDatosLibro accesoBasedeDatosLibro) {
        this.accesoBasedeDatosLibro = accesoBasedeDatosLibro;
    }


    public Libro guardarProducto(Libro libro) {
        accesoBasedeDatosLibro.guardar(libro);
        return accesoBasedeDatosLibro.obtener(libro.getId());
    }

    public Libro actualizarLibro(Libro libro) {
        Libro libroExistente = accesoBasedeDatosLibro.obtener(libro.getId());
        if (libroExistente == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }
        return accesoBasedeDatosLibro.actualizar(libro);
    }

    // Método para buscar libros por título
    public List<Libro> buscarLibroPorTitulo(String titulo) {
        return accesoBasedeDatosLibro.buscarPorTitulo(titulo);
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        return accesoBasedeDatosLibro.buscarPorAutor(autor);
    }

    public List<Libro> buscarLibroPorGenero(String genero) {
        return accesoBasedeDatosLibro.buscarPorGenero(genero);
    }

    public Libro buscarLibroPorId(int id) {
        Libro libro = accesoBasedeDatosLibro.obtener(id);
        if (libro == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }
        return libro;
    }

    public void eliminarLibro(int id) {
        Libro libro = accesoBasedeDatosLibro.obtener(id);
        if (libro == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }
        accesoBasedeDatosLibro.eliminar(id);
    }
}


