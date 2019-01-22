package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Ex03Voina {
    private static BufferedReader reader;
    private static Deque<Integer> playerOne;
    private static Deque<Integer> playerTwo;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        playerOne = new ArrayDeque<>();
        playerTwo = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        handOutCards();
        playTheGame();

        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerTwo.size() > playerOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void playTheGame() {
        for (int i = 0; ! playerOne.isEmpty() && ! playerTwo.isEmpty() && i < 50; i++) {
            int playerOneCard = playerOne.removeFirst();
            int playerTwoCard = playerTwo.removeFirst();

            if (playerOneCard > playerTwoCard) {
                playerOne.addLast(playerOneCard);
                playerOne.addLast(playerTwoCard);
            } else if (playerTwoCard > playerOneCard) {
                playerTwo.addLast(playerOneCard);
                playerTwo.addLast(playerTwoCard);
            }
        }
    }

    private static void handOutCards() throws IOException {
        playerOne = getCollect();
        playerTwo = getCollect();
    }

    private static ArrayDeque<Integer> getCollect() throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
