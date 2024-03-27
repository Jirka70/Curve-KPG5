package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Application {
    private static final Random RANDOM = new Random(42);
    private static final double OFFSET = 50;
    private static final double WIDTH = 1000;
    private static final double HEIGHT = 600;
    private final Pane rootPane = new Pane();
    private final List<Line> displayedLines = new ArrayList<>();
    private final List<Circle> controlPoints = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        HBox buttonBox = new HBox();
        Button bSplineButton = new Button("Cubic B-spline");
        bSplineButton.setOnAction(e -> showCurve(new CubicBSpline(), 4));
        Button cubicBezierButton = new Button("Cubic bezier");
        cubicBezierButton.setOnAction(e -> showCurve(new CubicBezier(), 4));
        Button quadBezierButton = new Button("Quadratic bezier");
        quadBezierButton.setOnAction(e -> showCurve(new QuadBezier(), 3));
        Button catmullRom = new Button("Catmull Rom");
        catmullRom.setOnAction(e -> showCurve(new CatmullRomCalculator(), 4));
        Button coonsCubic = new Button("Coons cubic");
        coonsCubic.setOnAction(e -> showCurve(new CoonsCubic(), 4));
        buttonBox.getChildren().addAll(bSplineButton, cubicBezierButton, quadBezierButton, catmullRom, coonsCubic);
        Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        rootPane.getChildren().add(buttonBox);
    }

    private void showCurve(Curve curve, int numberOfControlPoints) {
        this.controlPoints.clear();
        displayedLines.clear();
        clearPane();
        Point[] controlPoints = new Point[numberOfControlPoints];
        for (int i = 0; i < numberOfControlPoints; i++) {
            double x = RANDOM.nextDouble() * (WIDTH - OFFSET) + OFFSET;
            double y = RANDOM.nextDouble() * (HEIGHT - OFFSET) + OFFSET;
            controlPoints[i] = new Point(x, y);
        }

        drawLine(curve.calculateCurve(controlPoints));

        for (Point point : controlPoints) {
            Circle c = new Circle(point.x, point.y, 5);
            c.setOnMouseDragged(e -> {
                c.setCenterX(e.getX());
                c.setCenterY(e.getY());
                updateLines(curve);
            });
            c.setFill(Color.BLACK);
            this.controlPoints.add(c);
            rootPane.getChildren().add(c);
        }

        for (int i = 0; i < this.controlPoints.size() - 1; i++) {
            Circle startControlPoint = this.controlPoints.get(i);
            Circle endControlPoint = this.controlPoints.get(i+1);
            Line controlLine = new Line();
            controlLine.startXProperty().bind(startControlPoint.centerXProperty());
            controlLine.startYProperty().bind(startControlPoint.centerYProperty());
            controlLine.endXProperty().bind(endControlPoint.centerXProperty());
            controlLine.endYProperty().bind(endControlPoint.centerYProperty());
            controlLine.setStroke(Color.web("rgba(200,100,50,0.5)"));
            rootPane.getChildren().add(controlLine);
        }
    }

    private void clearPane() {
        rootPane.getChildren().removeIf(e -> (e instanceof Line || e instanceof Circle));
    }

    private void drawLine(List<Point> points) {
        displayedLines.clear();
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            Line line = new Line(start.x, start.y, end.x, end.y);
            displayedLines.add(line);
            rootPane.getChildren().add(line);
        }
    }

    private void updateLines(Curve curve) {
        Point[] points = new Point[this.controlPoints.size()];
        for (int i = 0; i < points.length; i++) {
            Circle c = this.controlPoints.get(i);
            Point p = new Point(c.getCenterX(), c.getCenterY());
            points[i] = p;
        }

        List<Point> curvePoints = curve.calculateCurve(points);
        for (int i = 0; i < curvePoints.size() - 1; i++) {
            Point startPoint = curvePoints.get(i);
            Point endPoint = curvePoints.get(i + 1);
            Line start = displayedLines.get(i);
            start.setStartX(startPoint.x);
            start.setStartY(startPoint.y);
            start.setEndX(endPoint.x);
            start.setEndY(endPoint.y);
        }
    }
}
