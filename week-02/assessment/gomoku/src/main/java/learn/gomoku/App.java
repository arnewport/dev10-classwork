package learn.gomoku;

import java.util.Scanner;
import learn.gomoku.ui.UserInterface;

public class App {

    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        UserInterface.playGame(console);

    }

}
