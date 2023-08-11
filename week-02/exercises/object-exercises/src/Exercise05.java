import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);

        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)

        for (int i = 0; i < musicians.length; i++) {
            Musician object = new Musician();
            System.out.print("Enter a musician's name: ");
            object.setName(console.nextLine());
            System.out.print("Enter the musician's rating: ");
            object.setRating(Integer.parseInt(console.nextLine()));
            musicians[i] = object;
        }

        // 2. Use a second loop to print details about each musician.
        for (Musician object: musicians) {
            System.out.println(object.getName() + " " + object.getRating());
        }
    }
}
