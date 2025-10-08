package r5a08.example.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre
        Score score = word.guess("B");


        // Act
        Letter actual = score.letter(0);
        Letter expected = Letter.INCORRECT;

        // Assert
        assertLetterEquals(actual, expected);
    }

    private void assertLetterEquals(Letter actual, Letter expected) {
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void should_check_one_correct_letter(){
        // Act
        Word word = new Word("E"); // Le mot a déviner fait une lettre
        Score score = word.guess("E");

        // Arrange

        Letter actual = score.letter(0);
        Letter expected = Letter.CORRECT;

        // Assert
        assertLetterEquals(actual, expected);
    }
}
