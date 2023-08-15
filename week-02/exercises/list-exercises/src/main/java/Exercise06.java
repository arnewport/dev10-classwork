import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise06 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Use a loop to find the game in `games` that can be played by the most players.
        BoardGame mostPlayers = null;
        for (BoardGame g : games) {
            if (mostPlayers == null) {
                mostPlayers = g;
                continue;
            }
            if (mostPlayers.getMaxPlayers() < g.getMaxPlayers()) {
                mostPlayers = g;
            }
        }
        // 2. Print the game. (Expected: "Ultimate Werewolf...")
        System.out.println(mostPlayers);
    }
}

