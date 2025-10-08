package r5a08.example.project;

public class Score {

    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return result;
    }

    public void assess(int position, String attempt) {
        if (this.correct.charAt(position)==attempt.charAt(position)){
            result = Letter.CORRECT;
        }
    }
}