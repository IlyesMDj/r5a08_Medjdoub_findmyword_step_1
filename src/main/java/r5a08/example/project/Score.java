package r5a08.example.project;

public class Score {
    private final Letter[] letters;
    private final String secret;

    public Score(String secret) {
        this.secret = secret;
        this.letters = new Letter[secret.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = Letter.INCORRECT;
        }
    }

    // Évalue la lettre d'index 'index' à partir de la tentative 'attempt'
    public void assess(int index, String attempt) {
        if (index < 0 || index >= letters.length) return;
        if (attempt == null || attempt.length() <= index) {
            letters[index] = Letter.INCORRECT;
            return;
        }
        letters[index] = (attempt.charAt(index) == secret.charAt(index))
                ? Letter.CORRECT
                : Letter.INCORRECT;
    }

    // Retourne le score de la lettre à l'index donné
    public Letter letter(int index) {
        return letters[index];
    }
}