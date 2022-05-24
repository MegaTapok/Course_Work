package com.alze.kurs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


// Класс-запуск приложения
@SpringBootApplication
public class KursApplication {

	public static void main(String[] args) throws IOException {
		Desktop d = Desktop.getDesktop();
		SpringApplication.run(KursApplication.class, args);
		System.out.println("Вызов");

		try {
			d.browse(new URI("http://localhost:8081/"));
		} catch (IOException | URISyntaxException e2) {
			e2.printStackTrace();
		}
	}
}
