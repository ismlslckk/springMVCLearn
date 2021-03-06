package com.ismlslck;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Utility {
    private static final String UPLOAD_AVATAR_PATH = "/Users/ismlslck/IdeaProjects/springMVCLearn/WebContent/WEB-INF/uploads/avatar/";

    public static String uploadFile(MultipartFile file) {
        String randomString = RandomStringUtils.randomAlphanumeric(15);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                //String rootPath = System.getProperty("catalina.home");
                File dir = new File(UPLOAD_AVATAR_PATH);
                if (!dir.exists())
                    dir.mkdirs();


                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + randomString + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                return randomString+"."+FilenameUtils.getExtension(file.getOriginalFilename());
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
