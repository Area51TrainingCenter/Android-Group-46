package com.area51.clasemvp.net.mapper;

import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.ui.model.Usuario;

public final class UsuarioMapper {
    public static Usuario convert(UsuarioEntidad entidad) {
        Usuario usuario = null;
        if (entidad != null) {
            usuario = new Usuario();
            usuario.setId(entidad.getId());
            usuario.setNombre(entidad.getNombre());
            usuario.setApellido(entidad.getApellido());
        }
        return usuario;
    }

    public static UsuarioEntidad convert(Usuario obj) {
        UsuarioEntidad entidad = null;
        if (obj != null) {
            entidad = new UsuarioEntidad();
            entidad.setId(obj.getId());
            entidad.setNombre(obj.getNombre());
            entidad.setApellido(obj.getApellido());
            entidad.setContrasenia(obj.getContrasena());
        }
        return entidad;
    }
}
