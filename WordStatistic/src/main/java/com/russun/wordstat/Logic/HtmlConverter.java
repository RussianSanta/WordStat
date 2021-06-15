package com.russun.wordstat.Logic;

import com.russun.wordstat.Logic.Interfaces.ExceptionLogger;
import com.russun.wordstat.Logic.Interfaces.HTMLConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class HtmlConverter implements HTMLConverter {
    @Autowired
    private ExceptionLogger exceptionLogger;

    public File convertHtml(File inputFile){
        System.out.println("Обработка файла...");
        if (inputFile != null)
        try {
            Document doc = Jsoup.parse(inputFile,"UTF-8");
            String text = doc.text();

            File outputFile = new File(DirectoryNameGenerator.getLastDirName() + "/convertedHTML.txt");
            new FileWriter(outputFile).write(text);

            System.out.println("Обработка файла завершена. Файл - " + outputFile.getAbsolutePath());

            return outputFile;
        } catch (IOException e) {
            exceptionLogger.logException(e);
        }
        System.out.println("Ошибка в обработке файла");
        return null;
    }
}
