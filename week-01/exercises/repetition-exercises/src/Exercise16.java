import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of columns: ");
        int numberOfColumns = Integer.parseInt(scanner.nextLine());

        if (numberOfRows < 2 || numberOfColumns < 2) {
            System.out.println("Please enter a number of rows greater than 2 and a number of columns greater than 2");
            System.out.println("The program will now exit. Please restart the program.");
            System.exit(0);
        }

        String edgeColumns = "*";
        String middleColumns = "*";

        for (int i = 0; i < numberOfColumns - 2; i++) {
            edgeColumns += "*";
            middleColumns += "#";
        }

        edgeColumns += "*";
        middleColumns += "*";

        System.out.println(edgeColumns);
        for (int i = 0; i < numberOfRows - 2; i++) {
            System.out.println(middleColumns);
        }
        System.out.println(edgeColumns);

    }
}
