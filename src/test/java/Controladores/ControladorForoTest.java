package Controladores;
import Modelo.Foro;
import Repositorio.AccesoBasedeDatosForo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class ControladorForoTest {
    @Mock
    private AccesoBasedeDatosForo accesoBasedeDatosForo;

    @InjectMocks
    private ControladorForo controladorForo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controladorForo = new ControladorForo(accesoBasedeDatosForo);
    }
    //Test6
    @Test
    public void guardarForo() {
        Foro foroEntrada = new Foro(1,"Foro del principiot","Me gusta el libro");
        Foro foroEsperado = new Foro(1,"Foro del principiot","Me gusta el libro");
        ControladorForo controladorForo = new ControladorForo(accesoBasedeDatosForo);
        Mockito.when(accesoBasedeDatosForo.guardar(foroEntrada)).thenReturn(null);
        Mockito.when(accesoBasedeDatosForo.obtener(foroEntrada.getId())).thenReturn(foroEsperado);

        Foro foroResultado = controladorForo.guardarForo(foroEntrada);



        Assertions.assertEquals(foroResultado, foroEsperado);
    }
    //Test 7
    @Test
    public void testEliminarForo() {
        int foroId = 1;

        controladorForo.eliminarForo(foroId);
    }
    //Test 8
    @Test
    public void testBuscarForoporNombre() {
        Foro foro1 = new Foro(1, "Foro Principito", "Lorem ipsum");
        Foro foro2 = new Foro(2, "Foro la chica del tren", "Lorem ipsum");
        List<Foro> foros = Arrays.asList(foro1, foro2);
        Mockito.when(accesoBasedeDatosForo.buscarPorNombre("Foro principito")).thenReturn(foros);

        List<Foro> resultado = controladorForo.buscarForoPorNombre("Foro principito");


        Assertions.assertEquals(1, resultado.size());
        Assertions.assertTrue(resultado.contains(foro1));
        Assertions.assertTrue(resultado.contains(foro2));
    }
}
