package by.epam.learn.function.impl;

import by.epam.learn.function.ShapeService;

public class RectangleService implements ShapeService {
    @Override
    public double perimeter(double a, double b) {
        return 2 * (a + b);
    }
}