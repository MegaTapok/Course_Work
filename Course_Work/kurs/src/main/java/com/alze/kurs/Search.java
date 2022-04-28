package com.alze.kurs;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;

public class Search{

    static String api_key;

    public Search(String api_key){
        this.api_key = api_key;
    }

    public void worldNews(String source, String linkpart ) throws IOException {

        String link = "https://newsapi.org/v2/everything?q="+editor(source)+linkpart+api_key;
        ArrayList<String> urls = new ArrayList<>();
        System.out.println(link);
        link = gotonews(link);
        urls = geturl(link);
        for(int i = 0; i <5; i++) {
            link = gotonews(urls.get(i));
        }
    }

    public void localNews(String source, String linkpart) throws IOException {
        String link = "https://newsapi.org/v2/top-headlines?"+linkpart+api_key;
        ArrayList<String> urls = new ArrayList<>();
        System.out.println(link);
        link = gotonews(link);
        urls = geturl(link);
        //link = gotonews(link);
    }

    String gotonews(String link) throws IOException {
        URL url = new URL(link);
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        //System.out.println(str);
        //writer(str);
        return str;
    }

    ArrayList<String> geturl(String str){
        int urlindex,firstindex,secondindex,findindex=0;
        String newurl = "";
        ArrayList<String> urls = new ArrayList<>();
        for(int i = 0; i <5; i++) {
            urlindex = str.indexOf("url",findindex);
            firstindex = str.indexOf("h", urlindex);
            secondindex = str.indexOf(",", firstindex);
            findindex = secondindex;
            newurl = str.substring(firstindex, secondindex - 1);
            System.out.println(newurl);
            urls.add(newurl);
        }
        return urls;
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
    /*void writer(String str) throws IOException {
        //C:\Users\l\IdeaProjects\Course_Work\txt
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\l\\IdeaProjects\\Course_Work\\txt\\html_str.txt");
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }*/
}
