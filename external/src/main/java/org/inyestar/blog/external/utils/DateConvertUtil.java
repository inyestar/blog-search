package org.inyestar.blog.external.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateConvertUtil {
    public static LocalDateTime convertKakaoDate(String dateSource) {
        return LocalDateTime.parse(dateSource, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    }

    public static LocalDateTime convertNaverDate(String dateSource) {
        return LocalDateTime.of(
            LocalDate.parse(dateSource, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            LocalTime.MIDNIGHT
        );
    }
}
