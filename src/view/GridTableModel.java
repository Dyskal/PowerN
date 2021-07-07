package view;

import power.CoinColor;
import power.Square;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GridTableModel extends AbstractTableModel {

    private final int noOfRows, noOfCols;
    private final Square[][] grid;

    /**
     * Constructor
     * @param grid the table to display
     */
    public GridTableModel(Square[][] grid) {
        this.grid = grid;
        noOfRows = this.grid.length;
        noOfCols = this.grid[0].length;
    }

// Implementing the three abstract methods:
    /**
     * @return the number of row
     */
    public int getRowCount() {
        return noOfRows;
    }

    /**
     * @return the number of column
     */
    public int getColumnCount() {
        return noOfCols;
    }

    /**
     * get the object (image) at the given position
     *
     * @param r the row
     * @param c the column
     * @return an image
     */
    public Object getValueAt(int r, int c) {
        Object result;
        Square sq = grid[r][c]; //Square sq = grid[r][c];  depend du repere
        String PATH = "data/images/";
        if (sq.getColor() == CoinColor.YELLOW) {
            result = new ImageIcon(PATH + "yellow.png");
        }
        else if (sq.getColor() == CoinColor.RED) {
            result = new ImageIcon(PATH + "red.png");
        }
        else {
            result = new ImageIcon(PATH + "empty.png");
        }
        return result;
    }

    /**
     * get the name of the column
     *
     * @param c : the number of the column
     * @return a String for the name of the column
     */
    public String getColumnName(int c){
        return Integer.toString(c);
    }

    /**
     * get the class of the object at column c
     *
     * @param c : the number of the column
     * @return the class of the object at column c
     */
    public Class<?> getColumnClass(int c) {
        return this.getValueAt(0, c).getClass();
    }
}