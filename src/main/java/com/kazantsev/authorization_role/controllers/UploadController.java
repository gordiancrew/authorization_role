package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.uploader.FileNameUtils;
import com.kazantsev.authorization_role.uploader.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class UploadController {
    @Autowired
    private ImagesRepository imagesRepository;


  //  @PostMapping("/addimages")
  //  public String addimagepost(Model model, @RequestParam MultipartFile file) throws IOException {
//        String newFileName = FileNameUtils.getFileName(file.getOriginalFilename());
//        Image img = new Image();
//        img.setImagename(newFileName);
//        img.setBytes(file.getBytes());
//        imagesRepository.save(img);


//        if (FileUtils.upload(file, path, newFileName)) {
//            model.addAttribute("info", "upload is successful");
//
//        } else {
//            model.addAttribute("info", "upload is error");
//        }

    //    return "home";
   // }


}

