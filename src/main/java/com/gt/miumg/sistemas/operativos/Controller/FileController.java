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
import com.gt.miumg.sistemas.operativos.dto.DocumentoDto;
//import com.example.demomultiplefileupload.model.File;
//import com.example.demomultiplefileupload.model.Response;
//import com.example.demomultiplefileupload.service.FileServiceAPI;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileServiceAPI fileServiceAPI;

    @PostMapping("/upload/{id_usuario}")
    public ResponseEntity<Response> uploadFiles(@RequestParam("files") List<MultipartFile> files, @PathVariable Integer id_usuario) {
        try {
            fileServiceAPI.save(files, id_usuario);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response("Ocurrio un error interno"));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response("Los archivos fueron cargados correctamente al servidor"));
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws Exception {
        Resource resource = fileServiceAPI.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
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
