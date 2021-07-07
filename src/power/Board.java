package power;

import view.GridTableFrame;

/**
 * Board is a class used to create and manage the game's board.
 */
public class Board {
    private int width; //column (x)
    private int height; //line (y)
    private int power;
    private Square[][] grid;
    public GridTableFrame otframe;

    /**
     * Create an empty board with a given size.
     *
     * @param width the width of the board
     * @param height the height of the board
     * @param power the number of coins to align
     */
    public Board(int width, int height, int power) {
        if (width > 0 && height > 0 && power > 0) {
            this.width = width;
            this.height = height;
            this.power = power;
            initializeGrid();
            otframe = new GridTableFrame(this.grid);
            otframe.showIt();
        } else {
            System.out.println("Board: negative value");
        }
    }

    /**
     * Initialize the grid with empty Squares.
     */
    private void initializeGrid() {
        this.grid = new Square[this.height][this.width];
        for (int l = 0; l < this.height; l++) {
            for (int c = 0; c < this.width; c++) {
                this.grid[l][c] = new Square(c, l);
            }
        }
    }

    /**
     * Check if a player has aligned N coins.
     * @param color the color to check
     *
     * @return true if the color has power coins aligned
     */
    public boolean checkAlignment(CoinColor color) {
        return checkHAlignment(color) || checkVAlignment(color) || checkDAlignment(color);
    }

    /**
     * Check if a player has aligned N coins horizontally.
     * @param color the color to check
     *
     * @return true if the color has power coins aligned
     */
    private boolean checkHAlignment(CoinColor color) {
        boolean ret = false;
        for (int i = 0; i < this.width && !ret; i++) {
            int cpt = 0;
            for (int j = this.height - 1; j >= 0 && !ret; j--) {
                if (this.grid[j][i].getColor() == color) {
                    cpt++;
                } else {
                    cpt = 0;
                }

                if (cpt >= power) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    /**
     * Check if a player has aligned N coins vertically.
     * @param color the color to check
     *
     * @return true if the color has power coins aligned
     */
    private boolean checkVAlignment(CoinColor color) {
        boolean ret = false;
        for (int i = 0; i < this.height && !ret; i++) {
            int cpt = 0;
            for (int j = this.width - 1; j >= 0 && !ret; j--) {
                if (this.grid[i][j].getColor() == color) {
                    cpt++;
                } else {
                    cpt = 0;
                }

                if (cpt >= power) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    /**
     * Check if a player has aligned N coins diagonally.
     * @param color the color to check
     *
     * @return true if the color has power coins aligned
     */
    private boolean checkDAlignment(CoinColor color) {
        boolean ret = false;

        for (int i = 0; i < this.height && !ret; i++) {
            for (int j = 0; j < this.width - this.power + 1 && !ret; j++) {
                int cpt = 0;
                int row = i;
                int col = j;
                boolean exit = false;
                while (row < this.height && col < this.width && !ret && !exit) {
                    if (this.grid[row][col].getColor() == color) {
                        cpt++;
                        if (cpt == this.power) {
                            ret = true;
                        }
                        row++;
                        col++;
                    } else {
                        exit = true;
                    }
                }
            }
        }

        for (int i = 0; i < this.height && !ret; i++) {
            for (int j = this.width - 1; j > this.power - 2 && !ret; j--) {
                int cpt = 0;
                int row = i;
                int col = j;
                boolean exit = false;
                while (row < this.height && col < this.width && !ret && !exit) {
                    if (this.grid[row][col].getColor() == color) {
                        cpt++;
                        if (cpt == this.power) {
                            ret = true;
                        }
                        row++;
                        col--;
                    } else {
                        exit = true;
                    }
                }
            }
        }

        return ret;
    }

    /**
     * Put a coin in the given column.
     *
     * @param x the value of the column
     * @param color the color to set
     * @return true if the coin was sucesfully set
     */
    public boolean changeCoin(int x, CoinColor color) {
        boolean placed = false;
        if (x >= 0 && x < this.width && color != null) {
            int y = checkCoin(x);
            if (y != -1) {
                System.out.println("Column " + this.grid[y][x].getX() + " | Line " + this.grid[y][x].getY());
                this.grid[y][x].setColor(color);
                placed = true;
                otframe.hasChanged(y, x);
            } else {
                System.out.println("The column is full! Try another.");
            }
        } else {
            System.out.println("The column is invalid. Try another.");
        }
        return placed;
    }

    /**
     * Get the minimum place where a coin should be placed in the given column.
     *
     * @param x the coordinate of the column
     * @return the minimum place for the coin
     */
    private int checkCoin(int x) {
        int place = -1;
        if (x >= 0 && x < this.width) {
            for (int i = this.height - 1; i >= 0 && place == -1; i--) {
                if (this.grid[i][x].isFree()) {
                    place = i;
                }
            }
        } else {
            System.out.println("checkCoin: invalid value");
        }
        return place;
    }

    /**
     * Get the width (aka. the number of columns).
     *
     * @return the value of the width of the board
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Get the height (aka. the number of lines).
     *
     * @return the value of the height of the board
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Print the board.
     *
     * @return a String of the board
     */
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            ret.append("|");
            for (int j = 0; j < this.width; j++) {
                ret.append(this.grid[i][j]).append("|");
            }
            ret.append("\n");
        }
        return ret.toString();
    }
}
