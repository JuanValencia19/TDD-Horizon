package Controladores;

import Modelo.Foro;
import Modelo.Libro;
import Repositorio.AccesoBasedeDatosForo;

import java.util.List;

public class ControladorForo {
    private AccesoBasedeDatosForo accesoBasedeDatosForo;

    public ControladorForo(AccesoBasedeDatosForo accesoBasedeDatosForo) {
        this.accesoBasedeDatosForo = accesoBasedeDatosForo;
    }
    public Foro guardarForo(Foro foro){
        accesoBasedeDatosForo.guardar(foro);
        return accesoBasedeDatosForo.obtener(foro.getId());
    }
    public void eliminarForo(int id) {
        accesoBasedeDatosForo.eliminar(id);
    }
    public List<Foro> buscarForoPorNombre(String nombre) {
        return accesoBasedeDatosForo.buscarPorNombre(nombre);
    }
}
