package com.example.account.repo;

import com.example.account.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePage {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public  String greeting(Map<String, Object> model
    ) {

        return  "greeting";
    }

    @GetMapping("/main")
    public  String main(Map<String, Object> model) {
        Iterable<login> messages = userRepository.findAll();
        model.put("name", name);
        return  "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        User login = new User();
        UserRepository.save(login);
        Iterable<Login> logins = UserRepository.findAll();
        model.put(List< User > list(), logins);
        return  "main";
    }
    //@PostMapping("/filter")
}
