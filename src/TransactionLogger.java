import java.io.*;
import java.time.LocalDateTime;

public class TransactionLogger {
    private static final String LOG_FILE = "transactions.csv";

    public void log(String gameName, int bet, int win, int finalBalance) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE, true)))) {
            String timestamp = LocalDateTime.now().toString();
            // Format: Time, Game, Bet, Result, Balance
            out.printf("%s, %s, %d, %d, %d%n", timestamp, gameName, bet, win, finalBalance);
        } catch (IOException e) {
            System.err.println("Audit Error: Could not write to log file.");
        }
    }
}