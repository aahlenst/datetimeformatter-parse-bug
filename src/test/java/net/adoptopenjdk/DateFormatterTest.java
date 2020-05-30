package net.adoptopenjdk;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class DateFormatterTest {
    @Test
    public void parsePattern() {
        String recordDate = "5/2/2019 1:2:3 AM";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy h[h]:m[m]:s[s] a");
        LocalDateTime result = LocalDateTime.parse(recordDate, formatter);
        assertEquals(LocalDateTime.of(2019, 5, 2, 1, 2, 3), result);
    }
}
