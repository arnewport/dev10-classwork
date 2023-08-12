import java.util.Scanner;

public class Hotel {

    // VARIABLES

    static Scanner scanner = new Scanner(System.in);

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

    static String viewGuestsString = """

            View Guests
            ===========""";

    static String exitProgramString = """

            Exit
            ====
            Are you sure you want to exit?
            All data will be lost.
            Exit [y/n]:\s""";

    // figure out how to update the string as numberOfCapsules changes
//    static String capsulesAvailableString = "There are " + capsules.length + " unoccupied capsules ready to be booked.";

    // HELPER METHODS

    public static String inputText() {
        return scanner.nextLine();
    }

//    System.out.println("Sorry... " + input + " is not a valid menu option.");
//    System.out.print("ERROR :(\n" + string + " is not a valid number.\n\nPlease enter a positive integer: ");
//    System.out.print("ERROR :(\n" + integer + " is not positive.\n\nPlease enter a positive integer: ");
    static boolean isValidNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositive(int integer) {
        return integer >= 1;
    }

    public static boolean isPositiveNumber(String string) {
        return isValidNumber(string) && isPositive(Integer.parseInt(string));
    }

    public static boolean limitNameLength(String string, int max) {
        return string.length() <= max; // keep names under 100 characters
    }

    public static boolean withinRange(int number, int min, int max) {
        return min <= number && number <= max;
    }

    // skipping for now
    public static String removeExcessWhitespace(String string) {
        return string;
    }

    // I need a validation function
    // it accepts an undefined number of methods as arguments
    // write every test so that "true" is a passing value
    // place each method in an array
    // the input is looped through each of the tests
    // one false triggers an error message
    // all true passes it on
    // this may be overly complicated, but it is a first thought for validation

    // I don't need a validation function
    // I just need to chain these tests together
    // especially since I need the values transformed in between some tests

    // THINK!

    // You only need to validate four kinds of inputs
    // the initial number of capsules - isValidNumber, isPositive, withinRange (min 1 max 100)
    // the menu options - isValidNumber, is Positive, withinRange (min 1 max 4) BUT
    // withinRange may not even be needed, because of the switch case
    // picking a room number for checkIn, checkOut, viewGuests - isValidNumber, isPositive, withinRange (1 to capsules.length)
    // entering a name for checkIn - limitNameLength, removeExcessWhitespace (optional at this point)

    public static int validateNumber (String string, int max) {
        if (!isPositiveNumber(string) || !withinRange(Integer.parseInt(string), 1, max)) {
            System.out.println("INVALID, PROMPT");
            return validateNumber(inputText(), max);
        }
        return Integer.parseInt(string);
    }

    public static String validateText (String string, int max) {
        if (!limitNameLength(string, max)) {
            System.out.println("INVALID, PROMPT");
            return validateText(inputText(), max);
        }
        return string;
    }

    // make work later
    public static String displayErrorMessage(String value, String message) {
        return value + message;
    }

    public static void printCapsules(int start, int end) {
        for (int i = start; i < end; i++) {
            String occupant = (capsules[i] == null) ? "[unoccupied]" : capsules[i];
            System.out.println((i + 1) + ": " + occupant);
        }
    }

    // PRIMARY METHODS

    public static void startUp() {
        System.out.print(startUpString);
        capsules = new String[validateNumber(inputText(), 100)];
        System.out.println("\nThere are " + capsules.length + " unoccupied capsules ready to be booked.");
        displayMenu();
    }

    public static void displayMenu() {
        System.out.print(displayMenuString);
        int input = validateNumber(inputText(), 4);
        while (true) {
            switch (input) {
                case 1 -> {
                    checkIn();
                }
                case 2 -> {
                    checkOut();
                }
                case 3 -> {
                    viewGuests();
                }
                case 4 -> {
                    exitProgram();
                }
            }
        }
    }

    public static void checkIn() {
        System.out.println(checkInString);
        System.out.print("\nGuest Name: ");
        String guestName = validateText(inputText(), 100);
        System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
        int capsuleNumber = validateNumber(inputText(), capsules.length);
        while (capsules[capsuleNumber - 1] != null) {
            System.out.println("\nError :( Capsule #" + capsuleNumber + " is occupied.");
            System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
            capsuleNumber = validateNumber(inputText(), capsules.length);
        }
        capsules[capsuleNumber - 1] = guestName;
        System.out.println("\nSuccess :)\n" + guestName + " is booked in capsule #" + capsuleNumber + ".");
        displayMenu();
    }

    public static void checkOut() {
        System.out.println(checkOutString);
        System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
        int capsuleNumber = validateNumber(inputText(), capsules.length);
        while (capsules[capsuleNumber - 1] == null) {
            System.out.println("\nError :( Capsule #" + capsuleNumber + " is unoccupied.");
            System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
            capsuleNumber = validateNumber(inputText(), capsules.length);
        }
        System.out.println("\nSuccess :)\n" + capsules[capsuleNumber - 1]  + " checked out from capsule #" + capsuleNumber + ".");
        capsules[capsuleNumber - 1] = null;
        displayMenu();
    }

    public static void viewGuests() {
        System.out.println(viewGuestsString);

        if (capsules.length <= 11) {
            printCapsules(0, capsules.length);
            displayMenu();
            return;
        }
        System.out.print("\nCapsule #[1-" + capsules.length + "]: ");
        int capsuleNumber = validateNumber(inputText(), capsules.length);
        if (capsuleNumber <= 5) {
            printCapsules(0, 11);
        } else if (capsuleNumber >= capsules.length - 5) {
            printCapsules(capsules.length - 11, capsules.length);
        } else {
            printCapsules(capsuleNumber - 6, capsuleNumber + 5);
        }
        displayMenu();
    }

    public static void exitProgram() {
        System.out.print(exitProgramString);
        String input = validateText(inputText(), 1);
        while (true) {
            switch (input) {
                case "y" -> {
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                }
                case "n" -> displayMenu();
                default -> exitProgram();
            }
        }
    }

    public static void main(String[] args) {

        startUp();

    }

}
