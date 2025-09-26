package org.example.lab1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shapes {
}

// Интерфейс Shape (package-private)
interface Shape {
    void draw(GraphicsContext gr); // LEGACY
    void drawAt(GraphicsContext gr, double x, double y, Color color); // новая для клика
}

// Круг
class Circle implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        gr.fillOval(25, 25, 225, 225);
    }

    @Override
    public void drawAt(GraphicsContext gr, double x, double y, Color color) {
        gr.setFill(color);
        gr.fillOval(x - size / 2, y - size / 2, size, size);
    }
}

// Квадрат
class Square implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        gr.fillRect(25, 25, 200, 200);
    }

    @Override
    public void drawAt(GraphicsContext gr, double x, double y, Color color) {
        gr.setFill(color);
        gr.fillRect(x - size / 2, y - size / 2, size, size);
    }
}

// Треугольник
class Triangle implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        double[] x = {150, 25, 275};
        double[] y = {25, 250, 250};
        gr.fillPolygon(x, y, 3);
    }

    @Override
    public void drawAt(GraphicsContext gr, double xCenter, double yCenter, Color color) {
        gr.setFill(color);
        double half = size / 2;
        double[] x = {xCenter, xCenter - half, xCenter + half};
        double[] y = {yCenter - half, yCenter + half, yCenter + half};
        gr.fillPolygon(x, y, 3);
    }
}

// Пятиугольник
class Pentagon implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        double[] x = {150, 50, 75, 225, 250};
        double[] y = {25, 100, 225, 225, 100};
        gr.fillPolygon(x, y, 5);
    }

    @Override
    public void drawAt(GraphicsContext gr, double xCenter, double yCenter, Color color) {
        gr.setFill(color);
        double half = size / 2;
        double[] x = {xCenter, xCenter - half, xCenter - half/2, xCenter + half/2, xCenter + half};
        double[] y = {yCenter - half, yCenter - half/2, yCenter + half, yCenter + half, yCenter - half/2};
        gr.fillPolygon(x, y, 5);
    }
}

// Прямой угол
class Angle implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        gr.setLineWidth(10);
        gr.strokeLine(25, 25, 250, 25);
        gr.strokeLine(30, 25, 30, 250);
    }

    @Override
    public void drawAt(GraphicsContext gr, double x, double y, Color color) {
        gr.setStroke(color);
        gr.setLineWidth(10);
        gr.strokeLine(x, y, x + size, y);
        gr.strokeLine(x, y, x, y + size);
    }
}

// Прямая линия
class Straight implements Shape {
    private final double size = 100;

    @Override
    public void draw(GraphicsContext gr) {
        gr.setLineWidth(5);
        gr.strokeLine(25, 25, 250, 250);
    }

    @Override
    public void drawAt(GraphicsContext gr, double x, double y, Color color) {
        gr.setStroke(color);
        gr.setLineWidth(5);
        gr.strokeLine(x - size/2, y - size/2, x + size/2, y + size/2);
    }
}