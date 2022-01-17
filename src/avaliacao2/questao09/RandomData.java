package avaliacao2.questao09;

import java.util.Random;

public class RandomData {
    private final Random random;

    public RandomData() {
        this.random = new Random();
    }

    public String getString() {
        int start = 97;
        int end = 122;
        int maxLen = 10;

        return this.random.ints(start, end + 1)
                .limit(maxLen)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public double getDouble() {
        double max = 10;
        double min = 0.5;
        return min + (max - min) * this.random.nextDouble();
    }
}
