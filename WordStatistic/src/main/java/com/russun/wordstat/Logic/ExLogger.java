package com.russun.wordstat.Logic;

import com.russun.wordstat.Logic.Interfaces.ExceptionLogger;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

@Component
public class ExLogger implements ExceptionLogger {
    @Override
    public void logException(Exception e) {
        try {
            PrintStream filePrintStream = new PrintStream(new FileOutputStream("src/main/resources/Errors.txt",true));
            filePrintStream.println("----------" + DateFormatter.getFormattedDate() + "----------");
            filePrintStream.println(e.toString());
            filePrintStream.println(Arrays.toString(e.getStackTrace()));
            filePrintStream.println("------------------------------");
        } catch (IOException ignored) {
        }
    }
}
