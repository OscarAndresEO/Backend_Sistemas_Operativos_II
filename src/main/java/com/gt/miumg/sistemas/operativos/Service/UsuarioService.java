/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Service;

/**
 *
 * @author Oscar
 */import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario SaveUsuario(Usuario usuario){
        //Usuario user = usuarioRepository.save(usuario);
        //return user;
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.listarActivos();
    }

   public void eliminar(int id_usuario){
        usuarioRepository.eliminarUsuario(id_usuario);
   }

   public Usuario findById(int id_usuario){
        return usuarioRepository.usuarioActivoPorId(id_usuario);
   }
/*
   public Optional<Usuario> login(UsuarioDTO usuario){
        return usuarioRepository.login(usuario.getUsername(), usuario.getClave());
   }
*/
}
