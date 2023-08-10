import java.util.Scanner;

public class Exercise14 {

    static Scanner scanner = new Scanner(System.in);
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */

    public static void askAndPrint() {
        System.out.print("What is your first name? ");
        String first = scanner.nextLine();
        System.out.print("What is your last name? ");
        String last = scanner.nextLine();
        System.out.print("How many towns/cities have you lived in? ");
        String cities = scanner.nextLine();
        System.out.print("How many musical instruments can you play? ");
        String instruments = scanner.nextLine();
        System.out.println("Your first name is: " + first + "\nYour last name is: " + last + "\nYou have lived in "
            + cities + " towns/cities\nYou play " + instruments + " musical instruments");
    }

    // I could create four methods, one that each asks a question and returns a string, but I'm lazy right now
    // maybe I'll come back to it later

    public static void main(String[] args) {
        askAndPrint();
    }

}
