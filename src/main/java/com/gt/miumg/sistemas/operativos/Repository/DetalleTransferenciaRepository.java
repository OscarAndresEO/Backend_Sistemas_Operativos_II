/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Repository;

/**
 *
 * @author Oscar
 */

import com.gt.miumg.sistemas.operativos.Entity.DetalleTransferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gt.miumg.sistemas.operativos.Entity.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface DetalleTransferenciaRepository extends JpaRepository<DetalleTransferencia, Integer> {

    @Query(value = "select * from public.detalle_transferencia dt where dv.idTransferencia = :id", nativeQuery = true)
    List<DetalleTransferencia> getDetalleTransferenciaByIdTransferencia(@PathVariable Integer id);
}
