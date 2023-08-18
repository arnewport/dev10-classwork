package learn.gomoku.utilities;

import java.util.Scanner;

public class ConsoleHelper {
    private final Scanner console = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String readString(String prompt) {
        print(prompt);
        return console.nextLine();
    }

    public String readRequiredString(String prompt) {
        String result;
        do {
            result = readString(prompt);
            if (result.isBlank()) {
                print("[Error]: Input cannot be blank");
            }
        } while (result.isBlank());

        // Remove extra whitespace off string, e.g., "Ex      " => "Ex"
        return result.trim();
    }

    public void printHeader(String msg) {
        print("=".repeat(msg.length()));
        print(msg);
        print("=".repeat(msg.length()));
    }

    public int readInt(String prompt) {
        String input = readRequiredString(prompt);
        return Integer.parseInt(input);
    }

    public int readInt(String prompt, int min, int max) {
        boolean inRange = false;
        int input;
        do {
            input = readInt(prompt);
            if (input < min) {
                print("[Error]: Input must be greater than " + min);
            } else if (input > max) {
                print("[Error]: Input must be less than " + max);
            } else {
                inRange = true;
            }
        } while (!inRange);

        return input;
    }
}
