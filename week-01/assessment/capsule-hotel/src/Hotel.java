import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Hotel {

    // VARIABLES

    static Scanner scanner = new Scanner(System.in);
    // I will create a String[] to represent the capsules within startUp / createRooms

    static String[] capsules;

    static String startUpString = """
            Welcome to Capsule-Capsule.
            ===========================
            Enter the number of capsules available:\s""";

    static String displayMenuString = """

            Guest Menu
            ==========
            1. Check In
            2. Check Out
            3. View Guests
            4. Exit
            Choose on option [1-4]:\s""";

    static String checkInString = """

            Guest Check In
            ==============""";

    static String checkOutString = """

            Guest Check Out
            ===============""";

    // figure out how to update the string as numberOfCapsules changes
//    static String capsulesAvailableString = "There are " + capsules.length + " unoccupied capsules ready to be booked.";

    // HELPER METHODS

    public static String inputText() {
        return scanner.nextLine();
    }

    // add validation later
    public static int returnPositiveInteger(String string) {
        return Integer.parseInt(string);
        // assure input can be parsed into an int
        // assure input is not greater than 100
        // assure input is a positive integer
    }

    // skipping data validation for now because it is more complex than I realized
//    public static int assurePositiveInteger(String string) {
//        scanner.hasNextInt() might be able to help
//
//        try {
//            Integer.parseInt(string);
//        } catch (Exception e) {
//            System.out.println("ERROR :(\nPLACEHOLDER is not an integer.\n\nPlease enter a valid integer: ");
//            assurePositiveInteger(inputText());
//        }
//        return Integer.parseInt(string);
//    }

    // skipping for now
    public static boolean limitNameLength(String string) {
        return true;
    }

    // skipping for now
    public static String removeExcessiveWhitespace(String string) {
        return string;
    }

    public static boolean withinRange(int number, int max) {
        return 0 < number && number < max;
    }

    // I don't need both isOccupied and isUnoccupied
    // one can fulfil the role of the other
    // this is a reminder; remove comments after the program is finished
    public static boolean isOccupied(String[] array, int index) {
        return array[index] == null;
    }

    public static String[] createRooms(int number) {
        return new String[number];
    }

    // PRIMARY METHODS

    public static void startUp() {
        System.out.print(startUpString);
        capsules = new String[returnPositiveInteger(inputText())];
        System.out.println("\nThere are " + capsules.length + " unoccupied capsules ready to be booked.");
        displayMenu();
    }

    public static void displayMenu() {
        System.out.println(displayMenuString);
        int input = returnPositiveInteger(inputText());
        while (true) {
            switch (input) {
                case 1 -> {
                    checkIn();
                }
                case 2 -> {
                    checkOut();
                }
                case 4 -> {
                    System.exit(0);
                }
            }
            input = returnPositiveInteger(inputText());
        }
    }

    public static void checkIn() {
        System.out.println(checkInString);
        System.out.print("\nGuest Name: ");
        String guestName = inputText();
        System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
        int capsuleNumber = returnPositiveInteger(inputText());
        while (capsules[capsuleNumber - 1] != null) {
            System.out.println("\nError :( Capsule #" + capsuleNumber + " is occupied.");
            System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
            capsuleNumber = returnPositiveInteger(inputText());
        }
        capsules[capsuleNumber - 1] = guestName;
        displayMenu();
    }

    public static void checkOut() {
        System.out.println(checkOutString);
        System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
        int capsuleNumber = returnPositiveInteger(inputText());
        while (capsules[capsuleNumber - 1] == null) {
            System.out.println("\nError :( Capsule #" + capsuleNumber + " is unoccupied.");
            System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
            capsuleNumber = returnPositiveInteger(inputText());
        }
        capsules[capsuleNumber - 1] = null;
        displayMenu();
    }

    public static void main(String[] args) {

        startUp();

    }

}
