package power;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * HumanPlayer is a class used to create and handle human players for the game.
 */
public class HumanPlayer extends Player {
    private final Scanner scan;

    /**
     * Create a HumanPlayer with a given name, board and color.
     *
     * @param name the name of the player
     * @param board the board linked to the player
     * @param color the color of the player
     */
    public HumanPlayer(String name, Board board, CoinColor color) {
        super(name, board, color);
        if (this.name == null) {
            this.name = "Human";
        }
        scan = new Scanner(System.in);
    }

    /**
     * Make a move with a choice of a column.
     * Replay until the column is valid.
     */
    public void play() {
        boolean played = false;
        do {
            System.out.println("Enter a column:");
            int x;
            try {
                x = scan.nextInt();
                played = board.changeCoin(x, color);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.next();
            }
        } while (!played);
    }
}
