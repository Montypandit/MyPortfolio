package com.MyPortfolio.Portfolio.HomeController;

// public class ContactController {

// }

// package com.example.demo.controller;

import com.MyPortfolio.Portfolio.Service.EmailService;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ContactController {

    private final EmailService emailService;

    @Autowired
    public ContactController(EmailService emailService) {
        this.emailService = emailService;  // Inject EmailService
    }

    // Get request to load the contact form page
    @GetMapping("/contact-us")
    public String showContactForm() {
        return "contact";  // Return the Thymeleaf contact form page (contact.html)
    }

    // Post request to handle the form submission
    @PostMapping("/contact-us")
    public String handleContactForm(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String phone,
        @RequestParam String message,
        Model model) {

        // Subject and body of the email
        String subject = "New Contact Message from " + name;
        String body = "You have received a new message from the contact form:\n\n"
                    + "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Phone: " + phone + "\n\n"
                    + "Message:\n" + message;

        // Send the email
        emailService.sendEmail("monty29550@gmail.com", subject, body);  // Recipient email

        // Add a success message to the model
        model.addAttribute("message", "Thank you for contacting us! We will get back to you shortly.");
        return "contact";  // Redirect back to the contact page with success message
    }
}
