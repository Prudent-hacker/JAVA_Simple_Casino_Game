import java.util.Random;

//polymorphism
public class SlotMachine implements GamblingGame {
    private final String[] symbols = {"🍎", "🔔", "💎", "7️⃣"};
    private final Random random = new Random();

    @Override
    public String getRules() {
        return """
        === SLOT MACHINE RULES ===
        1. Three of a kind wins!
        2. Multipliers:
           - 7️⃣ : 50x your bet
           - 💎 : 20x your bet
           - 🔔 : 10x your bet
           - Others: 5x your bet
        """;
    }
    @Override
    public String[] play() {
        String[] row = new String[3];
        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }

    @Override
    public int getWinnings(String[] result, int bet) {
        if (result[0].equals(result[1]) && result[1].equals(result[2])) {
            return switch (result[0]) {
                case "7️⃣" -> bet * 50;
                case "💎" -> bet * 20;
                case "🔔" -> bet * 10;
                default -> bet * 5;
            };
        }
        return 0;
    }
}