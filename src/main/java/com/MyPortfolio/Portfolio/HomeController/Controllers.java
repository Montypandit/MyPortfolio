package com.MyPortfolio.Portfolio.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class Controllers {

    @GetMapping({"/","","/home"})
    public String showHome(Model model) {
        model.addAttribute("title", "Home");
        return "master"; // This should return the name of your home view (e.g., "home.html")
    }

    @GetMapping("/projects")
    public String showProjects(Model model) {
        model.addAttribute("title", "Projects");
        return "master"; // This should return the name of your projects view (e.g., "projects.html")
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
       model.addAttribute("title", "Contact");
        return "master"; // This should return the name of your contact view (e.g., "contact.html")
    }
    
    @GetMapping("/resume")
    public String showResume(Model model) {
        model.addAttribute("title", "Resume");
        return "master"; // This should return the name of your resume view (e.g., "resume.html")
    }

}
 