import java.io.*;
import java.nio.file.*;

public class GameDataHandler {
    private static final String FILE_NAME = "save.txt";

    // Writes the balance to the file
    public void saveBalance(int balance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.err.println("Critical Error: Could not save data.");
        }
    }

    // Reads the balance from the file
    public int loadBalance() {
        try {
            String content = Files.readString(Path.of(FILE_NAME));
            return Integer.parseInt(content.trim());
        } catch (IOException | NumberFormatException e) {
            // If file doesn't exist or is corrupted, return a default starting balance
            return 500;
        }
    }
}