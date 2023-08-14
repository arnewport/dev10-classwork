public class Hero {

    private String name;
    private Power[] powers;

    public Hero (String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public Power[] getPowers() {
        return powers;
    }

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public String toLine() {
        String line = this.getName() + ": ";
        for (Power p : this.getPowers()) {
            line += p.getName() + ", ";
        }
        return line.substring(0, line.length() - 2);
    }

}
