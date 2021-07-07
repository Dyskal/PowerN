package power;

/**
 * Square is a class used to represent a box of the grid.
 */
public class Square {
    private int x; //column position
    private int y; //line position
    private CoinColor color;

    /**
     * Create a Square item with given coordinates.
     *
     * @param x the value of the column position
     * @param y the value of the line position
     */
    public Square(int x, int y) {
        if (x > 0) {
            this.x = x;
        }
        if (y > 0) {
            this.y = y;
        }
        this.color = CoinColor.NONE;
    }

    /**
     * Get the state of the Square.
     *
     * @return the state of the free attribute
     */
    public boolean isFree() {
        return color == CoinColor.NONE;
    }


    /**
     * Get the color of the Square.
     *
     * @return the color attribute
     */
    public CoinColor getColor() {
        return this.color;
    }

    /**
     * Set the color of the Square.
     *
     * @param color the given color to set
     */
    public void setColor(CoinColor color) {
        try {
            if (color != null) {
                this.color = color;
            } else {
                System.out.println("setColor: null parameter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("setColor: incorrect color");
        }
    }

    /**
     * Get the value of the x coordinate of the Square.
     *
     * @return the value of the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the value of the y coordinate of the Square.
     *
     * @return the value of the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Print the state of the Square.
     *
     * @return the symbol of the state
     */
    public String toString() {
        String color = " ";
        if (this.color == CoinColor.YELLOW) {
            color = "X";
        } else if (this.color == CoinColor.RED){
            color = "O";
        }
        return color;
    }
}
