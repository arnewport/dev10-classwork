import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // BOX
        // 1. Use nested loops to print a box in the console.
        // One loop should represent rows and the other should represent columns.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // #####
        // #####
        // #####
        // #####
        // #####

        // (3X4)
        // ####
        // ####
        // ####

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of columns: ");
        int numberOfColumns = Integer.parseInt(scanner.nextLine());

        String columns = "";

        for (int i = 0; i < numberOfColumns; i++) {
            columns += "#";
        }

        for (int i = 0; i < numberOfRows; i++) {
            System.out.println(columns);
        }

    }
}
