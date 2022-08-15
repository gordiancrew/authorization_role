package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StagesRepository stagesRepository;




    @GetMapping("/quests")
    public String quests(Model model) {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        Stage stage = user.getStage();


        model.addAttribute("stage", stage);

        return "quests";
    }

    @PostMapping("/quests")
    public String move(Model model, @RequestParam String answer1, @RequestParam String answer2,
                       @RequestParam String answer3) {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);

        if (answer1.equals(user.getStage().getA1()) && answer2.equals(user.getStage().getA2())
                && answer3.equals(user.getStage().getA3())) {

            int currentId = user.getStage().getId();
            //userRepository.plusStage(currentId);
            int newId = currentId + 1;

            if (newId == 5) {
                return "finish";
            }
            Stage newStage = stagesRepository.getReferenceById(newId);
            user.setStage(newStage);
            userRepository.save(user);


            return "success";
        }
        return "fail";
    }
}
