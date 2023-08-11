import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();
        int beetles = 0;
        int mosquitos = 0;
        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        for (String bug : bugs) {
            if (bug.equals("beetle")) {
                beetles++;
            } else {
                mosquitos++;
            }
        }
        // 2. Print the result.
        System.out.println("Beetles: " + beetles);
        System.out.println("Mosquitos: " + mosquitos);
        // Results will vary because of randomness.
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle");
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
