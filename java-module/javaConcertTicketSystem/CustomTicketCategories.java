package javaConcertTicketSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Ticket{
    String type;
    int price;
    String section;

    Ticket(String type, int price, String section){
        this.type = type;
        this.price = price;
        this.section = section;
    }

    @Override
    public String toString() {
        return "{ type: " + type + ", price: " + price + ", section: " + section + " }";
    }
}

/**
 * Custom Ticket Categorizer,
 * Finds Tickets categories frequency based on its type
 */
class CustomTicketCategorizer{
    ArrayList<Ticket> selections;
    HashSet<Ticket> uniqueCategories;
    HashMap<String, Integer> categoriesFrequency;

    CustomTicketCategorizer(ArrayList<Ticket> list){
        this.selections = new ArrayList<>(list);
        this.uniqueCategories = new HashSet<>(list);
        this.categoriesFrequency = new HashMap<>();
        for (Ticket ticket : list) {
            categoriesFrequency.put(ticket.type, categoriesFrequency.getOrDefault(ticket.type, 0) + 1);
        }
    }
}

public class CustomTicketCategories {
    public static void main(String[] args) {
        try {
            ArrayList<Ticket> lst = new ArrayList<>();
            lst.add(new Ticket("VIP", 500, "A"));
            lst.add(new Ticket("GEN", 300, "B"));
            lst.add(new Ticket("GEN", 300, "B"));
            lst.add(new Ticket("VVIP", 800, "C"));

            CustomTicketCategorizer ticketCategorizer = new CustomTicketCategorizer(lst);
            System.out.println(ticketCategorizer.selections);
            System.out.println(ticketCategorizer.uniqueCategories);
            System.out.println(ticketCategorizer.categoriesFrequency);
        } catch (Exception e) {
            System.out.println("Error Occurred:" + e.getMessage());
        }
    }
}
