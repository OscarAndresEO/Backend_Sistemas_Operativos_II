/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Entity;

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
@Table(name = "Detalle_Transferencia")
@Getter @Setter
@NoArgsConstructor
public class DetalleTransferencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;



    @Column(name = "idTransferencia", length = 1)
    private String idTransferencia;

   
    @Column(name = "idDocumento")
    private String idDocumento;//varchar(16),--usar dpi o nit

   
}
