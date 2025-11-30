package javaConcertTicketSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class PopularMerchandise {
    public static void main(String[] args) {
        // File object to handle the items file
        File file = new File("items.csv");

        // HashMap to store the frequency of each Item
        HashMap<String, Integer> itemFrequency = new HashMap<>();

        try(Scanner input = new Scanner(file)){
            while (input.hasNextLine()) {
                String line = input.nextLine();

                // Split by comma
                String[] items = line.split(",");

                // Trim and count
                for (String item : items) {
                    item = item.trim();    // remove spaces
                    itemFrequency.put(item, itemFrequency.getOrDefault(item, 0) + 1); // increment frequency
                }
            }
        } catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }

        // Processing the HashMap to find the top 3 items with their count
        List<Map.Entry<String, Integer>> top3 =
                itemFrequency.entrySet()
                        .stream()
                        .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())) // sort descending
                        .limit(3)
                        .toList();

        System.out.println("Top 3 Merchandise Items:");
        for (Map.Entry<String, Integer> entry : top3) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}