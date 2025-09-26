package org.example.lab1;

public class ShapeFactory {
    public Shape createShape(int numberOfSides) {
        return switch (numberOfSides) {
            case 0 -> new Circle();
            case 1 -> new Straight();
            case 2 -> new Angle();
            case 3 -> new Triangle();
            case 4 -> new Square();
            case 5 -> new Pentagon();
            default -> null;
        };
    }
}