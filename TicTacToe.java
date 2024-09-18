import java.util.Scanner; // Importing Scanner for user input
import java.util.Random; // Importing Random for computer's random move selection


public class TicTacToe {

    public static void main(String[] args) {

        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the Tic-Tac-Toe board as a 2D array filled with spaces
        char[][] board = {{' ', ' ', ' '}, 
                          {' ', ' ', ' '}, 
                          {' ', ' ', ' '}};

        // Print the initial empty board before the game starts
        printBoard(board); 

        // Main game loop: keeps running until the game ends (win or tie)
        while (true) {
            playerTurn(board, scanner); // Player's turn
            if (isGameFinished(board)) { // Check if the game has ended after the player's turn
            break; // Exit the loop if the game is over
        }
        // Print the updated board after the player's move
        printBoard(board);

        computerTurn(board); // Computer's turn
        printBoard(board);
         // Check if the game has ended after the computer's turn
        if (isGameFinished(board)) {
            break; // Exit the loop if the game is over
        }
    }
    // Close the scanner once the game loop is done to avoid memory leaks
    scanner.close();
}

        // This method checks if the game has finished (win or tie)
        private static boolean isGameFinished(char[][] board) {
            // Check if the player (X) has won
            if (hasContestantWon(board, 'X')) {
                printBoard(board);
                System.out.println("Player wins!");
                return true; // Game is finished, return true
            }

             // Check if the computer (O) has won
            if (hasContestantWon(board, 'O')) {
                printBoard(board);
                System.out.println("Computer wins!");
                return true;
            }

             // Check if there are any empty spaces left, if so, the game is not over
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                   if (board[i][j] == ' ') {
                    return false; // Game is not over yet, return false
                   } 
                }
            }

            // If there are no empty spaces and no one has won, it's a tie
            printBoard(board);
            System.out.println("The game ended in a tie!");
            return true; // Game is finished, return true
        }

        // This method checks if a player (either 'X' or 'O') has won the game
        private static boolean hasContestantWon(char[][] board, char symbol) {
            // Check all possible winning conditions (rows, columns, diagonals)
            if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
               (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
               (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

               (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
               (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
               (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

               (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
               (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol)) {

                return true; // Player with 'symbol' has won
            }
               return false; // No winning condition met
                                  
        }

        // This method handles the computer's turn, where it picks a random valid move
        private static void computerTurn(char [] [] board) {
        Random rand = new Random(); // Random object for generating random moves
        int computerMove; 
        // Keep trying until the computer picks a valid move
        while (true) {
        computerMove = rand.nextInt(9) + 1; // Random number between 1 and 9
        if (isValidMove(board, Integer.toString(computerMove))) {
            break; // Exit the loop if the move is valid
        }
    }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove),'O'); // Place the computer's move on the board
    }
    
    
   

     // This method checks if a move is valid (i.e., if the chosen cell is empty)
    private static boolean isValidMove (char[][] board, String position) {
    switch(position) {
        case "1":
            return (board[0][0] == ' '); // Top-left
        case "2":
            return (board[0][1] == ' '); // Top-middle
        case "3":
                return (board[0][2] == ' '); // Top-right
        case "4":
            return (board[1][0] == ' '); // Middle-left
        case "5":
            return (board[1][1] == ' '); // Center
        case "6":
            return (board[1][2] == ' '); // Middle-right
        case "7":
            return (board[2][0] == ' '); // Bottom-left
        case "8":
            return (board[2][1] == ' '); // Bottom-middle
        case "9":
            return (board[2][2] == ' '); // Bottom-right
        default:
            return false;
        }
    }
    

        // This method handles the player's turn    
        private static void playerTurn(char[][] board, Scanner scanner) {      
        String userInput;
        // Keep asking the player for a move until a valid move is chosen
        while (true) {
        System.out.println("Where would you like to play? (1-9)");
        userInput = scanner.nextLine(); // Read the player's input
        if (isValidMove(board, userInput)) {
            break; // Exit loop if the move is valid 
        } else {
            System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');// Place the player's move on the board
        
    }
        

        // This method places a move on the board at the specified position
        private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                return;
            }
        }

                  
        // This method prints the current state of the Tic-Tac-Toe board
        private static void printBoard(char[][] board) {                  
        System.out.println(board[0][0] + "|" + board [0][1] +"|" + board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board [1][1] +"|" + board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board [2][1] +"|" + board[2][2] );
        
    }
}

    

