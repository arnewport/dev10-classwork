package learn.cards;

public enum Suit {
    SPADES("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    public String name;

    Suit (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
