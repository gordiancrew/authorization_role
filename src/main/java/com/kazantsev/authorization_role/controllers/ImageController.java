package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;
import java.io.ByteArrayInputStream;

@Controller
@RequiredArgsConstructor
public class ImageController {
    private final StagesRepository stagesRepository;
//
//    @GetMapping("/imagess/{id}")
//    private ResponseEntity<?> getStageById(@PathVariable Integer id){
//        byte[]def= {1,2,3};
//        Stage stage= stagesRepository.findById(id).orElse(null);
//
//        return  ResponseEntity.ok()
//                .header("name",stage.getName())
//                .body(new InputStreamResource(stage!=null?new ByteArrayInputStream(stage.getImg()):
//                        new ByteArrayInputStream(def)));
//
//    }

//    @GetMapping("/images/{id}")
//    private ResponseEntity<?> getImageById(@PathVariable Integer id){
//        byte[]def= {1,2,3};
//        Image image= imagesRepository.findById(id).orElse(null);
//
//        return  ResponseEntity.ok()
//                .header("imagename",image.getImagename())
//                .body(new InputStreamResource(image!=null?new ByteArrayInputStream(image.getBytes()):
//                        new ByteArrayInputStream(def)));
//
//    }
}
