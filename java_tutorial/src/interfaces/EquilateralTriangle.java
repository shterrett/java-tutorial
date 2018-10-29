package interfaces;

public class EquilateralTriangle implements RegularPolygon {
    final int sideLength;

    public EquilateralTriangle(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int getNumSides() {
        return 3;
    }

    @Override
    public int getSideLength() {
        return sideLength;
    }
}
