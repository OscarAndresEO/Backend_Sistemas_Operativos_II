package com.gt.miumg.sistemas.operativos.Service;

import com.gt.miumg.sistemas.operativos.Entity.Documento;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceAPI {
	
	public Documento save(MultipartFile file) ;
	
	public Resource load(String name);
	
	public void save(List<MultipartFile> files,Integer id_usuario) throws Exception;
	
	public Stream<Path> loadAll() ;
	
}
