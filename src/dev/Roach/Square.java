package dev.Roach;

public class Square extends Rectangle{

    public Square(int side) {
       super(side, side);
    }

    public int calculateDiameter(){
        return 4 * getShorterSide();
    }

}
