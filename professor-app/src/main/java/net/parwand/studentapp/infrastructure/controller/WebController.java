package net.parwand.studentapp.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }


    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }

    @GetMapping("/manage-students")
    public String manageStudents() {
        return "manage-students";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
