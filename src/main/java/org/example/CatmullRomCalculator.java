package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatmullRomCalculator implements Curve {

    public static Point evaluateCatmullRom(double t, Point[] controlPoints) {
        double[] tVector = {t * t * t, t * t, t, 1};

        double[][] basisMatrix = {
                {-0.5,  1.5, -1.5,  0.5},
                { 1.0, -2.5,  2.0, -0.5},
                {-0.5,  0.0,  0.5,  0.0},
                { 0.0,  1.0,  0.0,  0.0}
        };

        Point result = new Point();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.x += basisMatrix[i][j] * controlPoints[j].x * tVector[i];
                result.y += basisMatrix[i][j] * controlPoints[j].y * tVector[i];
            }
        }

        return result;
    }

    public List<Point> calculateCurve(Point[] controlPoints) {

        int numPoints = 100;
        List<Point> splinePoints = new ArrayList<>();

        for (int i = 0; i < numPoints; i++) {
            double t = (double) i / (numPoints - 1);
            Point point = evaluateCatmullRom(t, controlPoints);
            splinePoints.add(point);
        }

        return splinePoints;
    }
}



