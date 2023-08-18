package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;
import learn.gomoku.utilities.ConsoleHelper;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    public static Scanner console = new Scanner(System.in);

    // display title

    public static void displayTitle() {
        System.out.println("\nWelcome to Gomoku\n" +
                "=================");
    }

    // create a player

    public static Player makePlayer(Scanner console) {
        String result;
        Player player = null;
        do {
            System.out.println("\n1. Human");
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

    public static String getCurrentName(Gomoku game) {
        return game.getCurrent().getName();
    }

    public static void displayRandomizer(Gomoku game) {
        System.out.println("\n(Randomizing)");
        System.out.println("\n" + game.getCurrent().getName() + " goes first.");

    }

    // create a board

    public static String[][] rows = new String[16][];
    public static String[] rowZero = new String[]{"  ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"};

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
        System.out.println();
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

    // place a stone

    public static void placeStone(Gomoku game, Scanner console) {
        Result result = new Result(null);
        Stone stone = new Stone(0, 0, false);
        int row;
        int column;

        do {
            if (result.getMessage() != null) {
                System.out.println("\n" + result.getMessage());
            }

            System.out.println("\n" + game.getCurrent().getName() + "'s Turn");

            if (game.getCurrent().generateMove(game.getStones()) == null) {
                System.out.print("Enter a row:  ");
                row = Integer.parseInt(console.nextLine());
                System.out.print("Enter a column:  ");
                column = Integer.parseInt(console.nextLine());
                stone = new Stone(row - 1, column - 1, game.isBlacksTurn());
            } else  {
                stone = game.getCurrent().generateMove(game.getStones());
            }

            addStoneToBoard(game, stone);
            displayBoard();
            result = game.place(stone);

        } while (!result.isSuccess());

        if (!game.isOver()) {
            placeStone(game, console);
        } else {
            System.out.println("\n" + result.getMessage());
            playAgain(console);
        }

    }

    public static void addStoneToBoard(Gomoku game, Stone stone) {
        if (!isValid(stone)) {
            return;
        }
        if (!rows[stone.getRow() + 1][stone.getColumn() + 1].equals("_ ")) {
            return;
        }
        rows[stone.getRow() + 1][stone.getColumn() + 1] = game.isBlacksTurn() ? "B " : "W ";
    }

    public static boolean isValid(Stone stone) {
        return stone != null
                && stone.getRow() >= 0 && stone.getRow() < 16
                && stone.getColumn() >= 0 && stone.getColumn() < 16;
    }

    public static void playAgain(Scanner console) {
        String input;
        do {
            System.out.print("\nPlay Again? [y/n]: ");
            input = console.nextLine();
            if (input.equals("y")) {
                playGame(console);
            } else if (input.equals("n")) {
                System.out.println("\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nThat's not a valid choice.");
            }
        } while (!input.equals("y"));

    }

    public static void playGame(Scanner console) {
        setUpBoard();
        displayTitle();
        Gomoku game = new Gomoku(makePlayer(console), makePlayer(console));
        displayRandomizer(game);
        placeStone(game, console);
    }

}
