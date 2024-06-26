import java.util.Scanner;

public class Exercise12 {

    static Scanner scanner = new Scanner(System.in);

    // 1. Create a method.
    // Name: readRequiredString
    // Inputs: String
    // Output: String
    // Description: prompts a user to enter a required string and returns their validated input.
    // The parameter is the message displayed to the user.
    //
    // See the readRequiredString implementation in the methods lesson.
    // You can definitely improve it. Make sure you don't allow blank input. Checking the length() is not enough.

    public static String readRequiredString(String prompt) {
        String result;
        do {
            System.out.print(prompt);
            result = scanner.nextLine();
        } while (result.isBlank());
        return result;
    }

    // 2. Create a method.
    // Name: printNounPhrase
    // Inputs: none
    // Output: none
    // Description: prints an adjective + noun phrase to the console based on user input.
    // Internally, prompts a user for an adjective and a noun with readRequiredString.
    // Concatenates adjective and noun and prints it to the console.

    public static void printNounPhrase() {
        String adjective = readRequiredString("Enter an adjective: ");
        String noun = readRequiredString("Enter a noun: ");
        System.out.println(adjective + " " + noun);
    }

    public static void main(String[] args) {
        // 3. Uncomment the code below and confirm it works.
         printNounPhrase();
    }
}
