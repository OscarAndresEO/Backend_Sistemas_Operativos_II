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
@Table(name = "documentos")
@Getter
@Setter
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;

    @Column(name = "nombreDocumento", length = 64)
    private String nombre;

    @Column(name = "propietario", length = 50)
    private String propietario;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "usuariomodificacion")
    private String usuario_modificacion;// varchar(16),

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechamodificaciondocumento",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha_modificacion;

}
