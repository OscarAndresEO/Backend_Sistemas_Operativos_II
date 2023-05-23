/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.dto;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Oscar
 */
@Data
@NoArgsConstructor
public class DatosDocumentoDTO {
    String propietario;
    Integer usuario_Creacion;
    Date fecha;
    MultipartFile file[];
}
