package ru.academits.gusev.shapes;

public class Circle implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Окружность с радиусом - " + radius;
    }

    public boolean equals(Circle variant) {
        return radius == variant.getRadius();
    }

    public int hashCode() {
        return (int) radius;
    }
}
