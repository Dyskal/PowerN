package view;

import javax.swing.*;
import java.awt.Color;
import power.Square;

public class GridTableFrame extends SimpleFrame {
    private final GridTableModel otmodel;

    public GridTableFrame(Square[][] grid) {
        this.setTitle("PowerN");
        int rowHeight = 55;
        //set the grid size
        this.setSize(rowHeight * grid.length + 80, rowHeight * grid[0].length + 7);
        this.setLocationRelativeTo(null);
        otmodel = new GridTableModel(grid);
        JTable tab = new JTable(otmodel);
        // to adjust some parameters
        tab.setShowGrid(true);
        // color for the grid lines
        tab.setGridColor(Color.BLUE);
        tab.setRowHeight(rowHeight);

        JScrollPane SP = new JScrollPane(tab);
        this.getContentPane().add(SP);
    }

    public void hasChanged(int row, int column) {
        otmodel.fireTableCellUpdated(row, column);
    }
}