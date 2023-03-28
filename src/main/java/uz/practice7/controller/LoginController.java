package uz.practice7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.practice7.dtos.LoginDto;
import uz.practice7.dtos.NumberDto;
import uz.practice7.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String checkUser(LoginDto loginDto){
        if(userRepository.existsByUsernameAndPassword(loginDto.getUsername(),loginDto.getPassword()))
            return "index";
        if (userRepository.existsByPassword(loginDto.getPassword()) )
            return "loginEror";
        if (userRepository.existsByUsername(loginDto.getUsername()))
            return "loginEror";
        return "toRegister";
    }

    @PostMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @PostMapping("/backLogin")
    public String backLogin(){
        return "login";
    }
    @PostMapping("/forgot")
    public String forgot(){
        return "forgot";
    }

    @PostMapping("/forgottenNumber")
    public String forgotResult(NumberDto numberDto){
        if(userRepository.existsByPhoneNumber(numberDto.getPhoneNumber()))return "forgotResult";
        return "forgotResultEror";
    }

}
