import java.util.Random; // Import the Random class to generate random numbers
import java.util.Scanner; // Import the Scanner class to read inpput from the user

public class NumberGuessingGame {
    
    public static void main(String[] args) {

        // Create a Random object to generate random numbers
        Random rand = new Random();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);


        //  Generate a random number between 1 and 100 (inclusive)
        // rand.nextInt(100) generates a number between 0 and 99, so we add 1 to get 1-100
        int randomNumber = rand.nextInt(100) +1;

        // If you want to test the game by knowing the number beforehand, uncomment this line:
        // System.out.println("Random number is " + randomNumber); // Cheat code for testing

        // Variable to count the number of tries the player takes to guess the number
        int tryCount = 0;

        // Start a loop that will run until the player guesses the correct number
        while(true) {
            // prompt the player to enter their guess 
        System.out.println("Enter your guess (1-100):");
        
        // Read the player's guess as an integer
        int playerGuess = scanner.nextInt();

        // Increment the try count by 1 each time the player makes a guess
        tryCount++;

        // Check if the player's guess is equal to the random number
        if (playerGuess == randomNumber) {
            // If the guess is correct, print a success message and the number of tries
            System.out.println("Correct! You Win!");
            System.out.println("It took you " + tryCount + " tries");
            // Exit the loop since the game is won
            break;
        }
        // Check if the player's guess is lower than the random number
        else if(randomNumber > playerGuess) {
            System.out.println("Nope! The number is higher. Guess again.");
        }

        // Check if the player's guess is higher than the random number
        else if(randomNumber < playerGuess) {
            System.out.println("Nope! The number is lower. Guess again.");
        }



    }
    // Close the scanner after the game is done to free up system resources
    scanner.close();
}
}

// Enhancement ideas, do in future: 
// If an integer is not inserted, handle cases where a non-integer is added
// Add a feature to limit the number of guesses
// Create various difficulty levels
// Track highscores 
// Provide hints if the player is close
// Play again feature
// Create multiplayer mode