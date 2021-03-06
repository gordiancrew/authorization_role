package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Role;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import com.kazantsev.authorization_role.uploader.FileNameUtils;
import com.kazantsev.authorization_role.uploader.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ImagesRepository imagesRepository;

    @GetMapping("/")
    public String start() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Image> imagelist=imagesRepository.findAll();
        model.addAttribute("imagelist",imagelist);
        return "admin";
    }


    @GetMapping("/user")
    public String user() {
        return "home";
    }

    @GetMapping("/adminuser")
    public String adminuser() {
        return "adminuser";
    }





}
