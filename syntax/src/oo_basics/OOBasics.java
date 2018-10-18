package oo_basics;

public class OOBasics {
    public static void main(String[] args) {
        Circle[] circles = new Circle[100];
        for (int i = 0; i < 100; i++) {
            circles[i] = new Circle(Math.random() * 10);
        }
        double totalAreaCirc = 0;
        Circle largestCirc = circles[0];
        Circle smallestCirc = circles[0];
        for (Circle circle: circles) {
            totalAreaCirc += circle.area();
            if (circle.area() > largestCirc.area()) {
                largestCirc = circle;
            }
            if (circle.area() < smallestCirc.area()) {
                smallestCirc = circle;
            }
        }

        System.out.format("Total Circular Area: %f\n", totalAreaCirc);
        System.out.format("Largest Circle radius: %f\n", largestCirc.radius);
        System.out.format("Smallest Circle radius: %f\n", smallestCirc.radius);

        Rectangle[] rectangles = new Rectangle[100];
        for (int i = 0; i < 100; i++) {
            rectangles[i] = new Rectangle(Math.random() * 10, Math.random() * 10);
        }
        double totalAreaRect = 0;
        Rectangle largestRect = rectangles[0];
        Rectangle smallestRect = rectangles[0];
        for (Rectangle rectangle: rectangles) {
            totalAreaRect += rectangle.area();
            if (rectangle.area() > largestRect.area()) {
                largestRect = rectangle;
            }
            if (rectangle.area() < smallestRect.area()) {
                smallestRect = rectangle;
            }
        }

        System.out.format("Total Rectangular Area: %f\n", totalAreaRect);
        System.out.format("Largest Rectangle dimensions: %f x %f\n", largestRect.width, largestRect.height);
        System.out.format("Smallest Rectangle dimensions: %f x %f\n", smallestRect.width, largestRect.height);

        Circle mutant = new Circle(1);
        System.out.format("Mutant radius: %f\n", mutant.radius);
        mutant.setArea(mutant.area() * 2);
        System.out.format("Mutant radius: %f\n", mutant.radius);
        mutant.setArea(mutant.area() / 2);
        System.out.format("Mutant radius: %f\n", mutant.radius);
    }
}
