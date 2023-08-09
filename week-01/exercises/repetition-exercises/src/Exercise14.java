import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        // 1. Collect a phrase from a user via the console.
        // 2. Count the number of digits in the phrase.
        // Hint: Character.isDigit
        // 3. Print the result.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String phrase = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < phrase.length(); i++) {
            if (Character.isDigit(phrase.charAt(i))) {
                count++;
            }
        }

        System.out.println("Number of digits in the phrase: " + count);

    }
}
