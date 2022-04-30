package com.alze.kurs.controllers;

import com.alze.kurs.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String searchPage( Model model) //@RequestParam(name="name", required=false, defaultValue="World") String name,
    {
        model.addAttribute("title", "Search Page");
        return "search-page";
    }

    @PostMapping("/search")
    public String searchEngine(@RequestParam String search_request , Model model) throws IOException {
        Search req = new Search("7d1f27c7099944e99b8fbb618f7cb2e7");
        req.worldNews(search_request, "&sortBy=popularity&language=ru&apiKey=");

        //System.out.println(search_request);
        return "search-page";
    }

}
