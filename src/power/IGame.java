package power;

/**
 * IGame specifies the usual behavior of a game.
 */
public interface IGame {
    /**
     * Show a welcome message.
     *
     * @return the welcome message
     */
    String description();

    /**
     * Start the game.
     */
    void start();

    /**
     * Print the winner of the game.
     */
    void endOfGame();
}
