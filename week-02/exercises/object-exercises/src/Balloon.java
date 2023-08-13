public class Balloon {

    private String color;
    private static double psi;

    public Balloon(String color) {
        this.color = color;
        psi = 0.0;
    }

    public String getColor() {
        return color;
    }

    public double getPsi() {
        return psi > 16.0 ? Double.POSITIVE_INFINITY : psi;
    }

    public void inflate() { psi += Math.random() * 5.0; }

    public boolean isExploded() { return psi > 16.0; }

}
