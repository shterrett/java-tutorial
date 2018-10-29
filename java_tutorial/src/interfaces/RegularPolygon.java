package interfaces;

import java.util.Arrays;

public interface RegularPolygon {
    int getNumSides();
    int getSideLength();

    static int totalSides(RegularPolygon[] ps) {
        return Arrays.asList(ps)
                .stream()
                .map(RegularPolygon::getNumSides)
                .reduce(0, (a, b) -> a + b);
    }

    default int getPerimeter() {
        return this.getNumSides() * this.getSideLength();
    }

    default double getInteriorAngle() {
        return ((this.getNumSides() - 2) * Math.PI) / this.getNumSides();
    }
}
