/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Controller;

/**
 *
 * @author Oscar
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;
import com.gt.miumg.sistemas.operativos.Service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.SaveUsuario(usuario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> list = usuarioService.findAll();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/eliminar/{id_usuario}")
    public void eliminar(@PathVariable int id_usuario){
        usuarioService.eliminar(id_usuario);
    }

    @GetMapping("/buscar/{id_usuario}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id_usuario){
        Usuario usuario = usuarioService.findById(id_usuario);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }
/*
    @PostMapping("/login")
    public ResponseEntity<Optional<Usuario>> login(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(usuarioService.login(usuario));
    }*/
}

