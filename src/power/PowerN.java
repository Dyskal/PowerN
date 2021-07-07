package power;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * PowerN is a class used to configure the settings of the game.
 */
public class PowerN {
    private int width;
    private int height;
    private int power;
    private Mode mode;

    /**
     * Create a PowerN game with a given configuration file and two player names.
     *
     * @param fileName the name of the configuration file
     * @param name1 the name of the first player
     * @param name2 the name of the second player
     */
    public PowerN(String fileName, String name1, String name2) {
        if (fileName == null) {
            fileName = "";
        }
        this.configure(fileName);
        this.printConfiguration();
        new Game(name1, name2, width, height, power, mode).start();
    }

    /**
     * Configure the attributes with a given configuration file.
     *
     * @param fileName the name of the configuration file
     */
    private void configure(String fileName) {
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            sc.useDelimiter(":");
            while (sc.hasNext()) {
                int temp = sc.nextInt();
                if (temp > 0) {
                    this.width = temp;
                } else {
                    this.width = 7;
                }

                temp = sc.nextInt();
                if (temp > 0) {
                    this.height = temp;
                } else {
                    this.height = 6;
                }

                temp = sc.nextInt();
                if (temp > 0) {
                    this.power = temp;
                } else {
                    this.power = 4;
                }

                try {
                    this.mode = Mode.valueOf(sc.next().trim());
                } catch (IllegalArgumentException e) {
                    this.mode = Mode.HA;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("configure: file not found: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Print the configuration to verify the configuration.
     */
    private void printConfiguration() {
        System.out.printf("%s %s %s %s%n", this.width, this.height, this.power, this.mode);
    }
}
