package com.alze.kurs.controllers;

import com.alze.kurs.db.DbService;
import com.alze.kurs.searchEngine.Search;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

// Констроллер обработчик поиска новостей

@Controller
@AllArgsConstructor
public class SearchController {

    private DbService dbService;

    @GetMapping("/search")
    public String searchPage( Model model) //@RequestParam(name="name", required=false, defaultValue="World") String name,
    {
        model.addAttribute("title", "Search Page");
        return "search-page";
    }

    @PostMapping("/search")
    public String searchEngine(@RequestParam String search_request , Model model) throws IOException {
        Search req = new Search("58ca3be1363f4012a209bdc5e6ac87ec");
        dbService.bdCheck();
        req.worldNews(search_request, "&sortBy=popularity&language=ru&apiKey=");//тут работа с API а именно создание ссылки по запросу
        System.out.println("Всего найдено - "+req.getSearchFinal().getTotalResults());
        System.out.println("Размер массива - "+req.getSearchFinal().getArticles().size());
        dbService.bdUpdate(req);
        model.addAttribute("Collected",dbService.bdFindAll());
        return "search-page";
    }

}
