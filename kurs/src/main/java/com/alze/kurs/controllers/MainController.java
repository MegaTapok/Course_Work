package com.alze.kurs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Контроллер по обработке главной страницы и страницы "О нас"

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage( Model model) //@RequestParam(name="name", required=false, defaultValue="World") String name,
    {
        model.addAttribute("title", "Home Page");
        return "home-page";
    }

    @GetMapping("/about")
    public String aboutPage( Model model) //@RequestParam(name="name", required=false, defaultValue="World") String name,
    {
        model.addAttribute("title", "About");
        return "about-info";
    }
}