package com.example.pbqph_api.controllers;

import com.example.pbqph_api.models.EmailModel;
import com.example.pbqph_api.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailModel emailModel) {
        try {
            String to = "rafaelferreiradorf@gmail.com";
            String subject = "New Message from " + emailModel.getName();
            String text = String.format(
                    "Name: %s\nMessage: %s\nOrigem: %s\nEmpresa: %s\nSegmento: %s\nTelefone Celular: %s\nTelefone Fixo: %s\nCEP: %s\nCidade: %s\nEstado: %s\nEmail: %s",
                    emailModel.getName(),
                    emailModel.getMessage(),
                    emailModel.getOrigem(),
                    emailModel.getEmpresa(),
                    emailModel.getSegmento(),
                    emailModel.getTelefone_celular(),
                    emailModel.getTelefone_fixo(),
                    emailModel.getCep(),
                    emailModel.getCidade(),
                    emailModel.getEstado(),
                    emailModel.getEmail()
            );
            emailService.sendEmail(to, subject, text);
            return "Email sent successfully!";
        }  catch (Exception e) {
            logger.error("Error while sending email: {}", e.getMessage());
            logger.debug("Exception: ", e); // This will log the full stack trace for debugging purposes
            return "Failed to send email.";
        }
    }
}