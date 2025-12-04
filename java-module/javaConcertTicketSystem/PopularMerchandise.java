package javaConcertTicketSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PopularMerchandise {

    static List<Map.Entry<String, Integer>> getTopK(HashMap<String, Integer> itemFrequency, int k){
        return itemFrequency.entrySet()
                        .stream()
                        .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())) // sort descending
                        .limit(k)
                        .toList();
    }

    public static void main(String[] args) {
        try {
            HashMap<String, Integer> itemFrequency = new HashMap<>();
            String filename = "items.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                for (String item : items) {
                    item = item.trim();
                    itemFrequency.put(item, itemFrequency.getOrDefault(item, 0) + 1);
                }
            }
            reader.close();

            List<Map.Entry<String, Integer>> top3 = getTopK(itemFrequency, 3);

            for (Map.Entry<String, Integer> entry : top3) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}