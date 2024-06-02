package Controladores;

import Modelo.Libro;
import Modelo.Usuario;
import Repositorio.AccesoBasedeDatosUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControladorUsuarioTest {
    @Mock
    private AccesoBasedeDatosUsuario accesoBasedeDatosUsuario;
    @InjectMocks
    private ControladorUsuario controladorUsuario;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controladorUsuario = new ControladorUsuario(accesoBasedeDatosUsuario);
    }

    //Test5
    @Test
    public void guardarUsuario() {
        Usuario usuarioNuevo = new Usuario(1, "Juan Jose", "juan.valencia10@utp.edu.co", 123456789);
        Usuario usuarioVerificado = new Usuario(1, "Juan Jose", "juan.valencia10@utp.edu.co", 123456789);

        ControladorUsuario controladorUsuario = new ControladorUsuario(accesoBasedeDatosUsuario);
        Mockito.when(accesoBasedeDatosUsuario.guardar(usuarioNuevo)).thenReturn(null);
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuarioNuevo.getId())).thenReturn(usuarioVerificado);

        Usuario usuarioResultado = controladorUsuario.guardarUsuario(usuarioNuevo);


        Assertions.assertEquals(usuarioResultado, usuarioVerificado);

    }

    //Test 10
    @Test
    public void testEliminarUsuario() {
        int usuarioId = 1;

        controladorUsuario.eliminarUsuario(usuarioId);
    }
    //Test 11
    @Test
    public void testAgregarLibroALaBibliotecaPrivada() {
        Usuario usuario = new Usuario(1, "Juan Pérez","juan@gmail.com",12345);
        Libro libro = new Libro(1, "Effective Java", "Educativo","Joshua Bloch", "2004");
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuario.getId())).thenReturn(usuario);

        controladorUsuario.agregarLibroALaBibliotecaPrivada(usuario.getId(), libro);


        Assertions.assertTrue(usuario.getBiblioteca_privada().contains(libro));
    }
    //Test 12
    @Test
    public void testEliminarLibroDeLaBibliotecaPrivada() {
        Usuario usuario = new Usuario(1, "Juan Pérez","juan@gmail.com",12345);
        Libro libro = new Libro(1, "Effective Java", "Educativo","Joshua Bloch", "2004");
        usuario.agregarLibroALaBiblioteca(libro);
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuario.getId())).thenReturn(usuario);

        controladorUsuario.eliminarLibroDeLaBibliotecaPrivada(usuario.getId(), libro);

        Assertions.assertFalse(usuario.getBiblioteca_privada().contains(libro));
    }
    //Test 17
    @Test
    public void testActualizarUsuarioQueNoExiste() {
        Usuario usuario = new Usuario(999, "Desconocido", "vacio@correo.com", 123456789);
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuario.getId())).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorUsuario.actualizarUsuario(usuario);
        });

        String expectedMessage = "Usuario no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    // Test 18
    @Test
    public void testObtenerUsuarioQueNoExiste() {
        int usuarioId = 999;
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuarioId)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorUsuario.obtenerUsuario(usuarioId);
        });

        String expectedMessage = "Usuario no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }
    //Test 19
    @Test
    public void testEliminarUsuarioQueNoExiste() {
        int usuarioId = 999;
        Mockito.when(accesoBasedeDatosUsuario.obtener(usuarioId)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controladorUsuario.eliminarUsuario(usuarioId);
        });

        String expectedMessage = "Usuario no encontrado";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
