import java.util.Scanner;

public class Exercise09 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Enter a minimum value: ");
        int minimum = Integer.parseInt(console.nextLine());
        System.out.print("Enter a maximum value: ");
        int maximum = Integer.parseInt(console.nextLine());
        System.out.print("Enter the actual value: ");
        int actual = Integer.parseInt(console.nextLine());

        if (actual >= minimum && actual <= maximum) {
            System.out.println("The actual value is within the range");
        } else {
            System.out.println("The actual value is out of the range");
        }

    }

}
