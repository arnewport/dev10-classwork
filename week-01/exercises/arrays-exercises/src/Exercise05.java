public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        String[] continents = new String[6];
        continents[0] = "Africa";
        continents[1] = "Asia";
        continents[2] = "Europe";
        continents[3] = "North America";
        continents[4] = "South America";
        continents[5] = "Australia";
        // I'm not sure if these are the continents desired, but the code is correct :)
        // 2. Loop over each element and print it.
        for (String continent : continents) {
            System.out.println(continent);
        }
    }
}
