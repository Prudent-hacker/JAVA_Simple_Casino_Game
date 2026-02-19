import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameDataHandler dataHandler = new GameDataHandler();
        TransactionLogger logger = new TransactionLogger();

        // 2. Load Persisted State
        int savedBalance = dataHandler.loadBalance();
        Player user = new Player("Mr Code", savedBalance);

        System.out.println("================================");
        System.out.println("   WELCOME TO ELITE CASINO 2.0  ");
        System.out.println("================================");
        System.out.println("Developed by BRIAN MACHAYO");
        System.out.println("User: " + user.getName());
        System.out.println("Starting Balance: $" + user.getBalance());

        System.out.println("\nSelect your game:");
        System.out.println("1. Slot Machine (High Risk)");
        System.out.println("2. Dice Game (Steady Odds)");
        System.out.print("Choice: ");


        GamblingGame game;

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            // ASSIGN without re-declaring the type
            game = (choice == 2) ? new DiceGame() : new SlotMachine();
        } else {
            System.out.println("Invalid choice. Defaulting to Slots.");
            scanner.next(); // Clear buffer
            game = new SlotMachine();
        }

        System.out.println("--- " + game.getClass().getSimpleName() + " Loaded ---");
        System.out.println(game.getRules());

        while (user.getBalance() > 0) {
            System.out.println("\nCurrent Balance: $" + user.getBalance());
            System.out.print("Enter bet amount (0 to Save & Quit): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
                continue;
            }

            int bet = scanner.nextInt();

            if (bet == 0) break;

            if (!user.canAfford(bet)) {
                System.out.println(" Insufficient funds. kindly top up!");
                continue;
            }


            user.adjustBalance(-bet);


            String[] result = game.play();
            System.out.println("\nResult: [ " + String.join(" | ", result) + " ]");

            int winnings = game.getWinnings(result, bet);

            if (winnings > 0) {
                System.out.println(">>> WINNER! You received $" + winnings);
                user.adjustBalance(winnings);
            } else {
                System.out.println(">>> you Failed try again!.");
            }
            logger.log(game.getClass().getSimpleName(), bet, winnings, user.getBalance());
        }


        System.out.println("\n================================");
        System.out.println("Saving progress to save.txt...");
        dataHandler.saveBalance(user.getBalance());
        System.out.println("Session ended. Final Balance: $" + user.getBalance());
        System.out.println("Thank you for playing, " + user.getName());
        System.out.println("================================");
        System.out.println("remember to folk and star the github repo ");
        System.out.println("prudent-hacker -> github handle");

        scanner.close();
    }
}