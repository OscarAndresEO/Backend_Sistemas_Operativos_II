/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
//import com.gt.miumg.sistemas.operativos.Utils.FileUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Oscar
 */
@Service
public class FileSystemService {
/*
    private String basePath;

    @Autowired
    FileUtils fileUtils;

    public FileSystemService(@Value("${fileSystem.basePath:/tmp}") String basePath) {
        this.basePath = basePath;
    }

    public boolean createDirectory(String directoryName) {
        File directory = new File(basePath + "/" + directoryName);
        return directory.mkdirs();
    }

    public boolean deleteDirectory(String directoryName) {
        File directory = new File(basePath + "/" + directoryName);
        if (!directory.exists()) {
            return true;
        }
        try {
            fileUtils.deleteDirectory(directory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createFile(String directoryName, String fileName) {
        File directory = new File(basePath + "/" + directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(basePath + "/" + directoryName + "/" + fileName);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveFile(String fileName, byte[] fileContent) throws IOException {
      
        Path filePath = Paths.get(basePath  + fileName);
        Files.write(filePath, fileContent);

    }

    public File getFileByName(String fileName) {
        String ruta = "C:/Documentos/";
        File directory = new File(ruta);

        if (!directory.exists()) {
            return null;
        }

        return Arrays.stream(directory.listFiles())
                .filter(file -> file.isFile() && file.getName().equalsIgnoreCase(fileName))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteFile(String directoryName, String fileName) {
        File file = new File(basePath + "/" + directoryName + "/" + fileName);
        return file.delete();
    }

    public List<String> listFiles(String directoryName) {
        File directory = new File(basePath + "/" + directoryName);
        if (!directory.exists()) {
            return new ArrayList<>();
        }
        String[] fileList = directory.list();
        List<String> files = new ArrayList<>();
        for (String file : fileList) {
            files.add(file);
        }
        return files;
    }

    public boolean writeFile(String directoryName, String fileName, String content) {
        File file = new File(basePath + "/" + directoryName + "/" + fileName);
        try {
            fileUtils.writeStringToFile(file, content, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String readFile(String directoryName, String fileName) {
        File file = new File(basePath + "/" + directoryName + "/" + fileName);
        try {
            return fileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
