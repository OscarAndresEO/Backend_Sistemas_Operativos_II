/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Oscar
 */

@Entity
@Table(name = "transferencia")
@Getter @Setter
@NoArgsConstructor
public class Transferencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransferencia;

    @Column(name = "codigoUsuario", length = 64)
    private Integer id_usuario;    

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaTransferencia",
            columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Date fechaTransferencia;

}
