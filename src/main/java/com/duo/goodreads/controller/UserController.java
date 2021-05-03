package com.duo.goodreads.controller;

import com.duo.goodreads.configuration.WebSecurityConfig;
import com.duo.goodreads.model.Authority;
import com.duo.goodreads.model.User;
import com.duo.goodreads.repository.AuthorityRepository;
import com.duo.goodreads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private AuthorityRepository authorityRepository;
    @Autowired private WebSecurityConfig webSecurityConfig;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "html/sign-up";
    }


    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "html/sign-up";
        }

        user.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setUsername(user.getUsername());
        authority.setUser(user);
        authority.setAuthority("ROLE_USER");

        user.setAuthority(authority);

        userRepository.save(user);
        authorityRepository.save(authority);

        return "redirect:/login";
    }


}