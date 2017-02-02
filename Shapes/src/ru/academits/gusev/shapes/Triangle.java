package ru.academits.gusev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    public double getWidth() {
        return Math.max(x3, Math.max(x1, x2)) - Math.min(x3, Math.min(x1, x2));
    }

    public double getHeight() {
        return Math.max(y3, Math.max(y1, y2)) - Math.min(y3, Math.min(y1, y2));
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x1, y1, x3, y3) + getSideLength(x2, y2, x3, y3);
    }

    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        double sideLength1 = getSideLength(x1, y1, x2, y2);
        double sideLength2 = getSideLength(x1, y1, x3, y3);
        double sideLength3 = getSideLength(x2, y2, x3, y3);
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideLength1) * (semiPerimeter - sideLength2) * (semiPerimeter - sideLength3));
    }

    public String toString() {
        return "Треугольник с вершинами - (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ") (" + x3 + "," + y3 + ")";
    }

    public boolean equals(Triangle variant) {
        return x1 == variant.getX1() && y1 == variant.getY1() && x1 == variant.getX2() && y1 == variant.getY2() && x1 == variant.getX3() && y1 == variant.getY3();
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (int) x1;
        result = prime * result + (int) y1;
        result = prime * result + (int) x2;
        result = prime * result + (int) y2;
        result = prime * result + (int) x3;
        return prime * result + (int) y3;
    }
}
