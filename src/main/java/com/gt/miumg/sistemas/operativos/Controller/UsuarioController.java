package com.gt.miumg.sistemas.operativos.Controller;

import com.gt.miumg.sistemas.operativos.Entity.Rol;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Entity.UsuarioRol;
import com.gt.miumg.sistemas.operativos.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws  Exception{
        usuario.setPerfil("default.png");
        
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        
        Set<UsuarioRol> usuariosRoles = new HashSet<>();
        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuariosRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario, usuariosRoles);
    }

    @GetMapping("/{username}")
    @Operation(summary = "prueba unitaria :v", description = "holi que hace perro, durmiendo o khe hace")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{UsuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId")Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
}
