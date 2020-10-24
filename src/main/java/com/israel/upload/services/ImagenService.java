package com.israel.upload.services;

import com.israel.upload.models.Imagen;
import com.israel.upload.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@Service
@Transactional
public class ImagenService {
    @Autowired
    private ImagenRepository imagenRepository;
    private static String UPLOAD_DIR="uploads";
    private Imagen imagen;
    public String guardarFile(MultipartFile file, HttpServletRequest request){
        try {
            String fileName = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("")
                    + UPLOAD_DIR + File.separator + fileName;
            saveFile(file.getInputStream(),path);
            this.imagen = new Imagen();
            imagen.setNombre(fileName);
            imagen.setUrl(path);
            Date fecha = new Date();
            imagen.setFecha(fecha);
            imagen.setHora(fecha);
            this.imagenRepository.save(imagen);
            return fileName;
        }catch(Exception e){
            return e.getMessage();
        }
    }
    public 
    private void saveFile(InputStream inputStream, String path) {
        try {
            OutputStream outputStream = new FileOutputStream(new File(path));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
