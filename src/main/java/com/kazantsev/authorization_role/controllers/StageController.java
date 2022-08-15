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
                           @RequestParam String q1, @RequestParam String q11, @RequestParam String q2,
                           @RequestParam String q22,@RequestParam String q3, @RequestParam String q33,
                           @RequestParam String a1, @RequestParam String a2, @RequestParam String a3) throws IOException {
        Stage stage;
        //Stage stageExist = stagesRepository.getById(Integer.parseInt(id));
        if (stagesRepository.existsById(Integer.parseInt(id))) {
            stage = stagesRepository.getReferenceById(Integer.parseInt(id));
        } else {
            stage = new Stage();
            stage.setId(Integer.parseInt(id));
        }
        if (!name.equals("")) {
            stage.setName(name);
        }
        if (!q1.equals("")) {
            stage.setQ1(q1);
        }
        if (!q11.equals("")) {
            stage.setQ11(q11);
        }
        if (!q2.equals("")) {
            stage.setQ2(q2);
        }
        if (!q22.equals("")) {
            stage.setQ22(q22);
        }
        if (!q3.equals("")) {
            stage.setQ3(q3);
        }
        if (!q33.equals("")) {
            stage.setQ33(q33);
        }
        if (!a1.equals("")) {
            stage.setA1(a1);
        }
        if (!a2.equals("")) {
            stage.setA2(a2);
        }
        if (!a3.equals("")) {
            stage.setA3(a3);
        }

        stagesRepository.save(stage);
        return "admin";
    }
}
