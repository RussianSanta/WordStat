package com.russun.wordstat.Logic;

import com.russun.wordstat.Logic.Interfaces.ExceptionLogger;
import com.russun.wordstat.Logic.Interfaces.WORDSCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class WordsCounter implements WORDSCounter {
    @Autowired
    FileReader fileReader;
    @Autowired
    ExceptionLogger exceptionLogger;
    public File countWords(File convertedHTML){
        File resultFile = new File(DirectoryNameGenerator.getLastDirName() + "/Words.txt");
        Map<String, Integer> countOfWords = new HashMap<>();

        if (convertedHTML == null) {
            System.out.println("Ошибка при подсчете слов.");
            return null;
        }

        String text = fileReader.readFile(convertedHTML);
        String[] words = text.split("[\\s.,\"!?:;\\n\\r\\t()'\\[\\]\\-{}=+—@<>\\\\]+");

        for (String word:words) {
            word = word.toLowerCase();
            if (countOfWords.get(word) == null) countOfWords.put(word,1);
            else {
                countOfWords.put(word,countOfWords.get(word)+1);
            }
        }

        try {
            PrintStream filePrintStream = new PrintStream(new FileOutputStream(resultFile,true));
            countOfWords.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(filePrintStream::println);
        } catch (IOException e) {
            exceptionLogger.logException(e);
        }

        System.out.println("Успех. Файл с результатом - " + resultFile.getAbsolutePath());

        return resultFile;
    }
}
