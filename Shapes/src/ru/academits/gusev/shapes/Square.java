package ru.academits.gusev.shapes;

public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sideLength);
        return (int) (temp ^ (temp >>> 32));
    }
}
