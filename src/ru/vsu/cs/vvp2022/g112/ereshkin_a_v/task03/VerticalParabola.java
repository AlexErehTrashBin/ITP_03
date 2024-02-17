package ru.vsu.cs.vvp2022.g112.ereshkin_a_v.task03;

/**
 * "Вертикальная" парабола вида y = a * (x - x0) + y0
 */
public class VerticalParabola {
    public double x0;
    public double y0;
    public double a;

    public VerticalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointAboveTheParabola(double x, double y) {
        return y > a * (x - x0) * (x - x0) + y0;
    }
}
