import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // 1. Display the following menu and collect an integer choice from the user.
        // (See Exercise14 for a menu example.)
        //
        // Menu
        // 1. Print the name of an animal.
        // 2. Print the name of a state.
        // 3. Print the name of a beetle.
        // 4. Print the name of a mineral.
        // Select [1-4]:
        //
        // 2. Use a switch to cover cases 1-4 as well as a default.
        // For 1-4, print an animal, state, beetle, or mineral respectively.
        // For the default case, print "Unknown Menu Option".

        System.out.println("Menu \n1. Print the name of an animal.\n2. Print the name of a state." +
                "\n3. Print the name of a beetle.\n4. Print the name of a mineral.\nSelect [1-4]:");

        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        switch (number) {
            case 1:
                System.out.println("Animal");
            case 2:
                System.out.println("State");
            case 3:
                System.out.println("Beetle");
            case 4:
                System.out.println("Mineral");
            default:
                System.out.println("Unknown Menu Option");
        }

    }
}
