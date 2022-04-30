package com.alze.kurs;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;

public class Search{

    static String api_key;

    static ArrayList<String> pick_url = new ArrayList<>();
    static ArrayList<String> post_url = new ArrayList<>();

    public Search(String api_key){
        this.api_key = api_key;
    }

    public void worldNews(String source, String linkpart ) throws IOException {
        int size=0;
        String link = "https://newsapi.org/v2/everything?q="+editor(source)+linkpart+api_key;
        System.out.println(link);
        link = gotonews(link);
        geturl(link);
        size=post_url.size();
        for(int i = 0; i <size; i++) {
            //ссылка на статью
        }
        size=pick_url.size();
        for(int i = 0; i <size; i++) {
            //ссылка на превью
        }

    }

    public void localNews(String source, String linkpart) throws IOException {
        String link = "https://newsapi.org/v2/top-headlines?"+linkpart+api_key;
        ArrayList<String> urls = new ArrayList<>();
        System.out.println(link);
        link = gotonews(link);
        geturl(link);
        //link = gotonews(link);
    }

    String gotonews(String link) throws IOException {
        URL url = new URL(link);
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        //System.out.println(str);
        writer(str);
        return str;
    }

    void geturl(String str){
        int urlindex,firstindex,secondindex,findindex=0;
        String newurl = "", results_str;
        int results = 0;
        boolean parity = true;

        firstindex = str.indexOf(":");
        firstindex = str.indexOf(":", firstindex+1);
        secondindex = str.indexOf(",",firstindex);
        results_str = str.substring(firstindex+1,secondindex);
        results = Integer.parseInt(results_str);
        System.out.println(results);

        for(int i = 0; i <results*2; i++) {
            urlindex = str.indexOf("url",findindex);
            firstindex = str.indexOf("h", urlindex);
            secondindex = str.indexOf(",", firstindex);
            findindex = secondindex;
            newurl = str.substring(firstindex, secondindex - 1);
            System.out.println(newurl);
            if(parity) {
                post_url.add(newurl);
                parity = false;
            }else{
                pick_url.add(newurl);
                parity = true;
            }
        }
    }
    /*void getdomain(String str){
        int urlindex = str.indexOf("url");
        int firstindex = str.indexOf("//",urlindex);
        int secondindex = str.indexOf(",",firstindex);
        String domain = str.substring(firstindex+2,secondindex-1);
        System.out.println(domain);
    }*/
    String editor(String str){
        String edit_str = str.replace(" ","+");
        return edit_str;
    }
    void writer(String str) throws IOException {
        //C:\Users\l\Documents\GitHub\Course_Work\txt\html_str
        FileOutputStream fileOutputStream = new FileOutputStream("html_str.txt");
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
}
