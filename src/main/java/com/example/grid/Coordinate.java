package com.example.grid;

public class Coordinate {

    public final int row;
    public final int col;

    /**
     * Create a new coordinate representing a point on the grid
     * 
     * @param row the coordinate's row (y)
     * @param col the coordinate's column (x)
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Coordinate)) {
            return false;
        }

        Coordinate coordinateObject = (Coordinate) obj;
        return this.row == coordinateObject.row && this.col == coordinateObject.col;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return row + col;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{ row='" + row + "', col='" + col + "' }";
    }
}
