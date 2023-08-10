public class Exercise10 {
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

    public static String removeWhitespace(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                result += string.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(removeWhitespace("Hello World"));

    }

}
