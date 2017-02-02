package ru.academits.gusev.shapes;

public class Rectangle implements Shape {
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

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return sideLength1 == rectangle.sideLength1 && sideLength2 == rectangle.sideLength2;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (int) sideLength1;
        return prime * result + (int) sideLength2;
    }
}
