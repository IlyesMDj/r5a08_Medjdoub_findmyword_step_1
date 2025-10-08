package r5a08.example.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        // Arrange
        Word word = new Word("E");

        // Act
        Score actual = word.guess("B");

        // Assert
        assertEquals(Letter.INCORRECT, actual.letter(0));
    }
}
