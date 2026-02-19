public class Player {
    private String name;
    private int balance;

    public Player(String name, int initialBalance) {
        this.name = name;
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean canAfford(int amount) {
        return amount <= balance && amount > 0;
    }

    public void adjustBalance(int amount) {
        this.balance += amount; // Handles both wins (+) and losses (-)
    }

    public String getName() {
        return name;
    }
}