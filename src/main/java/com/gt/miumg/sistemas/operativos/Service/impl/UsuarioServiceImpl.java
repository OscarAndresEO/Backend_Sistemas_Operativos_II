package com.gt.miumg.sistemas.operativos.Service.impl;

import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Entity.UsuarioRol;
import com.gt.miumg.sistemas.operativos.Repository.RolRepository;
import com.gt.miumg.sistemas.operativos.Repository.UsuarioRepository;
import com.gt.miumg.sistemas.operativos.Service.UsuarioService;
import com.gt.miumg.sistemas.operativos.excepciones.UsuarioFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuariosRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuariosRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
