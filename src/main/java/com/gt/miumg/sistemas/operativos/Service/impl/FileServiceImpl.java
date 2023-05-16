package com.gt.miumg.sistemas.operativos.Service.impl;

import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.Entity.Transferencia;
import com.gt.miumg.sistemas.operativos.Entity.DetalleTransferencia;
import com.gt.miumg.sistemas.operativos.Repository.DetalleTransferenciaRepository;
import com.gt.miumg.sistemas.operativos.Repository.DocumentoRepository;
import com.gt.miumg.sistemas.operativos.Repository.TransferenciaRepository;
import com.gt.miumg.sistemas.operativos.Service.FileServiceAPI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import static sun.font.CreatedFontTracker.MAX_FILE_SIZE;

@Service
public class FileServiceImpl implements FileServiceAPI {

    private final Path rootFolder = Paths.get(System.getProperty("user.dir"), "Documentos");

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    DetalleTransferenciaRepository detalleRepository;

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Override
    public void save(List<MultipartFile> files, Integer id_usuario) throws Exception {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

        try {
            Transferencia transferencia = new Transferencia();
            transferencia.setId_usuario(id_usuario);
            transferencia.setFechaTransferencia(new Date());
            Transferencia transferenciadb = this.transferenciaRepository.save(transferencia);

            for (MultipartFile file : files) {
                DetalleTransferencia detalle = new DetalleTransferencia();
                detalle.setIdTransferencia(transferenciadb.getIdTransferencia());
                Documento documento = this.save(file);
                detalle.setIdDocumento(documento.getIdDocumento());
                DetalleTransferencia detalledb = detalleRepository.save(detalle);

            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el archivo");
        }
    }

    @Transactional
    @Override
    public Documento save(MultipartFile file) {
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new MaxUploadSizeExceededException(MAX_FILE_SIZE);
        }
        try {
            Documento documento = new Documento();
            documento.setNombre(file.getOriginalFilename());
            Documento documentoDB = documentoRepository.save(documento);
            Files.copy(file.getInputStream(), this.rootFolder.resolve(documentoDB.getIdDocumento() + "-" + file.getOriginalFilename()));
            return documentoDB;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Resource load(String name) {
        try {
            Path file = this.rootFolder.resolve(name);
            Resource resource = new UrlResource(file.toUri());
            return resource;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
