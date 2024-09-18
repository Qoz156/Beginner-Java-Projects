import java.util.HashMap;


public class Maps {
    public static void main(String[] args) {

         // Creating a HashMap to store employee names as keys (String) and their IDs as values (Integer)
        HashMap<String, Integer> empIds = new HashMap<>();

        // Adding key-value pairs to the HashMap (employee name -> employee ID)
        empIds.put("John", 12345); // Adds John with ID 12345
        empIds.put("Carl", 54321); // Adds Carl with ID 54321
        empIds.put("Jerry", 8675309); // Adds Jerry with ID 8675309

        // Printing the entire HashMap, which shows all key-value pairs
        System.out.println(empIds); // Output: {John=12345, Carl=54321, Jerry=8675309}

        // Retrieving the value (ID) associated with the key "Carl"
        System.out.println(empIds.get("Carl")); // Output: 54321

        // Checking if the key "Jerry" exists in the HashMap
        System.out.println(empIds.containsKey("Jerry")); // Output: true

        // Checking if the value 8675309 exists in the HashMap
        System.out.println(empIds.containsValue(8675309)); // Output: true

        // Updating the value associated with the key "John" to a new ID
        empIds.put("John", 98765); // Changes John's ID from 12345 to 98765
        System.out.println(empIds); // Output: {John=98765, Carl=54321, Jerry=8675309}

        // Attempting to replace the value for the key "Kramer", but "Kramer" does not exist in the map
        empIds.replace("Kramer", 777); // No change since "Kramer" isn't a key in the map
        System.out.println(empIds); // Output: {John=98765, Carl=54321, Jerry=8675309}

        // Adding a key-value pair for "Steve" only if "Steve" is not already present in the map
        empIds.putIfAbsent("Steve", 222); // Adds Steve with ID 222 because "Steve" is not in the map
        System.out.println(empIds); // Output: {John=98765, Carl=54321, Jerry=8675309, Steve=222}

        // Removing the key-value pair for "Steve"
        empIds.remove("Steve"); // Removes Steve from the map
        System.out.println(empIds); // Output: {John=98765, Carl=54321, Jerry=8675309}

    }
    
}

// HashMap Creation: The HashMap<String, Integer> stores pairs of employee names (String) and their IDs (Integer).
// put() Method: Adds or updates key-value pairs in the map.
// get() Method: Retrieves the value associated with a specific key.
// containsKey() & containsValue(): These methods check for the existence of a specific key or value.
// replace(): Updates the value associated with a key, but if the key doesn't exist, nothing happens.
// putIfAbsent(): Only adds a new key-value pair if the key does not already exist.
// remove(): Deletes a key-value pair from the map based on the key.