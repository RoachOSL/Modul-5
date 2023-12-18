package dev.Roach;

public class Hexagon implements GeometricFigure {

    private int sideLength;


    public Hexagon(int sideLength) {
        this.sideLength = Math.max(sideLength, 0);
    }

    @Override
    public int calculateArea() {
        return (int) (((3 * Math.sqrt(3)) / 2) * Math.pow(sideLength, 2));
    }
}
