package javaConcertTicketSystem;

import java.util.Scanner;

class Checker{
    String username;
    String confirmation;

    Checker(String username, String confirmation){
        this.username = username;
        this.confirmation = confirmation;
    }

    int getUsernameLength(){
        return this.username.length();
    }

    int getConfirmationLength(){
        return this.confirmation.length();
    }

    boolean equalLength(){
        return getUsernameLength() == getConfirmationLength();
    }

    boolean isMatching(){
        return this.username.equals(this.confirmation);
    }
}

public class UsernameChecker {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String username = input.next();
            String confirmation = input.next();
            input.close();

            Checker checker = new Checker(username, confirmation);

            System.out.println("Input: " + "\"" + checker.username + "\"" + " and " + "\"" + checker.confirmation + "\"");
            System.out.println("Output:");
            System.out.println("Length 1: " + checker.getUsernameLength());
            System.out.println("Length 2: " + checker.getConfirmationLength());
            System.out.println("Lengths match: " + checker.equalLength());
            System.out.println("Strings match: " + checker.isMatching());
        }
        catch (Exception e){
            System.out.println("Error occurred : " +  e.getMessage());
        }
    }
}