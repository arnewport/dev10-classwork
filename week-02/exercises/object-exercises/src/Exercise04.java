import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // 1. Add an empty constructor to Musician.
        // 2. Uncomment the code below and make sure it runs.

        Musician m = new Musician();
        System.out.print("Musician name:");
        m.setName(console.nextLine());
        System.out.print("Musician rating:");
        int rating = Integer.parseInt(console.nextLine());
        m.setRating(rating);
        System.out.printf("%s: %s%n", m.getName(), m.getRating());

        // 3. Add a loop. The exercise should ask the user for musicians and print
        // them out until the user types "end".

        while (true) {
            System.out.print("Enter a musician's name (or enter \"end\" to stop): ");
            String musicianName = console.nextLine();
            if (musicianName.equals("end")) {
                break;
            }
            System.out.print("Enter the musician's rating (or enter \"end\" to stop): ");
            String stringRating = console.nextLine();
            if (stringRating.equals("end")) {
                break;
            }
            int musicianRating = Integer.parseInt(stringRating);
            Musician musicianToPrint = new Musician(musicianName, musicianRating);
            System.out.println(musicianToPrint.toString());
        }

    }
}
