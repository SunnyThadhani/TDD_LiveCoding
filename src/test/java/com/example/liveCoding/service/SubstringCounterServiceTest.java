package com.example.liveCoding.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SubstringCounterServiceTest {

    @Autowired
    private SubstringCounterService substringCounterService;

    @Test
    void testCountOccurrence_WithValidInput_ShouldReturnCorrectCount() {
        String inputString = "we are going make a dent in the universe";
        String query = "in";
        int expectedOccurrence = 2;

        int actualOccurrence = substringCounterService.countOccurrences(inputString, query);

        assertThat(actualOccurrence).isEqualTo(expectedOccurrence);
    }

    @Test
    public void testCountOccurrences_WithEmptyQuery_ShouldThrowException() {
        String text = "we are going make a dent in the universe";
        String query = "";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> substringCounterService.countOccurrences(text, query)
        );
        assertTrue(thrown.getMessage().contains("Text and query must not be null or empty."));
    }

    @Test
    public void testCountOccurrences_WithNullText_ShouldThrowException() {
        String query = "in";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> substringCounterService.countOccurrences(null, query)
        );
        assertTrue(thrown.getMessage().contains("Text and query must not be null or empty."));
    }

    @Test
    public void testCountOccurrences_WithNullQuery_ShouldThrowException() {
        String text = "we are going make a dent in the universe";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> substringCounterService.countOccurrences(text, null)
        );
        assertTrue(thrown.getMessage().contains("Text and query must not be null or empty."));
    }
}
