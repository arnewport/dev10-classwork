import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.

        Balloon red = new Balloon("red");
        Balloon blue = new Balloon("blue");
        Balloon yellow = new Balloon("yellow");

        do {

            System.out.print("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                // 2. If the user confirms an inflate, inflate each balloon.
                red.inflate();
                blue.inflate();
                yellow.inflate();
                System.out.println(red.getPsi());
                System.out.println(blue.getPsi());
                System.out.println(yellow.getPsi());
            }

            // 3. When one or more balloons explode, stop the loop.
        } while (!red.isExploded() || !blue.isExploded() || !yellow.isExploded());

        // 4. Print the color of the winners (balloons that exploded).
        Balloon[] balloons = new Balloon[] {red, blue, yellow};
        for (Balloon value : balloons) {
            if (value.isExploded()) {
                System.out.println(value.getColor());
            }
        }
    }
}
