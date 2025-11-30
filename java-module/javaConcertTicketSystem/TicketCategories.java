package javaConcertTicketSystem;

import java.util.*;

public class TicketCategories {
    public static void main(String[] args) {
        // Creating a scanner object for taking input
        Scanner input = new Scanner(System.in);

        // ArrayList for all the selections
        ArrayList<String> selections = new ArrayList<>();
        for(int i=0; i < 10; i++){
            String str = input.next();
            selections.add(str); // Adding into selections
        }
        input.close();

        // HashSet for Unique Categories
        HashSet<String> uniqueCategories = new HashSet<>(selections);

        // HashMap for frequency count of each Categorie
        HashMap<String, Integer> categoriesFrequency = new HashMap<>();

        // Iterating over selections in order to populate the HashMap
        for (String category : selections) {
            categoriesFrequency.put(category, categoriesFrequency.getOrDefault(category, 0) + 1);
        }

        System.out.println("ArrayList: " + selections);
        System.out.println("HashSet: " + uniqueCategories);
        System.out.println("HashMap: " + categoriesFrequency);
    }
}