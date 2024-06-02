package Controladores;

import Modelo.Libro;
import Repositorio.AccesoBasedeDatosLibro;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ControladorLibroTest {

    @Mock
    private AccesoBasedeDatosLibro accesoBasedeDatosLibro;

    @InjectMocks
    private ControladorLibro controladorLibro;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controladorLibro = new ControladorLibro(accesoBasedeDatosLibro);  // Asegúrate de crear la instancia
    }
        //Test1
    @Test
    public void guardarLibro() {
        Libro libroEntrada = new Libro(1, "El Principito", "Ficcion", "Antoine de Saint-Exupéry","6 de abril de 1943");
        Libro libroEsperado = new Libro(1, "El Principito", "Ficcion", "Antoine de Saint-Exupéry","6 de abril de 1943");

        ControladorLibro controladorLibro = new ControladorLibro(accesoBasedeDatosLibro);
        Mockito.when(accesoBasedeDatosLibro.guardar(libroEntrada)).thenReturn(null);
        Mockito.when(accesoBasedeDatosLibro.obtener(libroEntrada.getId())).thenReturn(libroEsperado);

        Libro libroResultado = controladorLibro.guardarProducto(libroEntrada);



        Assertions.assertEquals(libroResultado, libroEsperado);

    }
    //Test2
    @Test
    public void testBuscarLibroPorAutor() {
        Libro libro1 = new Libro(1, "100 años de soledad", "Realismo magico", "Gabriel Garcia Marquez","mayo de 1967");
        Libro libro2 = new Libro(2, "Cronica de una muerte anunciada", "Thriller", "Gabriel Garcia Marquez","1981");
        List<Libro> libros = Arrays.asList(libro1, libro2);
        Mockito.when(accesoBasedeDatosLibro.buscarPorAutor("Gabriel Garcia Marquez")).thenReturn(libros);

        List<Libro> resultado = controladorLibro.buscarLibroPorAutor("Gabriel Garcia Marquez");


        Assertions.assertEquals(2, resultado.size());
        Assertions.assertTrue(resultado.contains(libro1));
        Assertions.assertTrue(resultado.contains(libro2));
    }
    //Test3
    @Test
    public void testBuscarLibroPorGenero() {
        Libro libro1 = new Libro(1, "100 años de soledad", "Realismo magico", "Gabriel Garcia Marquez","mayo de 1967");
        Libro libro2 = new Libro(2, "Cronica de una muerte anunciada", "Thriller", "Gabriel Garcia Marquez","1981");
        List<Libro> libros = Arrays.asList(libro1, libro2);
        Mockito.when(accesoBasedeDatosLibro.buscarPorGenero("Thriller")).thenReturn(libros);

        List<Libro> resultado = controladorLibro.buscarLibroPorGenero("Thriller");


        Assertions.assertEquals(2, resultado.size());
        Assertions.assertTrue(resultado.contains(libro1));
        Assertions.assertTrue(resultado.contains(libro2));
    }
    //Test4
    @Test
    public void testBuscarLibroPorTitulo() {
        Libro libro1 = new Libro(1, "100 anos de soledad", "Realismo magico", "Gabriel Garcia Marquez","mayo de 1967");
        Libro libro2 = new Libro(2, "Cronica de una muerte anunciada", "Thriller", "Gabriel Garcia Marquez","1981");
        List<Libro> libros = Arrays.asList(libro1, libro2);
        Mockito.when(accesoBasedeDatosLibro.buscarPorTitulo("100 anos de soledad")).thenReturn(libros);

        List<Libro> resultado = controladorLibro.buscarLibroPorTitulo("100 anos de soledad");


        Assertions.assertEquals(1, resultado.size());
        Assertions.assertTrue(resultado.contains(libro1));
        Assertions.assertTrue(resultado.contains(libro2));
    }
    //Test 9
    @Test
    public void testEliminarLibro() {
        int libroId = 1;

        controladorLibro.eliminarLibro(libroId);
    }
    //Test 13
    @Test
    public void testActualizarLibro() {
        Libro libro = new Libro(1, "Effective Java","Educativo", "Joshua Bloch", "2004");
        Mockito.when(accesoBasedeDatosLibro.actualizar(libro)).thenReturn(libro);

        Libro resultado = controladorLibro.guardarProducto(libro);


        Assertions.assertEquals(libro, resultado);
    }
    //Test 14
    @Test
    public void testEliminarLibroQueNoExiste() {
        int libroId = 999;
        Mockito.when(accesoBasedeDatosLibro.obtener(libroId)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorLibro.eliminarLibro(libroId);
        });

        String expectedMessage = "Libro no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }
    //Test 15
    @Test
    public void testBuscarLibroQueNoExiste() {
        int libroId = 999;
        Mockito.when(accesoBasedeDatosLibro.obtener(libroId)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorLibro.buscarLibroPorId(libroId);
        });

        String expectedMessage = "Libro no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    //Test16
    @Test
    public void testActualizarLibroQueNoExiste() {
        Libro libro = new Libro(999, "Libro inexistente", "?","Autor desconocido", "Ficción");
        Mockito.when(accesoBasedeDatosLibro.obtener(libro.getId())).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorLibro.actualizarLibro(libro);
        });

        String expectedMessage = "Libro no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    //Test 20
    @Test
    public void testBuscarLibroPorAutorSinResultados() {
        Mockito.when(accesoBasedeDatosLibro.buscarPorAutor("Autor Desconocido")).thenReturn(Collections.emptyList());

        List<Libro> resultado = controladorLibro.buscarLibroPorAutor("Autor Desconocido");
        Assertions.assertTrue(resultado.isEmpty());
    }
}

