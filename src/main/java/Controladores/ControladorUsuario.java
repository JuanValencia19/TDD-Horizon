package Controladores;

import Modelo.Libro;
import Modelo.Usuario;
import Repositorio.AccesoBasedeDatosUsuario;

public class ControladorUsuario {
    private AccesoBasedeDatosUsuario accesoBasedeDatosUsuario;

    public ControladorUsuario(AccesoBasedeDatosUsuario accesoBasedeDatosUsuario) {
        this.accesoBasedeDatosUsuario = accesoBasedeDatosUsuario;
    }
    public Usuario guardarUsuario(Usuario usuario){
        accesoBasedeDatosUsuario.guardar(usuario);
        return accesoBasedeDatosUsuario.obtener(usuario.getId());
    }
    public void eliminarUsuario(int id) {
        accesoBasedeDatosUsuario.eliminar(id);
    }
    public void agregarLibroALaBibliotecaPrivada(int usuarioId, Libro libro) {
        Usuario usuario = accesoBasedeDatosUsuario.obtener(usuarioId);
        if (usuario != null) {
            usuario.agregarLibroALaBiblioteca(libro);
            accesoBasedeDatosUsuario.actualizar(usuario);
        }
    }

    public void eliminarLibroDeLaBibliotecaPrivada(int usuarioId, Libro libro) {
        Usuario usuario = accesoBasedeDatosUsuario.obtener(usuarioId);
        if (usuario != null) {
            usuario.eliminarLibroDeLaBiblioteca(libro);
            accesoBasedeDatosUsuario.actualizar(usuario);
        }
    }
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioExistente = accesoBasedeDatosUsuario.obtener(usuario.getId());
        if (usuarioExistente == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        return accesoBasedeDatosUsuario.actualizar(usuario);
    }
    public Usuario obtenerUsuario(int id) {
        Usuario usuario = accesoBasedeDatosUsuario.obtener(id);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        return usuario;
    }
}
