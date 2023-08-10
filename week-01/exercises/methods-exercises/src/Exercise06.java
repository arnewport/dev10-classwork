public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static boolean isBetween(int first, int second, int third) {
        if (Math.min(second, third) < first && first < Math.max(second, third)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        isBetween(1, 2, 3);
        isBetween(2, 1, 3);
    }
}
