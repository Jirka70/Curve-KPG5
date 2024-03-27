package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoonsCubic implements Curve {
    public List<Point> calculateCurve(Point[] controlPoints) {
        List<Point> l = new ArrayList<>();

        for (double t = 0; t < 1; t += 0.01) {
            double c0 = -Math.pow(t, 3) + 3 * (t*t) - 3 * t + 1;
            double c1 = 3 * Math.pow(t, 3) - 6 * (t*t) + 4;
            double c2 = -3 * (t*t*t) + 3 * (t*t) + 3*t + 1;
            double c3 = t*t*t;
            double x = (1 / 6.0) * (controlPoints[0].x * c0 + controlPoints[1].x * c1 + controlPoints[2].x * c2 + controlPoints[3].x * c3);
            double y = (1 / 6.0) * (controlPoints[0].y * c0 + controlPoints[1].y * c1 + controlPoints[2].y * c2 + controlPoints[3].y * c3);
            l.add(new Point(x,y));
        }
        return l;
    }
}
