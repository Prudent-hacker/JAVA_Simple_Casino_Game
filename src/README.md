Elite Casino System
Developed by: Brian Machayo

This is a modular gambling engine 
I built for my Object-Oriented Programming II (ACMP 224) course.
The goal was to move beyond basic scripts and create a professional,
"pluggable" architecture where I can add new games without rewriting the core
engine.

🧠 The Logic Behind the Build
I didn't just want a game that works; 
I wanted a system that follows real software engineering principles:

The Contract (Interfaces): I used a GamblingGame interface so
that the Main controller is "game-blind." It doesn't care if you're playing 
Slots or Dice; it just knows how to trigger a spin and check for wins.

Encapsulation (Data Safety): The Player class keeps your balance private. 
The game logic can't just change your money directly—it has to use specific 
methods, which is exactly how banking software is built.

Persistence & Auditing: The system uses a GameDataHandler to save 
your balance to save.txt. I also added a TransactionLogger that records every
bet to a transactions.csv file, so there's a permanent audit trail of every win 
and loss.

📂 Project Structure
Main.java: The "Brain" that manages the menu and the overall game loop.
GamblingGame.java: The interface that defines the rules every game must follow.
SlotMachine.java & DiceGame.java: Two different game implementations that plug 
into the system.
Player.java: Handles the user's identity and financial state.
GameDataHandler.java: Saves and loads your balance from the hard drive.
TransactionLogger.java: Writes every move to a CSV for history tracking.

🛠️ How to Clone and Run (For Other Learners)
If you want to test this or see how the architecture works, follow these steps:
Clone the Repo:

git clone https://github.com/your-username/elite-casino-java.git

Navigate to the folder:
cd elite-casino-java

Compile everything:

javac *.java
Launch the Game:

java Main
📈 What I Mastered
While building this, 
I figured out how to solve Incompatible Type errors by properly linking classes 
to interfaces. I also learned how to use Scope to make sure my objects 
didn't "die" inside if statements. 
It's a solid project that proves how Encapsulation, Polymorphism, 
and Persistence actually work in the real world.