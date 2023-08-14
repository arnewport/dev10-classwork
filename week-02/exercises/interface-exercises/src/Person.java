public class Person {

    private final String firstName;
    private final String lastName;
    private Wallet wallet;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = new Wallet(0.0, String.format("%s's Wallet", firstName));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public Wallet getWallet() { return wallet; }

    public void setMoneyStorage(Wallet wallet) {
        this.wallet = wallet;
    }

}
