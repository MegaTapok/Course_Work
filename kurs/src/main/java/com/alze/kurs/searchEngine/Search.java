package com.alze.kurs.searchEngine;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.net.URL;

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
        String link = "https://newsapi.org/v2/top-headlines?"+editor(source)+linkPart+api_key;
        link = goToNews(link);
        searchFinal = searchParse(link);
    }

    private String editor(String str){
        return str.replace(" ","+");
    }

    private String goToNews(String link) throws IOException {
        URL url = new URL(link);
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        return new String(buffer);
    }

    private SearchResFin searchParse(String link) {
        Gson gson = new Gson();
        return gson.fromJson(link,SearchResFin.class);
    }
}