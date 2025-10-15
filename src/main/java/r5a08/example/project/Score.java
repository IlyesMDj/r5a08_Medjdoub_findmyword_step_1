package r5a08.example.project;

public class Score {

    private final String correct;
    private Letter result = Letter.INCORRECT;
    private int position = -1; // Valeur par défaut indiquant qu'aucune position n'a été évaluée

    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter(int i) {
        // On retourne le résultat uniquement si la position demandée correspond à celle évaluée
        return (i == position) ? result : Letter.INCORRECT;
    }

    public void assess(int position, String attempt) {
        this.position = position;
        if (isCorrectLetter(position, attempt)) {
            result = Letter.CORRECT;
        } else if (isPartCorrectLetter(position, attempt)) {
            result = Letter.PART_CORRECT;
        } else {
            result = Letter.INCORRECT;
        }
    }

    private boolean isPartCorrectLetter(int position, String attempt) {
        char attemptedChar = attempt.charAt(position);
        // Vérifie si la lettre existe ailleurs dans le mot correct
        for (int i = 0; i < correct.length(); i++) {
            if (i != position && correct.charAt(i) == attemptedChar) {
                return true;
            }
        }
        return false;
    }



    private boolean isCorrectLetter(int position, String attempt) {
        return this.correct.charAt(position) == attempt.charAt(position);
    }
}