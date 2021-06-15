package com.russun.wordstat.Logic;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String getFormattedDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a");
        return dateFormat.format(date);
    }
}
