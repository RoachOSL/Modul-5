package dev.Roach;

public class Rectangle implements GeometricFigure {

    private int shorterSide;
    private int longerSide;

    public Rectangle(int shorterSide, int longerSide) {
        this.shorterSide = Math.max(shorterSide, 0);
        this.longerSide = Math.max(longerSide, 0);
    }

    @Override
    public int calculateArea() {
        return shorterSide * longerSide;
    }

    public int getShorterSide() {
        return shorterSide;
    }

    public int getLongerSide() {
        return longerSide;
    }
}
