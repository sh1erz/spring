package com.example.spring2.controller;

import com.example.spring2.model.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExceptionController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @GetMapping("/exception")
    public String exception(Model model, @RequestParam String message){
        ExceptionMessage exceptionMessage = context.getBean(ExceptionMessage.class);
        exceptionMessage.setMessage(message);
        model.addAttribute("message", exceptionMessage);
        return "error_page";
    }
}
