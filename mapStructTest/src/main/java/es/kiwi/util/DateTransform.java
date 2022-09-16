package es.kiwi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTransform {

    public static LocalDateTime strToDate(String str){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse("2018-01-12 17:07:05",df);
    }
}
