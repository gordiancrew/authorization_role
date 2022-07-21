package com.kazantsev.authorization_role.uploader;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {


    public static boolean upload(MultipartFile file, String path, String fileName){

        String realPath = path + "/" + fileName;
        //String realPath = fileName;
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            // Сохранить файл
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
