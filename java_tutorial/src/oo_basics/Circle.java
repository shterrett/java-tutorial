package oo_basics;

public class Circle {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void setArea(double area) {
        this.radius = Math.sqrt(area / Math.PI);
    }
}
