package com.gt.miumg.sistemas.operativos.Service;

import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Entity.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
