package com.israel.upload.controller;

import com.israel.upload.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("api/file")
public class FileRestController {

    @Autowired
    private ImagenService imagenService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResponseEntity<Object> upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        return new ResponseEntity<>(this.imagenService.guardarFile(file,request), HttpStatus.OK);
    }



}
