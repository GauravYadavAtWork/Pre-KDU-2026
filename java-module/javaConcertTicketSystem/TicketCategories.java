package javaConcertTicketSystem;

import java.util.*;

class TicketCategorizer{
    ArrayList<String> selections;
    HashSet<String> uniqueCategories;
    HashMap<String, Integer> categoriesFrequency;

    TicketCategorizer(ArrayList<String> list){
        this.selections = new ArrayList<>(list);
        this.uniqueCategories = new HashSet<>(list);
        this.categoriesFrequency = new HashMap<>();
        for (String category : list) {
            categoriesFrequency.put(category, categoriesFrequency.getOrDefault(category, 0) + 1);
        }
    }
}

public class TicketCategories {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i < 10; i++){
                String str = input.next();
                list.add(str);
            }
            input.close();
            TicketCategorizer ticketCategorizer = new TicketCategorizer(list);
            System.out.println("ArrayList: " + ticketCategorizer.selections);
            System.out.println("HashSet: " + ticketCategorizer.uniqueCategories);
            System.out.println("HashMap: " + ticketCategorizer.categoriesFrequency);
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}