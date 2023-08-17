public class Exercise03 {

    // 1. Read the hasAllVowels JavaDocs.
    // 2. Complete the hasAllVowels method.
    // 3. Create tests to fully test hasAllVowels and confirm that it's 100% correct.

    /**
     * Determines if a String contains all English vowels: a, e, i, o, and u.
     * Both uppercase and lowercase vowels are allowed.
     * The `null` value should return false.
     *
     * @param value the string to test
     * @return true if the value contains all 5 vowels, false if it doesn't
     */
    static boolean hasAllVowels(String value) {
        int count = 0;
        value.toLowerCase();
        String[] vowels = new String[] {"a", "e", "i", "o", "u"};

        for (String v : vowels) {
            for (int i = 0; i < value.length(); i++) {
                if (value.substring(i, i + 1).equals(v)) {
                    count++;
                    break;
                }
            }
        }

        return count == 5;

    }



}
