/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Controller;

import com.gt.miumg.sistemas.operativos.Entity.DetalleTransferencia;
import com.gt.miumg.sistemas.operativos.Service.DetalleTransferenciaService;
import com.gt.miumg.sistemas.operativos.Service.TransferenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Oscar
 */
public class DetalleTransferenciaController {
      @Autowired
    private DetalleTransferenciaService detalleTransferenciaService;


    @PostMapping("/crear")
    public ResponseEntity<List<DetalleTransferencia>> crear(@RequestBody List<DetalleTransferencia> detalles){
        return ResponseEntity.ok(detalleTransferenciaService.crearDetalleTransferencia(detalles));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DetalleTransferencia>> listar(int id){
        List<DetalleTransferencia> list = detalleTransferenciaService.getDetallesTransferenciasByIdTransferencia(id);      
        return ResponseEntity.ok(list);
    }

}
