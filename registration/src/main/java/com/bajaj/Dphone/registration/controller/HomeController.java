package com.bajaj.Dphone.registration.controller;

import javax.servlet.http.HttpSession;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bajaj.Dphone.registration.model.UserDtls;
import com.bajaj.Dphone.registration.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping(path = )
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @Operation(description = "This mapping is used to map to the home page")
    public String index() {
        return "index"; //
    }

    @GetMapping("/signin")
    @Operation(description = "This mapping is used to map to the login page")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

        // System.out.println(user);

        boolean f = userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id alreday exists");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Register Sucessfully");
            } else {
                session.setAttribute("msg", "Something wrong on server");
            }
        }

        return "redirect:/register";
    }
}