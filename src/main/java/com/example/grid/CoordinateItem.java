package com.example.grid;

public class CoordinateItem<E> {

    public final Coordinate coordinate;
    public final E item;

    /**
     * Creates a coordinate item which represents an item with a position on a grid
     * 
     * @param coordinate coordinate of the item
     * @param item a generic item
     */
    public CoordinateItem(Coordinate coordinate, E item) {
        this.coordinate = coordinate;
        this.item = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CoordinateItem)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        CoordinateItem<E> coordinateItemObject = (CoordinateItem<E>) obj;
        return this.coordinate.equals(coordinateItemObject.coordinate) && this.item.equals(coordinateItemObject.item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return coordinate.hashCode() + item.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{ coordinate='" + coordinate.toString() + "', item='" + item.toString() + "' }";
    }
}