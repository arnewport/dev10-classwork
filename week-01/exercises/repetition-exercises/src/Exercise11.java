import java.util.Scanner;

public class Exercise11 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(scanner.nextLine());

        System.out.print("Increment: ");
        int increment = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = start; i < end + 1; i += increment) {
            sum += i;
        }

        System.out.println(sum);
        
    }
    
}
