package com.example.grid;

import java.util.ArrayList;
import java.util.Iterator;

public class Grid<E> implements IGrid<E> {

    private ArrayList<E> grid;
    
    private int rows;
    private int cols;

    /**
     * Creates a new grid with a given number of rows and columns.
     * Every element in the grid will be set to null
     * 
     * @param rows number of rows in the grid
     * @param cols number of columns in the grid
     */
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.grid = new ArrayList<E>(rows * cols);

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid.add(null);
            }
        }
    }

    /**
     * Creates a new grid filled with a default value
     * 
     * @param rows number of rows in the grid
     * @param cols number of columns in the grid
     * @param defaultValue the default value to fill the grid with
     */
    public Grid(int rows, int cols, E defaultValue) {
        this.rows = rows;
        this.cols = cols;

        grid = new ArrayList<E>(rows * cols);

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid.add(defaultValue);
            }
        }
    }

    @Override
    public Iterator<CoordinateItem<E>> iterator() {
        ArrayList<CoordinateItem<E>> gridElements = new ArrayList<CoordinateItem<E>>();

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                Coordinate coordinate = new Coordinate(y, x);
                gridElements.add(new CoordinateItem<E>(coordinate, this.get(coordinate)));
            }
        }

        return gridElements.iterator();
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public void set(Coordinate coordinate, E value) {
        grid.set(coordinate.row * cols + coordinate.col, value);
    }

    @Override
    public E get(Coordinate coordinate) {
        try {
            return grid.get(coordinate.row * cols + coordinate.col);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        if (0 <= coordinate.row && coordinate.row < this.rows) {
            if (0 <= coordinate.col && coordinate.col < this.cols) {
                return true;
            }
        }

        return false;
    }
    
}
