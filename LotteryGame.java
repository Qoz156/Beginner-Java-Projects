import java.util.ArrayList; // Import ArrayList class, which allows us to store a resizable list of items
import java.util.List; // Import List interface, which is a more general type of collection than ArrayList
import java.util.Random; // Import Random class, used to generate random numbers 
import java.util.Scanner; // Import Scanner class, which allows us to read user input

public class LotteryGame {
    public static void main(String[] args) {

        // Create an empty list to store the 6 randomly generated winning numbers
        List<Integer> winningNumbers = new ArrayList<>();

        // Create a Random object to generate random numbers
        Random random = new Random();

        // This loop will run 6 times to generate 6 unique random winning numbers 
        for (int i = 0; i < 6; i++) {
            while (true) { // Infinite loop to ensure we don't add duplicate numbers
            int winningNumber = random.nextInt(49) + 1; // Generate a random number from 1-49
            if (!winningNumbers.contains(winningNumber)) { // Check if the number is already in the list
                winningNumbers.add(winningNumber); // If not, add it to the list
                break; // Break out of loop once a valid number is added
            }
            }
        }

        // Uncomment the line below if you want to see the generated winning numbers while testing
        // System.out.println("Winning numbers: " + winningNumbers);
        

        // Prompt the user to enter their guesses
        System.out.println("Please enter your 6 numbers between 1 and 49");

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Create a list to store the user's guessed numbers
        List<Integer> guessedNumbers = new ArrayList<>();

        // This loop allows the user to input 6 numbers
        for (int i = 0; i < 6; i++) {
            // Display the numbers entered so far
            System.out.println("Your current numbers are: " + guessedNumbers);
            // Prompt the user to enter a number
            System.out.println("Please enter a number (1-49):");

            // Infinite loop to validate the user's input 
            while (true) {
                try {
                    String numberString = scanner.nextLine(); // Read user input as a string 
                    int number = Integer.parseInt(numberString); // Convert the input to an integer

                    // Check if the number is within the range 1-49
                    if (number >= 1 && number <=49) {
                        if (!guessedNumbers.contains(number)) { // Check if the number was already guessed
                        guessedNumbers.add(number); // Add the number to the list of guesses
                        break; // Break out of the loop ince a valid number is entered
                    
                        } else {
                            // Message to indicate duplicate guess
                        System.out.println("You have already guessed " + number + ". Please enter a different number.");

                        }
                    } else {
                        // Message to indicate out of range numbers
                        System.out.println(number + " is not between 1 and 49. Please try again");
                    }
                }
            
                // This block catches invalid inputs (e.g. letters or symbols)
                catch (NumberFormatException nfe) {
                    System.out.println("Dude, that's not a number be for real");
                }
            }
        }

        // Display the winning numbers and the numbers guessed by the user
        System.out.println("The winning numbers were: " + winningNumbers);
        System.out.println("Your numbers are: " + guessedNumbers);

        // This line modifies the guessedNumbers list to keep only the numbers that match the winning numbers
        guessedNumbers.retainAll(winningNumbers);
        System.out.println("Your matched numbers are: " + guessedNumbers);

        // Check if the user has guessed all 6 winning numbers correctly
        // If guessedNumbers contains all the numbers from winningNumbers, the user wins
        // This means the player must guess all 6 numbers correctly to win
        if (guessedNumbers.containsAll(winningNumbers)) {
            System.out.println("You won! Well done you guessed all numbers correctly!");
        }
        else {
            System.out.println("Sorry, you lost. Not surprising!");
        }
        // Close the scanner object after the game is over to free resources
        scanner.close();
    
}
}


