package com.isep.jbmo60927.gameoflife.board;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.isep.jbmo60927.gameoflife.error.GameOfLifeException;

public class GameOfLife {

    //logger for this class
    private static final Logger LOGGER = Logger.getLogger(GameOfLife.class.getName());

    private int rowCount;
    private int columnCount;

    private int[][] grid;

    //allow to easily disable color for the game (can be not implemented in some terminal and in logs)
    private static final boolean ENABLE_COLOR = true;

    //color to use if enable
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_RESET = "\u001B[0m";

    //char to use on display
    private static final char ALIVE_CHAR = 'X';
    private static final char DEAD_CHAR = 'O';

    /**
     * setup the game of life
     * @param rowCount
     * @param columnCount
     * @param coords list of coord we wants to initialise at the beginning
     * @throws GameOfLifeException throw when grid is empty
     */
    public GameOfLife(int rowCount, int columnCount, Coord[] coords) throws GameOfLifeException {
        LOGGER.setLevel(Level.INFO);
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.grid = initGrid(rowCount, columnCount);
        setLivingCells(coords);

        if (this.grid.length == 0)
            throw new GameOfLifeException("grid empty");

    }

    /**
     * Initialize the grid with dead cells
     */
    public static int[][] initGrid(int rowCount, int columnCount){
        if (rowCount > 1 && columnCount > 1) {
            int[][] grid = new int [rowCount][columnCount];
            for (int y = 0; y < rowCount; y++) {
                Arrays.fill(grid[y], CellState.DEAD);
            }
            return grid;
        } else {
            return new int[0][0];
        }
    }

    /**
     * Given a list of coordinates, sets the initial living cells
     * @param coords : List of coordinates indicating the position of the initial living cells
     */
    public void setLivingCells(Coord[] coords){
        for(Coord coord : coords) {
            setLivingCell(coord.getX(), coord.getY());
        }

        if (LOGGER.isLoggable(Level.INFO))
            LOGGER.log(Level.INFO, String.format("Initialized grid with living cells%n%s", getGrid(rowCount, columnCount, grid)));
    }

    /**
     *  Given a row and a column number, sets the corresponding cell to a living state if allowed
     * @param row
     * @param column
     */
    public void setLivingCell(int row, int column) {
        if (row >= 0 && column >= 0 && row < rowCount && column < columnCount)
            this.grid[row][column] = CellState.ALIVE;
    }

    /**
     * Minimalistic printing method for the grid : TODO improve if you want
     */
    public static String getGrid(int rowCount, int columnCount, int[][] grid){
        StringBuilder stBuilder = new StringBuilder();
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < columnCount; j++) {
                if (grid[i][j] == CellState.ALIVE)
                    stBuilder.append(String.format("%s%c ", ENABLE_COLOR ? GameOfLife.ANSI_WHITE : "", GameOfLife.ALIVE_CHAR));
                else 
                    stBuilder.append(String.format("%s%c ", ENABLE_COLOR ? GameOfLife.ANSI_BLACK : "", GameOfLife.DEAD_CHAR));
            }
            stBuilder.append("\n");
        }
        if (Boolean.TRUE.equals(ENABLE_COLOR))
            stBuilder.append(GameOfLife.ANSI_RESET);
        return stBuilder.toString();
    }

    /**
     * Computes the nth next generation of the grid (i.e. updates all the cells states)
     * @param n Number or iteration to be executed
     */
    public void computeNthGeneration(int n){
        for(int i = 1; i <= n; i++) {
            String returnedGrid = computeNextGeneration(); //we compute the next generation
            if (LOGGER.isLoggable(Level.INFO)) //and display the result if we wants to display the logs
                LOGGER.log(Level.INFO, String.format("Computing generation num.%d%n%s", i, returnedGrid));
        }
    }

    /**
     * For a given cell, returns the number or adjacent living neighbors
     * @param row cell row
     * @param column cell column
     * @return the number of living neighbors
     */
    public static int countlivingNeighbours(int row, int column, int rowCount, int columnCount, int[][] grid) {
        int[][] cellsToCheck = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
                {row, column - 1},
        };
        int livingNeighbours = 0;
        for (int i = 0; i < cellsToCheck.length; i++) {
            int rowToCheck = cellsToCheck[i][0];
            int colTocheck = cellsToCheck[i][1];
            if (isInTheGrid(rowToCheck, colTocheck, rowCount, columnCount)) {
                livingNeighbours+= grid[rowToCheck][colTocheck];
            }
        }
        return livingNeighbours;
    }

    /**
     * Indicates wether some coordinates are in the grid boundaries
     * @param row
     * @param col
     * @param rowCount
     * @param columnCount
     * @return
     */
    public static boolean isInTheGrid(int row, int col, int rowCount, int columnCount) {
        return row >= 0 && col >= 0 && row < rowCount && col < columnCount;
    }

    /**
     * Computes the next generation for the grid
     */
    public String computeNextGeneration() {
        int[][] nextGenerationGrid = new int[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                int livingNeighbours = countlivingNeighbours(row, col, rowCount, columnCount, grid);
                int cellCurrentState = grid[row][col];
                Cell cell = new Cell(cellCurrentState, livingNeighbours);

                nextGenerationGrid[row][col] = cell.nextState();
            }
        }
        grid = nextGenerationGrid.clone();
        return getGrid(rowCount, columnCount, grid);
    }

    public int[][] getGrid() {
        return grid;
    }
}
