/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.Repository.DocumentoRepository;
import com.gt.miumg.sistemas.operativos.Repository.UsuarioRepository;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
/**
 *
 * @author Oscar
 **/

@Service
public class DocumentosServices {
    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento SaveDocumento(Documento documento){
        //Usuario user = usuarioRepository.save(usuario);
        //return user;
        return documentoRepository.save(documento);
    }

    public List<Documento> findAll(){
        return documentoRepository.findAllDocuments();
    }

   public void eliminar(int idDocumento){
        documentoRepository.eliminarDocumento(idDocumento);
   }

   public Documento findById(int idDocumento){
        return documentoRepository.findDocumentoById(idDocumento);
   }

    
    @Value("${file.upload-dir}") // lee la ruta del archivo de configuración application.properties
    private String fileUploadDir;
    
    
    public String storeFile(MultipartFile file) throws IOException {
        // generar un nombre de archivo único
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        
        // construir la ruta completa del archivo
        Path filePath = Paths.get(fileUploadDir).resolve(fileName);
        
        // copiar el archivo a la ruta especificada
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        
        // guardar la ruta del archivo en la base de datos
        Documento documento = new Documento();
        documento.setNombre(fileName);
        documento.setLinkDocumento(filePath.toString());
        documentoRepository.save(documento);
        
        return filePath.toString();
    }


}
