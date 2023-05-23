package com.gt.miumg.sistemas.operativos.Controller;

import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.Service.FileServiceAPI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.Entity.Response;
import com.gt.miumg.sistemas.operativos.dto.DatosDocumentoDTO;
import com.gt.miumg.sistemas.operativos.dto.DocumentoDto;
import com.gt.miumg.sistemas.operativos.projection.DatosDocumentoProjection;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;


/**
 *
 * @author Oscar
 */

@RestController
@RequestMapping("/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileServiceAPI fileServiceAPI;

    @PostMapping("/save")
    public ResponseEntity uploadFiles(@RequestParam("file") MultipartFile[] files,
            @RequestParam("propietario") String propietario,
            @RequestParam("fecha") String fecha,
            @RequestParam("usuarioCreacion") String usuarioCreacion) throws Exception {

        try {
            logger.info("Se inició la operación de guardar el archivo");
            DatosDocumentoDTO datos = new DatosDocumentoDTO();
            datos.setFile(files);
            datos.setPropietario(propietario);
            datos.setFecha(new Date(fecha));
            datos.setUsuario_Creacion(Integer.parseInt(usuarioCreacion));

            fileServiceAPI.save(datos);

            logger.info("Se finalizó la operación de guardar el archivo");
        } catch (IOException e) {
            logger.error("Mensaje de error: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Ocurrió un error interno"));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response("Los archivos fueron cargados correctamente al servidor"));
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws Exception {
        logger.info("Se inicio la operacion de busqueda de archivo");

        Resource resource = fileServiceAPI.load(filename);
        logger.info("Se recibieron los parametros para buscar el archivo: " + filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/findDocumentosByPropietario")
    public List<DatosDocumentoProjection> getDocumentosByPropietario(
            @RequestParam("propietario") String propietario,
        @RequestParam("FechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
        @RequestParam("FechaFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFinal) {
        logger.info("Se inicio la operacion de busqueda de archivos segun el propietario");
        return fileServiceAPI.getDocumentosByPropietario(propietario,  fechaInicio,fechaFinal);

    }

    @GetMapping("/all")
    public ResponseEntity<List<DocumentoDto>> getAllFiles() throws Exception {
        List<DocumentoDto> files = fileServiceAPI.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new DocumentoDto(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

}
