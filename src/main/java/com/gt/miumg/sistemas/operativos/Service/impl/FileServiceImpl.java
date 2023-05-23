package com.gt.miumg.sistemas.operativos.Service.impl;

import com.gt.miumg.sistemas.operativos.Controller.FileController;
import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.Entity.Transferencia;
import com.gt.miumg.sistemas.operativos.Entity.DetalleTransferencia;
import com.gt.miumg.sistemas.operativos.Repository.DetalleTransferenciaRepository;
import com.gt.miumg.sistemas.operativos.Repository.DocumentoRepository;
import com.gt.miumg.sistemas.operativos.Repository.TransferenciaRepository;
import com.gt.miumg.sistemas.operativos.Service.FileServiceAPI;
import com.gt.miumg.sistemas.operativos.dto.DatosDocumentoDTO;
import com.gt.miumg.sistemas.operativos.projection.DatosDocumentoProjection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public void save(DatosDocumentoDTO datos) throws Exception {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

        logger.info("Se recibieron el/los archivo/s para guardar");
        try {
            Transferencia transferencia = new Transferencia();
            transferencia.setId_usuario(datos.getUsuario_Creacion());
            transferencia.setFechaTransferencia(new Date());
            Transferencia transferenciadb = this.transferenciaRepository.save(transferencia);

            for (MultipartFile file : datos.getFile()) {
                DetalleTransferencia detalle = new DetalleTransferencia();
                detalle.setIdTransferencia(transferenciadb.getIdTransferencia());
                Documento documento = this.save(file, datos.getPropietario());
                detalle.setIdDocumento(documento.getIdDocumento());
                DetalleTransferencia detalledb = detalleRepository.save(detalle);

            }
        } catch (Exception e) {
            logger.error("Ocurrio un error guardando el archivo, error: " + e);
            throw new RuntimeException("No se pudo guardar el archivo" + e);
        }
    }

    @Transactional
    @Override
    public Documento save(MultipartFile file, String propietario) {
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new MaxUploadSizeExceededException(MAX_FILE_SIZE);
        }

        logger.info("Se esta guardando el archivo: " + file.getOriginalFilename()
                + " en la DB y se esta replicando en la carpeta");
        try {
            Documento documento = new Documento();
            documento.setNombre(file.getOriginalFilename());
            documento.setPropietario(propietario);
            documento.setEstado("1");
            Documento documentoDB = documentoRepository.save(documento);
            Files.copy(file.getInputStream(), this.rootFolder.resolve(documentoDB.getIdDocumento() + "-" + file.getOriginalFilename()));
            return documentoDB;
        } catch (Exception e) {
            System.out.println(e);
            logger.error("Ocurrio un error guardando el archivo: " + file.getOriginalFilename()
                    + " error: " + e);
            return null;
        }
    }

    @Override
    public List<DatosDocumentoProjection> getDocumentosByPropietario(String propietario, LocalDate FechaInicio, LocalDate FechaFinal) {
        List<DatosDocumentoProjection> documentos = documentoRepository.getDocumentosByPropietario(propietario, FechaInicio, FechaFinal);
        if (documentos.size() > 0) {
            return documentos;
        }
        return null;
    }

    @Override
    public Resource load(String name) {
        logger.info("Se recibieron los parametros para buscar el archivo: " + name);
        try {
            Path file = this.rootFolder.resolve(name);
            Resource resource = new UrlResource(file.toUri());
            return resource;
        } catch (Exception e) {
            System.out.println(e);
            logger.error("Ocurrio un error buscando el archivo: " + name + " error: " + e);
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
