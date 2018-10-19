package oo_better;

import lombok.Getter;

public class Rectangle {
    @Getter private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("RECTANGLE: length = %s width = %s", getHeight(), getWidth());
    }
}
