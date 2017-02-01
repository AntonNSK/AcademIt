package ru.academits.gusev.shapes;

public class Rectangle extends Shape {
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public double getWidth() {
        return sideLength1;
    }

    public double getHeight() {
        return sideLength2;
    }

    public double getArea() {
        return sideLength1 * sideLength2;
    }

    public double getPerimeter() {
        return (sideLength1 + sideLength2) * 2;
    }

    public String toString() {
        return "Прямоугольник со сторонами - " + sideLength1 + ", " + sideLength2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(rectangle.sideLength1, sideLength1) != 0) return false;
        return Double.compare(rectangle.sideLength2, sideLength2) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideLength1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideLength2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
