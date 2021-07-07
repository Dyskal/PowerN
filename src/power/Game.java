package power;

/**
 * Game is a class used to create and launch a game.
 */
public class Game implements IGame {
    private final int power;
    private final Board board;
    private Player player1;
    private Player player2;
    private Player current;

    /**
     * Create a game with given player names and board parameters.
     *
     * @param playerName1 the name of the player 1
     * @param playerName2 the name of the player 2
     * @param width the width of the board
     * @param height the height of the board
     * @param power the number of coins to align
     * @param mode the mode of the game
     */
    public Game(String playerName1, String playerName2, int width, int height, int power, Mode mode) {
        this.power = power;
        this.board = new Board(width, height, power);
        createPlayers(playerName1, playerName2, mode);
        this.current = this.player1;
    }

    /**
     * Create the 2 players with the given names.
     *
     * @param playerName1 the name of the player 1
     * @param playerName2 the name of the player 2
     * @param mode the mode of the game
     */
    private void createPlayers(String playerName1, String playerName2, Mode mode) {
        if (mode == Mode.HA) {
            this.player1 = new HumanPlayer(playerName1, this.board, CoinColor.YELLOW);
            this.player2 = new AutoPlayer(playerName2, this.board, CoinColor.RED);
        } else if (mode == Mode.HH) {
            this.player1 = new HumanPlayer(playerName1, this.board, CoinColor.YELLOW);
            this.player2 = new HumanPlayer(playerName2, this.board, CoinColor.RED);
        } else if (mode == Mode.AA) {
            this.player1 = new AutoPlayer(playerName1, this.board, CoinColor.YELLOW);
            this.player2 = new AutoPlayer(playerName2, this.board, CoinColor.RED);
        }
    }

    /**
     * Switch the current player from the player 1 to the player 2.
     */
    private void changeCurrent() {
        if (this.current == this.player1) {
            this.current = this.player2;
        } else {
            this.current = this.player1;
        }
    }

    /**
     * Show a welcome message.
     *
     * @return the welcome message
     */
    public String description() {
        return "Welcome to PowerN! Align " + power + " coins to win!";
    }

    /**
     * Start the game.
     */
    public void start() {
        boolean finished = false;
        System.out.println(description());
        changeCurrent();
        for (int i = 0; i < board.getWidth() * board.getHeight() && !finished; i++) {
            changeCurrent();
            current.play();
            System.out.println(current.printBoard());
            finished = board.checkAlignment(current.color);
        }
        endOfGame();
    }

    /**
     * Print the winner of the game.
     */
    public void endOfGame() {
        System.out.println("Game finished!");
        System.out.println("The winner is: " + current.name);
    }
}
