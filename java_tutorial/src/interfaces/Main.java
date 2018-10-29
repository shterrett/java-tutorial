package interfaces;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        RegularPolygon[] ps = {
                new Square(3),
            new Square(5),
            new EquilateralTriangle(2),
            new Square(8),
            new EquilateralTriangle(2),
            new EquilateralTriangle(1)
        };

        System.out.format("Total Side Count: %d%n", RegularPolygon.totalSides(ps));
        System.out.format("Perimeters: %s%n",
                Arrays.asList(ps)
                .stream()
                .map(RegularPolygon::getPerimeter)
                .collect(Collectors.toList())
                );
        System.out.format("Angles: %s%n",
                Arrays.asList(ps)
                        .stream()
                        .map(RegularPolygon::getInteriorAngle)
                        .collect(Collectors.toList())
        );
    }
}
