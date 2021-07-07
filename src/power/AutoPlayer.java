package power;

import java.util.Random;

/**
 * AutoPlayer is a class used to create and handle automatic players for the game.
 */
public class AutoPlayer extends Player {
    Random random;

    /**
     * Create an AutoPlayer with a given name, board and color.
     *
     * @param name  the name of the player
     * @param board the board linked to the player
     * @param color the color of the player
     */
    public AutoPlayer(String name, Board board, CoinColor color) {
        super(name, board, color);
        if (this.name == null) {
            this.name = "Auto";
        }
        random = new Random();
    }

    /**
     * Make a move with a random choice of a column.
     * Replay until the column is valid.
     */
    public void play() {
        boolean played;
        do {
            int x = random.nextInt(board.getWidth());
            played = board.changeCoin(x, color);
        } while (!played);
    }
}
