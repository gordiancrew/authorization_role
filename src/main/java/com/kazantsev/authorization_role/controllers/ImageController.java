package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final String IMAGE_UPLOAD = "Картинка добавлена!";

    @Autowired
    private ImagesRepository imagesRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Integer id) {
        byte[] def = {1, 2, 3};
        Image image = imagesRepository.findById(id).orElse(null);

        return ResponseEntity.ok()
                //.header("name",image.getName())
                .body(new InputStreamResource(image != null ? new ByteArrayInputStream(image.getBytes()) :
                        new ByteArrayInputStream(def)));

    }

    @GetMapping("/addimage")
    public String adim(){
        return "addimage";
    }

    @PostMapping("/addimage")
    public String addimagepost(Model model, @RequestParam String id, @RequestParam String name,
                               @RequestParam MultipartFile file) throws IOException {
        Image image;
if(imagesRepository.existsById(Integer.parseInt(id))){
    image=imagesRepository.getById(Integer.parseInt(id));

}else{
    image=new Image();
    image.setId(Integer.parseInt(id));
}

      if(!name.equals("")){
        image.setName(name);}
      if(!file.isEmpty()){
        image.setBytes(file.getBytes());}
        imagesRepository.save(image);
        model.addAttribute("info", IMAGE_UPLOAD);
        return "admin";
    }
}
