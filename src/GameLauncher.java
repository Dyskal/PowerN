import power.PowerN;

import java.util.Scanner;

/**
 * GameLauncher is a class used to create a PowerN game.
 */
public class GameLauncher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a config number: (must be N with the file located at ./data/configN.txt");
        String config = sc.next().trim();
        System.out.println("Enter Player 1 name: ");
        String player1 = sc.next().trim();
        System.out.println("Enter Player 2 name: ");
        String player2 = sc.next().trim();
        new PowerN("data/config" + config + ".txt", player1, player2);
    }
}