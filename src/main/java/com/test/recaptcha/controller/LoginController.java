package com.test.recaptcha.controller;

import com.test.recaptcha.aspect.RequiresCaptcha;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @CrossOrigin(origins = "*")
    @PostMapping
    @RequiresCaptcha
    public LoginResponseDTO login(@RequestBody LoginDTO login){
        if ("admin".equals(login.getUserName())) return new LoginResponseDTO("Success Login: " + login.getUserName());
        return new LoginResponseDTO("Failure Login: " + login.getUserName());
    }
}
