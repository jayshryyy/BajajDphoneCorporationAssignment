package com.bajaj.Dphone.registration.controller;

import java.security.Principal;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bajaj.Dphone.registration.model.UserDtls;
import com.bajaj.Dphone.registration.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String email = p.getName();
        UserDtls user = userRepo.findByEmail(email);

        m.addAttribute("user", user);

    }

    @GetMapping("/")
    @Operation(description = "This mapping is used to map to the user/home page")
    public String home() {
        return "user/home";
    }

}
