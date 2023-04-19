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
import com.gt.miumg.sistemas.operativos.Entity.Documento;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

     @Query(value = "select *"+
            "from documento d\n" +
            " where d.estado!='E'", nativeQuery = true)
    public List<Documento> findAllDocuments();

    @Query(value = "select * from Documento d where u.estado !='E' AND u.id_documento=?1", nativeQuery = true)
    public Documento findDocumentoById(int idDocumento);

    //Cambiar estado a eliminado logico
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Documento set estado='E' where id_documento=?1", nativeQuery = true)
    public void eliminarDocumento(int idDocumento);

}
