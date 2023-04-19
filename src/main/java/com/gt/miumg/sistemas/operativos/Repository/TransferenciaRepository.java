/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Repository;

/**
 *
 * @author Oscar
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gt.miumg.sistemas.operativos.Entity.Transferencia;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {


    @Query(value = "select * from transferencia t where t.estado !='E' AND t.idTransferencia=?1", nativeQuery = true)
    public Optional<Transferencia> getTransferenciaById(int idTransferencia);

}
