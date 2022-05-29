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
        System.out.println(link);
        link = goToNews(link);
        searchFinal = searchParse(link);
    }

    public void localNews(String source, String linkPart) throws IOException {
        String link = "https://newsapi.org/v2/top-headlines?q="+editor(source)+linkPart+api_key;
        link = goToNews(link);
        searchFinal = searchParse(link);
    }

    public String editor(String str){
        if(str.equals("")){return "today&";}else{
            str=str.replace(" ","+");
            str+="&";
            return str;}
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
    public String settingsSearch(String data_from, String data_to, String checkbox, String radio){
        String datePart = "", sortPart = "";
        int rad = Integer.parseInt(radio);
        if(checkbox == null){sortPart="";}
        if(data_from == null || data_to == null){datePart="";}

        switch (checkbox.length()) { // 3 - pop  4 - data   8 - both
            case (3):
                sortPart=radioMethod(rad);
                break;
            case (4):
                datePart=dateMethod(data_from,data_to);
                break;
            case (8):
                sortPart=radioMethod(rad);
                datePart= dateMethod(data_from,data_to);
                break;
            default:break;
        }
        return datePart+sortPart;
    }
    public String radioMethod(int rad)
    {
        switch (rad)
        {
            case(1):return "sortBy=popularity&";
            case(2):return "sortBy=relevancy&";
            case(3):return "sortBy=publishedAt&";
            default: return "";
        }
    };
    public String dateMethod(String data_from, String data_to)
    {
        if(data_from == null || data_to == null){return "";}else{return "from="+data_from+"&to="+data_to+"&";}
    };
}