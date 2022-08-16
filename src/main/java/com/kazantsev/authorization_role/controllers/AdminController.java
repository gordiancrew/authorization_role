package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StagesRepository stagesRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
       List<Stage> stagelist=stagesRepository.findAll();
        List<Image> imagelist=imagesRepository.findAll();
        List<User> userlist=userRepository.findAll();
        model.addAttribute("stagelist",stagelist);
        model.addAttribute("imagelist",imagelist);
        model.addAttribute("userlist",userlist);
        return "admin";
    }
}
