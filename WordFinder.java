import java.io.BufferedReader; // Import class for reading text from a file efficiently
import java.io.IOException; // Import class for handling input/output exceptions
import java.io.FileReader; // Import class for reading files
import java.util.Scanner; // Import class for reading user input
import java.util.HashMap; // Import class for hash map implementation
import java.util.Map; // Import class for map interface

public class WordFinder { // Start of the class 
// Start of the method 
    public static void main(String[] args) throws IOException { 

        // Create a Scanner object to read input from the user
    Scanner scanner = new Scanner(System.in);
    // Prompt the user to enter a pool of letters
    System.out.println("Please enter the pool of letters");
    // Read the entire line of input from the user and convert it to uppercase
    String letters = scanner.nextLine().toUpperCase();

    
    // Call the method getCharacterCountMap to create a map of character counts from the input letters
    Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

    // Specify the path to the dictionary file
        BufferedReader reader = new BufferedReader(new FileReader("/home/qozfahussain/dictionary.txt")); // Update this path based on your file location

        // Print a message indicating that possible words will be listed
        System.out.println("All possible words you can make with those letters:");

        // Loop through each line in the dictionary file
        // reader.readLine() reads a line from the file. If it's not null, it continues; otherwise, the loop ends
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) { 

            // Create a map of character counts for the current word
            // This helps in comparing the count of characters in the word with the available letters
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);
            
            // Assume initially that the current word can be formed with the letters
            boolean canMakeCurrentWord = true;
            // Loop through each character in the current word's character count map
            for (Character character : currentWordMap.keySet()) { 
                 // Get the count of the current character in the current word
                int currentWordCharCount = currentWordMap.get(character);

                // Get the count of the current character from the letters pool
                 // If the character is not in the letters pool, use 0
                int lettersCharCount = lettersCountMap.containsKey(character) ?
                                        lettersCountMap.get(character) : 0;
             // If the current word requires more of a character than is available in the pool
                if (currentWordCharCount > lettersCharCount) { 
                    // Set flag to false as the word cannot be formed
                    canMakeCurrentWord = false;
                     // Exit the loop as we already know the word cannot be made
                    break;
                } 
            } 
        
            // After checking all characters, if the flag is still true, print the word
            // This means the current word can be made with the available letters
            if (canMakeCurrentWord) { 
                System.out.println(currentWord);
            } 

  

        } 

        // Close the Scanner object to release system resources
        // Close the BufferedReader object to release system resources
        scanner.close();
        reader.close();

        
    } // Closing the bracket for the main method
        
    
    // Method definition for getCharacterCountMap
    // This method takes a String of letters and returns a map of characters to their counts
    private static Map<Character, Integer> getCharacterCountMap(String letters) { // start of method

        // Create a HashMap to store the count of each character
        Map<Character, Integer> lettersCountMap = new HashMap<>();
    
         // Loop through each character in the input string "letters"
        // The loop will run from 0 to the length of the string - 1
        for (int i = 0; i < letters.length(); i++) { // Start of the for loop

             // Get the character at the current index
            char currentChar = letters.charAt(i);
             
            // Check if the map already contains the current character
             // If it does, get the current count; otherwise, default to 0
            int count = lettersCountMap.containsKey(currentChar) ?
                        lettersCountMap.get(currentChar) : 0;

            // Update the map with the new count for the current character
            // Increment the count by 1
            lettersCountMap.put(currentChar, count + 1);
        } // End of the for loop

        // Return the map containing characters and their counts
        return lettersCountMap;

        } // End of the getCharacterCountMap method

    } // Closing bracket for the class

