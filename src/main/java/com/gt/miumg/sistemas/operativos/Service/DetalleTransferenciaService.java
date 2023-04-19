/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Service;

import com.gt.miumg.sistemas.operativos.Repository.DetalleTransferenciaRepository;
import com.gt.miumg.sistemas.operativos.Entity.DetalleTransferencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar
 */
@Service
public class DetalleTransferenciaService {

    @Autowired
    DetalleTransferenciaRepository detalleRepository;

    public List<DetalleTransferencia> getDetallesTransferenciasByIdTransferencia(Integer id) {
        return detalleRepository.getDetalleTransferenciaByIdTransferencia(id);
    }

    public List<DetalleTransferencia> crearDetalleTransferencia(List<DetalleTransferencia> detalles) {
        for (DetalleTransferencia detalle : detalles) {
            detalleRepository.save(detalle);
        }
        return detalles;
    }
}
