package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    private final String USER_DELETE="Пользователь удален";
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  StagesRepository stagesRepository;

    @Autowired
    private   ImagesRepository imagesRepository;

    @GetMapping("/delete")
    public String delete(){
        return "delete";
    }

    @PostMapping("/deleteuser")
    public String deleteuser(Model model, @RequestParam String iduser){
        User user=userRepository.getById(Integer.parseInt(iduser));
        userRepository.delete(user);
        model.addAttribute("info",USER_DELETE);
        return "delete";
    }

}
