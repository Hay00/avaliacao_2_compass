package avaliacao2.questao10;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmoticonsEvaluator {
    private String message;
    private int score;


    public EmoticonsEvaluator(String message) {
        this.message = message;
        this.score = 0;
    }

    public String evaluateMessage() {
        String smileRegex = "(:-\\))";
        String sadRegex = "(:-\\()";
        Matcher smileMatcher = Pattern.compile(smileRegex).matcher(this.message);
        Matcher sadMatcher = Pattern.compile(sadRegex).matcher(this.message);

        while (smileMatcher.find()) this.score++;
        while (sadMatcher.find()) this.score--;

        if (this.score == 0) return "Neutro";
        if (this.score > 0) return "Divertido";
        return "Chateado";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
