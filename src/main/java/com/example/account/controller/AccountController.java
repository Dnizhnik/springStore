package com.example.account.controller;

import com.example.account.domain.User;
import com.example.account.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registration")
public class AccountController {
    public final UserRepository userRepository;

    @Autowired
    public AccountController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> list () {
        return userRepository.findAll();
    }
    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User login) {
        return login;
    }
    @PostMapping
    public @ResponseBody String addNewUser(@RequestParam User login) {
        return userRepository.save(login);
    }
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


