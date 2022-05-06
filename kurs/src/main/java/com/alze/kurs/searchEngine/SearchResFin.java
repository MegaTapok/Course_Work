package com.alze.kurs.searchEngine;

import java.util.ArrayList;

public class SearchResFin {


    public ArrayList<SearchResultsList> getArticles() {
        return articles;
    }
    public void setArticles(ArrayList<SearchResultsList> articles) {
        this.articles = articles;
    }

    private ArrayList<SearchResultsList> articles =new ArrayList<>();

    public Long getTotalResults() {
        return totalResults;
    }

    private Long totalResults;

    @Override
    public String toString() {
        return "SearchResFin{" +
                "articles=" + articles +
                '}';
    }
}

