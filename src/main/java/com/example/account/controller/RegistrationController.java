package com.example.account.controller;

import com.example.account.domain.User;
import com.example.account.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
   public  String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByFio(user.getFio());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return  "registration";
        }

        return  "redirect:/login";
    }
}


