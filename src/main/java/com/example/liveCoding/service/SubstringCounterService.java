package com.example.liveCoding.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SubstringCounterService {

    public int countOccurrences(String text, String query) {
        if (text == null || query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Text and query must not be null or empty.");
        }
        Pattern pattern = Pattern.compile(Pattern.quote(query));
        Matcher matcher = pattern.matcher(text);

        int occurrencesCount = 0;
        while (matcher.find()) {
            occurrencesCount++;
        }

        return occurrencesCount;
    }
}
