import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        int positiveCount = 0;
        int negativeCount = 0;

        for (int number : values) {
            if (number > 0) {
                positiveCount++;
            } else {
                negativeCount++;
            }
        }

        int[] positiveNumbers = new int[positiveCount];
        int[] negativeNumbers = new int[negativeCount];
        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                positiveNumbers[positiveIndex] = values[i];
                System.out.println(positiveNumbers[positiveIndex]);
                positiveIndex++;
            } else {
                negativeNumbers[negativeIndex] = values[i];
                System.out.println(negativeNumbers[negativeIndex]);
                negativeIndex++;
            }
        }

        // 1. Count the number of positive and non-positive elements in `values`.
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
