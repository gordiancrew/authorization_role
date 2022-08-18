package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.LocsRepository;
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

    private final String STAGE_DELETE="Сцена удалена";
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  StagesRepository stagesRepository;

    @Autowired
    private   ImagesRepository imagesRepository;

    @Autowired
    private LocsRepository locsRepository;

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

    @PostMapping("/deletestage")
    public String deletestage(Model model, @RequestParam String idstage){
        Stage stage=stagesRepository.getById(Integer.parseInt(idstage));
        stagesRepository.delete(stage);
        model.addAttribute("info",STAGE_DELETE);
        return "delete";

    }

    @PostMapping("/deleteimage")
    public String deleteimage(Model model, @RequestParam String idimage){
        Image  image=imagesRepository.getById(Integer.parseInt(idimage));
        imagesRepository.delete(image);
        return "delete";

    }

    @PostMapping("/deleteloc")
    public String deleteloc(Model model, @RequestParam String idloc){
        Image  image=imagesRepository.getById(Integer.parseInt(idloc));
        imagesRepository.delete(image);
        return "delete";

    }

}
