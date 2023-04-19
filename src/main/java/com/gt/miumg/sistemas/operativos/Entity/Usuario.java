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
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombre", length = 64)
    private String nombre;

    @Column(name = "direccion", length = 64)
    private String direccion;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "cui", length = 13)
    private String cui;

    @Column(name = "username", length = 16)
    private String username;

    @Column(name = "clave", length = 16)
    private String clave;

    @Column(name = "rol", length = 2)
    private String rol;


    @Column(name = "estado", length = 1)
    private String estado;

   
    @Column(name = "usuario_creacion")
    private String usuario_creacion;//varchar(16),--usar dpi o nit

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
