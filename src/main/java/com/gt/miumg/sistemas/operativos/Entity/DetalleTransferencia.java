/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Calendar;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "detalle_transferencia")
@Getter
@Setter
@NoArgsConstructor
public class DetalleTransferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @Column(name = "idtransferencia", length = 1)
    private Integer idTransferencia;

    //@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento")
    private Documento documento;  */
    int idDocumento;
}
