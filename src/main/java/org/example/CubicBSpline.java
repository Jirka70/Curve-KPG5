package org.example;

import java.util.ArrayList;
import java.util.List;

public class CubicBSpline implements Curve {
    @Override
    public List<Point> calculateCurve(Point[] controlPoints) {
        List<Point> points = new ArrayList<>();
        Point b0 = controlPoints[0];
        Point b1 = controlPoints[1];
        Point b2 = controlPoints[2];
        Point b3 = controlPoints[3];

        for (double t = 0; t < 1; t += 0.01) {
            double x = (1 / 6.0) * ((-b0.x + 3*b1.x - 3*b2.x + b3.x) * Math.pow(t, 3) + (3 * b0.x - 6 * b1.x + 3*b2.x) * Math.pow(t,2) + (-3*b0.x + 3 * b2.x) * t + (b0.x + 4*b1.x + b2.x));
            double y = (1 / 6.0) * ((-b0.y + 3*b1.y - 3*b2.y + b3.y) * Math.pow(t, 3) + (3 * b0.y - 6 * b1.y + 3*b2.y) * Math.pow(t,2) + (-3*b0.y + 3 * b2.y) * t + (b0.y + 4*b1.y + b2.y));
            points.add(new Point(x,y));
        }

        return points;
    }
}
