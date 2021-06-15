package com.russun.wordstat.Logic;

import org.springframework.stereotype.Component;

@Component
public class DirectoryNameGenerator {
    private static String lastDirName;

    public static String getNewDirectoryName(){
        lastDirName = "src/main/resources/" + DateFormatter.getFormattedDate();
        return lastDirName;
    }

    public static String getLastDirName() {
        return lastDirName;
    }
}
