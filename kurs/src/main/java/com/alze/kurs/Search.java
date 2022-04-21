package com.alze.kurs;


import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.net.URL;

public class Search{

    static String api_key;

    public Search(String api_key){
        this.api_key = api_key;
    }

    public void worldNews(String source, String linkpart ) throws IOException {
        String link = "https://newsapi.org/v2/everything?q="+source+linkpart+api_key;
        System.out.println(link);
        link = gotonews(link);
        link = geturl(link);
        //link = gotonews(link);
    }

    public void localNews(String source, String linkpart) throws IOException {
        String link = "https://newsapi.org/v2/top-headlines?"+linkpart+api_key;
        System.out.println(link);
        link = gotonews(link);
        link = geturl(link);
        //link = gotonews(link);
    }

    String gotonews(String link) throws IOException {
        URL url = new URL(link);
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
        return str;
    }

    String geturl(String str){
        int urlindex = str.indexOf("url");
        int firstindex = str.indexOf("h",urlindex);
        int secondindex = str.indexOf(",",firstindex);
        String newurl = str.substring(firstindex,secondindex-1);
        System.out.println(newurl);
        return newurl;
    }
    /*void getdomain(String str){
        int urlindex = str.indexOf("url");
        int firstindex = str.indexOf("//",urlindex);
        int secondindex = str.indexOf(",",firstindex);
        String domain = str.substring(firstindex+2,secondindex-1);
        System.out.println(domain);
    }*/
}
