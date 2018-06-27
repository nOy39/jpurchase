package org.a2lpo.purchase.joint.purchase.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    public String uploadFile(MultipartFile file) {
        String fileName = "";

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String uuid = UUID.randomUUID().toString();
        fileName = uuid + "." + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadPath+"/"+fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fileName;
    }
}
