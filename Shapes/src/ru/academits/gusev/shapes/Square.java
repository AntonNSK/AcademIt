package ru.academits.gusev.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    public String toString() {
        return "Квадрат со стороной - " + sideLength;
    }

    public boolean equals(Square variant) {
        return sideLength == variant.getSideLength();
    }

    public int hashCode() {
        return (int) sideLength;
    }
}
