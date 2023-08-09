import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // SWITCH OPPOSITES
        // Given a word, print its opposite using a switch statement.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Re-implement Exercise08 using a switch statement.

        switch (word) {
            case "high":
                opposite = "low";
            case "cold":
                opposite = "hot";
            case "little":
                opposite = "big";
            case "wet":
                opposite = "dry";
            case "hard":
                opposite = "soft";
        }

        // not implementing a switch case here because Java doesn't like null switch cases
        if (opposite == null) {
            System.out.printf("I don't have an opposite for %s.%n", word);
        } else {
            System.out.printf("The opposite of %s is %s.%n", word, opposite);
        }

    }
}
