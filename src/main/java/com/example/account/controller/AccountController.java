package com.example.account.controller;

import com.example.account.domain.User;
import com.example.account.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller

public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String greeting (Map<String, Object> model) {
        return "greeting";
    }

   /* @GetMapping(path = "/main")
    public String main (Map<String, Object> model) {
        Iterable<User> getAllUsers() {
            return userRepository.findAll();
        }
        return "main";
    }*/

    @PostMapping(path = "/main")
    public String add(@RequestParam String email, String fio, String log, String password, long phone) {
        User n = new User();
        n.setEmail(email);
        n.setFio(fio);
        n.setLog(log);
        n.setPassword(password);
        n.setPhone(phone);
        userRepository.save(n);
        return "User";
    }
    /*public AccountController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
   */

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User login
    ) {
        BeanUtils.copyProperties(login, userFromDb);
        return userRepository.save(login);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User login) {
        userRepository.delete(login);
    }


    }


