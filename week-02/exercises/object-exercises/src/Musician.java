public class Musician {

    private String name;
    private int rating;

    /**
     * @param name   The name of the musician.
     * @param rating A number representing how much a musician is loved relative to other musicians.
     */
    public Musician(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Musician() {
        this.name = "Default";
        this.rating = 0;
    }

    public void setName(String string) { name = string; }
    public void setRating(int integer) { rating = integer;}

    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
}
