package com.alze.kurs.searchEngine;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.String;
import java.net.URL;

//Основное взаимодействие с News API
@Service
public class Search{

    private String api_key;

    private SearchResFin searchFinal;
    public SearchResFin getSearchFinal() {
        return searchFinal;
    }

    public Search(String api_key){
        this.api_key = api_key;
    }
    public Search(){}

    public void worldNews(String source, String linkPart ) throws IOException {
        String link = "https://newsapi.org/v2/everything?q="+editor(source)+linkPart+api_key;
        link = goToNews(link);
        searchFinal = searchParse(link);
    }

    public void localNews(String source, String linkPart) throws IOException {
        String link = "https://newsapi.org/v2/top-headlines?q="+editor(source)+linkPart+api_key;
        link = goToNews(link);
        searchFinal = searchParse(link);
    }

    private String editor(String str){
        if(str==""){return "today";}else{
        return str.replace(" ","+");}
    }

    private String goToNews(String link) throws IOException {
        URL url = new URL(link);
        BufferedInputStream input = new BufferedInputStream(url.openStream());
        byte[] buffer = input.readAllBytes();
        return new String(buffer);
    }

    private SearchResFin searchParse(String link) {
        Gson gson = new Gson();
        return gson.fromJson(link,SearchResFin.class);
    }
}