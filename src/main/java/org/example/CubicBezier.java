package org.example;

import java.util.ArrayList;
import java.util.List;

public class CubicBezier implements Curve {
    public List<Point> calculateCurve(Point[] controlPoints) {
        List<Point> points = new ArrayList<>();
        for (double t = 0; t < 1; t += 0.001) {
            double x = Math.pow(1 - t, 3) * controlPoints[0].x
                    + 3 * Math.pow(1 - t,2) * t * controlPoints[1].x
                    + 3 * (1 - t) * (t*t) * controlPoints[2].x
                    + (t*t*t) * controlPoints[3].x;
            double y = Math.pow(1 - t, 3) * controlPoints[0].y
                    + 3 * Math.pow(1 - t,2) * t * controlPoints[1].y
                    + 3 * (1 - t) * (t*t) * controlPoints[2].y
                    + (t*t*t) * controlPoints[3].y;
            points.add(new Point(x,y));
        }

        return points;
    }
}
