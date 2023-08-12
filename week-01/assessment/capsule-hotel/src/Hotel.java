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

    // figure out how to update the string as numberOfCapsules changes
//    static String capsulesAvailableString = "There are " + capsules.length + " unoccupied capsules ready to be booked.";

    // HELPER METHODS

    public static String inputText() {
        return scanner.nextLine();
    }

//    System.out.println("Sorry... " + input + " is not a valid menu option.");
//    System.out.print("ERROR :(\n" + string + " is not a valid number.\n\nPlease enter a positive integer: ");
//    System.out.print("ERROR :(\n" + integer + " is not positive.\n\nPlease enter a positive integer: ");
    static boolean isValidNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean returnPositive(int integer) {
        return integer >= 1;
    }

    public static boolean limitNameLength(String string) {
        return string.length() < 101;
    }

    public static boolean withinRange(int number, int max) {
        return 0 < number && number < max;
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

    public static void printCapsules(int start, int end) {
        for (int i = start; i < end; i++) {
            String occupant = (capsules[i] == null) ? "[unoccupied]" : capsules[i];
            System.out.println((i + 1) + ": " + occupant);
        }
    }

    // PRIMARY METHODS

    public static void startUp() {
        System.out.print(startUpString);
        capsules = new String[returnPositiveInteger(inputText())];
        System.out.println("\nThere are " + capsules.length + " unoccupied capsules ready to be booked.");
        displayMenu();
    }

    public static void displayMenu() {
        System.out.print(displayMenuString);
        int input = returnPositiveInteger(inputText());
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
                    System.exit(0);
                }
                default -> {
                    // this needs to be moved elsewhere as right now,
                    // there shouldn't be non-integers reaching this point
                    System.out.println("Sorry... " + input + " is not a valid menu option.");
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
        System.out.println("\nSuccess :)\n" + guestName + " is booked in capsule #" + capsuleNumber + ".");
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
        int capsuleNumber = returnPositiveInteger(inputText());
        if (capsuleNumber <= 5) {
            printCapsules(0, 11);
        } else if (capsuleNumber >= capsules.length - 5) {
            printCapsules(capsules.length - 11, capsules.length);
        } else {
            printCapsules(capsuleNumber - 6, capsuleNumber + 5);
        }
        displayMenu();
    }

    public static void main(String[] args) {

        startUp();

    }

}
