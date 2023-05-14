package com.gt.miumg.sistemas.operativos;

import com.gt.miumg.sistemas.operativos.Entity.Rol;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Entity.UsuarioRol;
import com.gt.miumg.sistemas.operativos.Service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MicroservicioDocumentoApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioDocumentoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setNombre("administrador");
//        usuario.setApellido("admin");
//        usuario.setUsername("istrador");
//        usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
//        usuario.setEmail("administrador@gmail.com");
//        usuario.setTelefono("123456778");
//        usuario.setPerfil("foto.png");
//
//        Rol rol = new Rol();
//        rol.setRolId(1L);
//        rol.setNombre("ADMIN");
//
//        Set<UsuarioRol> usuarioRoles = new HashSet<>();
//        UsuarioRol usuarioRol = new UsuarioRol();
//        usuarioRol.setRol(rol);
//        usuarioRol.setUsuario(usuario);
//        usuarioRoles.add(usuarioRol);
//
//        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
//        System.out.println(usuarioGuardado.getUsername());
    }

}
