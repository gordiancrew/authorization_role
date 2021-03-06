package com.kazantsev.authorization_role.uploader;

public class FileNameUtils {

    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }


    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }
}
