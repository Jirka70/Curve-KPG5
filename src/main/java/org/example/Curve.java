package org.example;

import java.util.List;

public interface Curve {
    List<Point> calculateCurve(Point[] controlPoints);
}
