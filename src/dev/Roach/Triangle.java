package dev.Roach;

public class Triangle implements GeometricFigure {

    private int baseSide;
    private int height;

    public Triangle(int baseSide, int height) {
        this.baseSide = Math.max(baseSide, 0);
        this.height = Math.max(height, 0);
    }

    @Override
    public int calculateArea() {
        return (baseSide * height) / 2;
    }
}
