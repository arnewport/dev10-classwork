import java.util.Arrays;

public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.
    public static boolean areInOrder(int first, int second, int third, int fourth) {
        int[] startingArray = {first, second, third, fourth};
        int[] sortedArray = {first, second, third, fourth};
        Arrays.sort(sortedArray);
        return Arrays.equals(startingArray, sortedArray);
    }

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        areInOrder(1, 2, 3, 4);
        areInOrder(4, 3, 2, 1);
    }
}
