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
@Table(name = "Documento")
@Getter @Setter
@NoArgsConstructor
public class Documento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Documento;

    @Column(name = "nombreDocumento", length = 64)
    private String nombre;

    @Column(name = "linkDocumento", length = 64)
    private String linkDocumento;


    @Column(name = "estado", length = 1)
    private String estado;


    @Column(name = "usuario_modificacion")
    private String usuario_modificacion;// varchar(16),


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion",
            columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private Calendar fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", 
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar fecha_modificacion;
}
