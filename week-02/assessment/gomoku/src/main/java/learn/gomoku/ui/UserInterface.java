package learn.gomoku.ui;

import learn.gomoku.utilities.ConsoleHelper;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInterface {

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

    public static void printBoard() {
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

        setUpBoard();
        printBoard();

    }



}
