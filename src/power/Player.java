package power;

/**
 * Player is a class used to create and handle players for the game.
 */
public abstract class Player {
    protected String name;
    protected Board board;
    protected CoinColor color;

    /**
     * Create a Player with a given name, board and color.
     *
     * @param name the name of the player
     * @param board the board linked to the player
     * @param color the color of the player
     */
    public Player(String name, Board board, CoinColor color) {
        if (board == null || color == null) {
            System.out.println("Player: null parameter");
        } else {
            try {
                this.name = name;
                this.board = board;
                this.color = color;
            } catch (IllegalArgumentException e) {
                System.out.println("Player: incorrect color");
            }
        }
    }

    /**
     * Get the printable board of the player.
     *
     * @return the representation of the board
     */
    public String printBoard() {
        return board.toString();
    }

    /**
     * Make a move.
     */
    public abstract void play();
}