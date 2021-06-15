package com.russun.wordstat;

import com.russun.wordstat.Logic.Interfaces.HTMLConverter;
import com.russun.wordstat.Logic.Interfaces.HTMLLoader;
import com.russun.wordstat.Logic.Interfaces.WORDSCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class WordStatApplication implements CommandLineRunner {

    @Autowired
    HTMLLoader htmlLoader;
    @Autowired
    HTMLConverter htmlConverter;
    @Autowired
    WORDSCounter wordsCounter;

    public static void main(String[] args) {
        SpringApplication.run(WordStatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------Счетчик слов------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ссылку на сайт ");
        htmlLoader.setLink(scanner.nextLine());
        File loadedFile = htmlLoader.loadHtml();
        File convertedFile = htmlConverter.convertHtml(loadedFile);
        File resultFile = wordsCounter.countWords(convertedFile);
        System.out.println("------------------------------------");
    }
}
