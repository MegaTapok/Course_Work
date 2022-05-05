package com.alze.kurs.controllers;

import com.alze.kurs.Search;
import com.alze.kurs.db.CollectedNews;
import com.alze.kurs.db.repository.CollectedNewsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    private CollectedNewsRep cnrepo;

    @GetMapping("/search")
    public String searchPage( Model model) //@RequestParam(name="name", required=false, defaultValue="World") String name,
    {
        model.addAttribute("title", "Search Page");
        return "search-page";
    }

    @PostMapping("/search")
    public String searchEngine(@RequestParam String search_request , Model model) throws IOException {
        if(cnrepo.findById(0L) != null){cnrepo.deleteAll();};
        Search req = new Search("7d1f27c7099944e99b8fbb618f7cb2e7");
        req.worldNews(search_request, "&sortBy=popularity&language=ru&apiKey=");
        int size=req.getPost_url().size();
        for(int i = 0; i <size; i++)
        {
            cnrepo.save(new CollectedNews((long) i,req.getPost_url().get(i),req.getPick_url().get(i)));
        };
        Iterable<CollectedNews> collectedNews=cnrepo.findAll();
        model.addAttribute("CollectedNewsPicks",collectedNews);
        return "search-page";
    }

}
