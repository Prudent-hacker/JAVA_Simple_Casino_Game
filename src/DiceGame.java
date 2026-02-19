import java.util.Random;

public class DiceGame implements GamblingGame {
    private final Random random = new Random();

    @Override
    public String getRules() {
        return """
        === DICE GAME RULES ===
        1. Roll two dice (1-6).
        2. If you roll a DOUBLE (e.g., 4 and 4), you win 4x your bet.
        3. If the SUM is exactly 7, you win 2x your bet.
        4. Otherwise, the house takes the bet.
        """;
    }

    @Override
    public String[] play() {
        return new String[] {
                String.valueOf(random.nextInt(6) + 1),
                String.valueOf(random.nextInt(6) + 1)
        };
    }

    @Override
    public int getWinnings(String[] result, int bet) {
        int d1 = Integer.parseInt(result[0]);
        int d2 = Integer.parseInt(result[1]);
        if (d1 == d2) return bet * 4;
        if (d1 + d2 == 7) return bet * 2;
        return 0;
    }
}