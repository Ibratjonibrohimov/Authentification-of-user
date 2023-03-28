package uz.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.practice7.entity.Clients;
import uz.practice7.repository.UserRepository;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/addUser")
    public String addUser( @ModelAttribute Clients user){
        System.out.println(user);
        if(userRepository.existsByUsername(user.getUsername()))return "alreadyExists.html";
        userRepository.save(user);
        System.out.println(getUsers());
        return "login";
    }
    public List<Clients> getUsers(){
        List<Clients> all = userRepository.findAll();
        return all;
    }

}
