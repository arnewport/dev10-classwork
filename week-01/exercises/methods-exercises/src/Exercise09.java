import java.util.Scanner;

public class Exercise09 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        printBox(5, 5);
        printBox(3, 4);
    }

    // 1. Create a method.
    // Name: printBox
    // Inputs: int, int
    // Output: void
    // Description: prints a visual box to the console. The first parameter is the number of rows to print.
    // The second parameter is the number of columns.
    // See repetition Exercise15.

    public static void printBox(int rows, int columns) {
        String columnsString = "";

        for (int i = 0; i < columns; i++) {
            columnsString += "#";
        }

        for (int i = 0; i < rows; i++) {
            System.out.println(columnsString);
        }

    }

    // Expected Output (5 rows, 5 columns)
    // #####
    // #####
    // #####
    // #####
    // #####

    // (3 rows, 4 columns)
    // ####
    // ####
    // ####
}
