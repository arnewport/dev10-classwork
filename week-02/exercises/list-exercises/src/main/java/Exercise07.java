import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise07 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame> and call it `economicGames`.
        // 2. Loop over `games`. Add each game with the "Economic" category to `economicGames`.
        // 3. Print `economicGames`.

        ArrayList<BoardGame> economicGames = new ArrayList<BoardGame>();

        for (BoardGame g : games) {
            if (g.getCategory().equals("Economic")) {
                economicGames.add(g);
            }
        }

        System.out.println(economicGames);

    }
}
