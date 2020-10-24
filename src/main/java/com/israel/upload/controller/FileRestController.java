package com.israel.upload.controller;

import com.israel.upload.models.Imagen;
import com.israel.upload.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping("api/file")
public class FileRestController {

    @Autowired
    private ImagenService imagenService;

    @PostMapping(value = "upload")
    public ResponseEntity<Object> upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        return new ResponseEntity<>(this.imagenService.guardarFile(file,request), HttpStatus.OK);
    }

    @GetMapping(value = "/imagenes/{id}")
    public ResponseEntity<Object> obtenerTodos(@PathVariable("id") Integer id ) throws IOException {
        Imagen imagen = this.imagenService.obtenerImagen(id);
        /*File file = new File("src/main/webapp/uploads/"+imagen.getNombre());
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" +file.getName())
                .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
                .body(Files.readAllBytes(file.toPath()));*/
        return new ResponseEntity<>(imagen, HttpStatus.OK);
    }



}
