package com.gt.miumg.sistemas.operativos.Service;

import com.gt.miumg.sistemas.operativos.Entity.Documento;
import com.gt.miumg.sistemas.operativos.dto.DatosDocumentoDTO;
import com.gt.miumg.sistemas.operativos.projection.DatosDocumentoProjection;
import java.nio.file.Path;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceAPI {

    public Documento save(MultipartFile file, String propietario);

    public Resource load(String name);

    public void save(DatosDocumentoDTO datos) throws Exception;

    public Stream<Path> loadAll();

    public List<DatosDocumentoProjection> getDocumentosByPropietario(String propietario, LocalDate  FechaInicio, LocalDate  FechaFinal);
	
}
