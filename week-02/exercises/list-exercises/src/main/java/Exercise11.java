import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise11 {

    public static void swap(int firstIndex, int secondIndex, ArrayList<BoardGame> arrayList) {
        BoardGame temp = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, temp);
    }

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Swap the 2nd game with the 4th and the 3rd with the 7th.
        // 2. Print `games` and confirm their order.

        swap(1, 3, games);
        swap(2, 6, games);
        System.out.println(games);

    }
}
