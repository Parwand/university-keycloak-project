package net.parwand.studentapp.infrastructure.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/home")
    public String index() {
        return "home";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }

    @PostMapping("/student")
    public @ResponseBody String studentPagePost() {
        return "new student";
    }

    @GetMapping("/manage-student")
    // @PreAuthorize("hasAuthority('PROFESSOR')")
    public String manageStudents() {
        return "manage-student";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
