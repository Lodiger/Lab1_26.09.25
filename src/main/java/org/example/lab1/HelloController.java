package org.example.lab1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

import javafx.scene.input.MouseEvent;


public class HelloController {
    @FXML
    private Canvas can;
    @FXML
    private ComboBox<String> shapeBox;
    @FXML
    private ColorPicker colorPicker;
    // Очистка Canvas
    @FXML
    public void clearCanvas() {
        GraphicsContext gr = can.getGraphicsContext2D();
        gr.clearRect(0, 0, can.getWidth(), can.getHeight());
    }

    private final ShapeFactory factory = new ShapeFactory();

    @FXML
    private void initialize() {
        shapeBox.getItems().addAll("Окружность", "Прямая", "Угол", "Треугольник", "Квадрат", "Пятиугольник");
        shapeBox.getSelectionModel().selectFirst();
        colorPicker.setValue(Color.BLACK);

        // Рисуем фигуру по клику мыши
        can.setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();
            String selected = shapeBox.getSelectionModel().getSelectedItem();
            int numberOfSides = switch (selected) {
                case "Окружность" -> 0;
                case "Прямая" -> 1;
                case "Угол" -> 2;
                case "Треугольник" -> 3;
                case "Квадрат" -> 4;
                case "Пятиугольник" -> 5;
                default -> -1;
            };
            Shape shape = factory.createShape(numberOfSides);
            if (shape != null) {
                shape.drawAt(can.getGraphicsContext2D(), clickX, clickY, colorPicker.getValue());
            }
        });
    }
}