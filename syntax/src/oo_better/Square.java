package oo_better;

public class Square extends Rectangle {
    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public double getSideLength() {
        return this.getWidth();
    }

    @Override
    public String toString() {
        return String.format("SQUARE: side = %s", getSideLength());
    }
}
