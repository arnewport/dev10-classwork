import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame>.
        ArrayList<BoardGame> exerciseGames = new ArrayList<BoardGame>();
        // 2. Add three BoardGames to the new list.
        exerciseGames.add(new BoardGame("Alpha", 1, 1, "Alpha"));
        exerciseGames.add(new BoardGame("Beta", 1, 1, "Beta"));
        exerciseGames.add(new BoardGame("Gamma", 1, 1, "Gamma"));
        // 3. Print the new list.
        Exercise02.printAllBoardGames(exerciseGames);
        // 4. Add items in the new list to `games` with the `addAll` method.
        games.addAll(exerciseGames);
        // 5. Print `games`.
        Exercise02.printAllBoardGames(games);
    }
}
