package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;
import learn.gomoku.utilities.ConsoleHelper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    public static Scanner console = new Scanner(System.in);

    // create a player

    public static Player makePlayer(Scanner console) {
        String result;
        Player player = null;
        do {
            System.out.println("1. Human");
            System.out.println("2. Random Player");
            System.out.print("Select [1-2]: ");
            result = console.nextLine();
            if (result.equals("1")) {
                System.out.print("Name?: ");
                String name = console.nextLine();
                player = new HumanPlayer(name);
            } else if (result.equals("2")) {
                player = new RandomPlayer();
            } else {
                System.out.println("That's not a valid choice.");
            }
        } while (player == null);

        return player;
    }

    // determine who goes first

    public static void displayRandomizer(Gomoku game) {
        System.out.println("\n(Randomizing)");
        System.out.println("\n" + game.getCurrent().getName() + " goes first.");
    }

    // create a board

    public static String[][] rows = new String[16][];
    public static String[] rowZero = new String[]{"  ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};
//    ArrayList<ArrayList<String>> rows = new ArrayList<>();
//    ArrayList<String> rowZero = new ArrayList<>(Arrays.asList("  ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"));

    public static void setUpBoard() {
        rows[0] = rowZero;

        for (int i = 1; i < rows.length; i++) {
            String[] newRow = new String[16];

            if (i < 10) {
                newRow[0] = "0" + i + " ";
            } else {
                newRow[0] = i + " ";
            }

            for (int j = 1; j < newRow.length; j++) {
                newRow[j] = "_ ";
            }

            rows[i] = newRow;
        }
    }

    public static void displayBoard() {
        for (String[] r : rows) {
            String rowToPrint = replaceCharacters(Arrays.toString(r), new String[]{",", "[", "]"});
            System.out.println(rowToPrint);
        }
    }

    public static String replaceCharacters(String value, String[] charactersToRemove) {
        for (String character : charactersToRemove) {
            value = value.replace(character, "");
        }
        return value;
    }

    public static void main(String[] args) {

//        setUpBoard();
//        displayBoard();
//        Player one = makePlayer(console);
//        System.out.println(one.getName());

        Gomoku game = new Gomoku(makePlayer(console), makePlayer(console));
        displayRandomizer(game);

    }



}
