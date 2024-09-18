import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Create a scanner object to read input

        while (true) {
        //Array for rock, paper, scissors moves
        String[] rps = {"r", "p", "s"};
        // Randomly select the computer's move
        String computerMove = rps[new Random().nextInt(rps.length)];

        
        String playerMove; // Declare a variable to store the player's move

        //Get the player's move
        while(true){
        System.out.println("Please enter your move (r, p, or s)");
        playerMove = scanner.nextLine();
        //Check if the player's move is valid
        if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
            break;
        }
        System.out.println(playerMove + " is not a valid move.");
    }
    //Print the moves of both player and computer
    System.out.println("Computer played: " + computerMove);
    
    //Check if the game is a tie
    if (playerMove.equals(computerMove)) {
        System.out.println("The game was a tie!");
    }
    //If player chooses rock
    else if (playerMove.equals("r")) {
       if (computerMove.equals("p")) {
            System.out.println("You lose!");
       } else if (computerMove.equals("s")) {
        System.out.println("You win!");
       }
    }
    //If player chooses paper
       else if (playerMove.equals("p")) {
        if (computerMove.equals("r")) {
             System.out.println("You win!");
        } else if (computerMove.equals("s")) {
         System.out.println("You lose!");
        }
       }
    //If player chooses scissors
       else if (playerMove.equals("s")) {
        if (computerMove.equals("p")) {
             System.out.println("You win!");
        } else if (computerMove.equals("r")) {
         System.out.println("You lose!");
        }
       }
       
      //Ask if the user wants to play again
      System.out.println("Want to play again (y/n)");
      String playAgain = scanner.nextLine();

      //Logic to break the outer loop if the user does not want to play again
      if (!playAgain.equals("y")) {
        break; //Exit the loop if the player does not want to continue
      }
    }

    //Close the scanner at the end of the method, after the loop
    scanner.close();
}
}