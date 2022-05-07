package com.alze.kurs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


// Класс-запуск приложения
@SpringBootApplication
public class KursApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(KursApplication.class, args);

	}
}
