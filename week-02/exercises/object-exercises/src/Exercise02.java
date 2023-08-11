public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        // 2. Uncomment the line below and ensure that it compiles and runs.
        System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        // 4. Print each musicians' name and rating on a single line.
        Musician first = new Musician("John", 10);
        Musician second = new Musician("Jane", 10);
        System.out.println(first.getName() + " " + first.getRating());
        System.out.println(second.getName() + " " + second.getRating());
    }
}
