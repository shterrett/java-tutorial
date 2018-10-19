package oo_better;

import lombok.Getter;

public class Circle {
    @Getter private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void setArea(double area) {
        this.radius = Math.sqrt(area / Math.PI);
    }

    @Override
    public String toString() {
        return String.format("CIRCLE: radius = %s", getRadius());
    }
}
