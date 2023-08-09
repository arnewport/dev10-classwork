import java.util.Scanner;

public class Exercise17 {

    public static void main(String[] args) {
        // USER-DEFINED BOX
        // 1. Collect the following from a user: rows, columns, box character, border character.
        // 2. Use nested loops to print a user-defined box in the console.
        // (See Exercise16.)

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of columns: ");
        int numberOfColumns = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the box character: ");
        String boxCharacter = scanner.nextLine();
        boxCharacter = boxCharacter.substring(0); // remove all characters beyond the first
        System.out.println("Enter the border character: ");
        String borderCharacter = scanner.nextLine();
        borderCharacter = borderCharacter.substring(0); // remove all characters beyond the first

        if (numberOfRows < 2 || numberOfColumns < 2) {
            System.out.println("Please enter a number of rows greater than 2 and a number of columns greater than 2");
            System.out.println("The program will now exit. Please restart the program.");
            System.exit(0);
        }

        String edgeColumns = "";
        edgeColumns += borderCharacter;
        String middleColumns = "";
        middleColumns += borderCharacter;

        for (int i = 0; i < numberOfColumns - 2; i++) {
            edgeColumns += borderCharacter;
            middleColumns += boxCharacter;
        }

        edgeColumns += borderCharacter;
        middleColumns += borderCharacter;

        System.out.println(edgeColumns);
        for (int i = 0; i < numberOfRows - 2; i++) {
            System.out.println(middleColumns);
        }
        System.out.println(edgeColumns);

    }
}
