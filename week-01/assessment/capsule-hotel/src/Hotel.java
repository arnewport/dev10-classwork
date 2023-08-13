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

    // HELPER METHODS

    public static String inputText() {
        return scanner.nextLine();
    }

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

    public static int validateNumber (String string, int max) {
        if (!isPositiveNumber(string) || !withinRange(Integer.parseInt(string), 1, max)) {
            System.out.printf("\nSorry... %s is not a valid input.\n\nPlease enter a valid input: ", string);
            return validateNumber(inputText(), max);
        }
        return Integer.parseInt(string);
    }

    public static String validateText (String string, int max) {
        if (!limitNameLength(string, max)) {
            System.out.printf("\nSorry... %s is not a valid input.\n\nPlease enter a valid input: ", string);
            return validateText(inputText(), max);
        }
        return string;
    }

    // if I wanted to have specific validation messages for each error
    // I would add "String error" as a parameter to both validation functions,
    // would create specific error strings for each type of error,
    // and would pass these error strings as arguments to every instance of the validation functions
    // given this is not required by the assignment, I will likely not implement it due to time constraints
    public static void displayErrorMessage(String message, String value) {
        System.out.printf(message, value);
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
        capsules = new String[validateNumber(inputText(), 1000)];
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
