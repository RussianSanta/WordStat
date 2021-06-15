package com.russun.wordstat.Logic;

import com.russun.wordstat.Logic.Interfaces.ExceptionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader {
    @Autowired
    private ExceptionLogger exceptionLogger;

    public String readFile(File file){
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = br.readLine()) != null){
                text += line + "\n";
            }
        } catch (IOException e) {
            exceptionLogger.logException(e);
        }
        return text;
    }
}
