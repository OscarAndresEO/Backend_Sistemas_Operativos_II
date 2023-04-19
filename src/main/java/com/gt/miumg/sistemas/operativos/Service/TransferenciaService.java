/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Service;

import com.gt.miumg.sistemas.operativos.Entity.Transferencia;
import com.gt.miumg.sistemas.operativos.Repository.TransferenciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar
 */
@Service
public class TransferenciaService { 
  @Autowired
  TransferenciaRepository transferenciaRepository; 
  
 public Optional<Transferencia> getTransferenciaById(Integer id) {
        return transferenciaRepository.getTransferenciaById(id);
    }

    public Transferencia crearTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }
}
