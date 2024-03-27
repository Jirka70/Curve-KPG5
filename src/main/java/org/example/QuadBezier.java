package org.example;

import java.util.ArrayList;
import java.util.List;

public class QuadBezier implements Curve {

    public List<Point> calculateCurve(Point[] controlPoints) {
        List<Point> points = new ArrayList<>();
        for (double t = 0; t < 1; t += 0.01) {
            double x = controlPoints[1].x + Math.pow(1 - t, 2) * (controlPoints[0].x - controlPoints[1].x)
                    + (t*t) * (controlPoints[2].x - controlPoints[1].x);
            double y = controlPoints[1].y + Math.pow(1 - t, 2) * (controlPoints[0].y - controlPoints[1].y)
                    + (t*t) * (controlPoints[2].y - controlPoints[1].y);
            points.add(new Point(x,y));
        }

        return points;
    }
}
