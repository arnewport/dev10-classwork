import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Add three new games to `games` with the `add` method.
        // 2. Print `games` after each add.
        // public BoardGame(String name, int minPlayers, int maxPlayers, String category)
        games.add(new BoardGame("Alpha", 1, 1, "Alpha"));
        Exercise02.printAllBoardGames(games);
        games.add(new BoardGame("Beta", 1, 1, "Beta"));
        Exercise02.printAllBoardGames(games);
        games.add(new BoardGame("Gamma", 1, 1, "Gamma"));
        Exercise02.printAllBoardGames(games);
    }
}
