package com.russun.wordstat.Logic;

import com.russun.wordstat.Logic.Interfaces.ExceptionLogger;
import com.russun.wordstat.Logic.Interfaces.HTMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

@Component
public class HtmlLoader implements HTMLLoader {
    private String link;
    private String dirName;
    @Autowired
    private ExceptionLogger exceptionLogger;

    public File loadHtml() {
        System.out.println("Загрузка файла...");
        try {
            File dir = new File(dirName);
            dir.mkdir();
            File outputFile = new File(dirName + "/index.html");

            URL url = new URL(link);

            InputStream inputStream = url.openStream();
            Files.copy(inputStream,outputFile.toPath());

            System.out.println("Загрузка файла завершена. Файл - " + outputFile.getAbsolutePath());

            return outputFile;
        } catch (Exception e){
            exceptionLogger.logException(e);
        }
        System.out.println("Ошибка при загрузке файла.");
        return null;
    }

    public void setLink(String link) {
        this.link = link;
        this.dirName = DirectoryNameGenerator.getNewDirectoryName();
    }
}
