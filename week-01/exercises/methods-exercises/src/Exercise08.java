import java.util.Random;

public class Exercise08 {

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    static Random random = new Random();

    public static String getRandomFruit() {
        String[] fruits = {"Apple", "Banana", "Cantaloupe", "Durian", "Elderberry"};
        return fruits[random.nextInt(5)];
    }

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        getRandomFruit();
        getRandomFruit();
        getRandomFruit();
    }
}
