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
import com.gt.miumg.sistemas.operativos.Entity.Transferencia;
import com.gt.miumg.sistemas.operativos.Service.TransferenciaService;
import com.gt.miumg.sistemas.operativos.Service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transferencia")
@CrossOrigin("*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;


    @PostMapping("/crear")
    public ResponseEntity<Transferencia> crear(@RequestBody Transferencia transferencia){
        return ResponseEntity.ok(transferenciaService.crearTransferencia(transferencia));
    }

    @GetMapping("/listar")
    public ResponseEntity<Optional<Transferencia>> listar(int id){
        Optional<Transferencia> list = transferenciaService.getTransferenciaById(id);      
        return ResponseEntity.ok(list);
    }

    
}

