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

    @Test
    public void should_check_one_part_correct_letter() {
        // Arrange
        Word word = new Word("EA"); // Mot à deviner
        Score score = word.guess("AE"); // Lettre correcte mal placée

        // Act
        Letter actual = score.letter(0); // 'A' est à la position 0 dans "AE"
        Letter expected = Letter.PART_CORRECT;

        // Assert
        assertLetterEquals(expected, actual);
    }

}
