package org.a2lpo.purchase.joint.purchase.controller;

import org.a2lpo.purchase.joint.purchase.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String testPage(Model model) {
        return "test";
    }

    @GetMapping(value = "userlist")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "userlist";
    }
}
