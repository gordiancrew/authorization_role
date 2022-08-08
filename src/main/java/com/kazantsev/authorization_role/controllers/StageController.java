package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.repos.StagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class StageController {

    @Autowired
    StagesRepository stagesRepository;

    @GetMapping("/addstage")
    public String stage() {
        System.out.println(1);
        return "addstage";
    }

    @PostMapping("/addstage")
    public String addstage(Model model, @RequestParam String id, @RequestParam String name,
                           @RequestParam String q1, @RequestParam String q2, @RequestParam String q3,
                           @RequestParam String a1, @RequestParam String a2, @RequestParam String a3) throws IOException {
        System.out.println(2);
        Stage stage = new Stage();
        stage.setId(Integer.parseInt(id));
        stage.setName(name);
        stage.setQ1(q1);
        stage.setQ2(q2);
        stage.setQ3(q3);
        stage.setA1(a1);
        stage.setA2(a2);
        stage.setA3(a3);
//        stage.setImg(file.getBytes());
        stagesRepository.save(stage);
        System.out.println(3);
        return "admin";
    }
}
