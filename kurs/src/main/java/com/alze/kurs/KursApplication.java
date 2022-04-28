package com.alze.kurs;

import org.apache.coyote.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Function;

@SpringBootApplication
public class KursApplication {

	public static void main(String[] args) throws IOException {

		String NEWS_SOURCE = "";

		Scanner console = new Scanner(System.in);
		NEWS_SOURCE= console.nextLine();

		Search req = new Search("7d1f27c7099944e99b8fbb618f7cb2e7");
		req.worldNews(NEWS_SOURCE, "&sortBy=popularity&language=ru&apiKey=");
		//req.localNews(NEWS_SOURCE,"country=ru&apiKey=");

	}
}
