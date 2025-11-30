package javaConcertTicketSystem;

import java.util.Scanner;

public class UsernameChecker {

    // Takes string as an input, returns its length
    static int getLength(String str){
        return str.length();
    }

    // Takes two Strings as an input, return "true" if their length is same
    static boolean equalLength(String str1, String str2){
        return getLength(str1) == getLength(str2);
    }

    // Takes two Strings as an input, return "true" if both of them are same
    static boolean isMatching(String str1, String str2){
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        // Creating a scanner object for taking input
        Scanner input = new Scanner(System.in);

        // Taking input from user
        String username = input.next();
        String confirmation = input.next();

        input.close();

        System.out.println("Input: " + "\"" + username + "\"" + " and " + "\"" + confirmation + "\"");
        System.out.println("Output:");
        System.out.println("Length 1: " + getLength(username));
        System.out.println("Length 2: " + getLength(confirmation));
        System.out.println("Lengths match: " + equalLength(username, confirmation));
        System.out.println("Strings match: " + isMatching(username, confirmation));
    }
}