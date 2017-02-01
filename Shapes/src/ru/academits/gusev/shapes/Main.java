package ru.academits.gusev.shapes;

import java.util.Arrays;

public class Main {
    public static void seekMaxArea(Shape... shapes) {
        Arrays.sort(shapes, new SortedByArea());
        System.out.println("Фигура с максимальной площадью:");
        System.out.println(shapes[shapes.length - 1].toString());
    }

    public static void seekSecondMaxPerimeter(Shape... shapes) {
        Arrays.sort(shapes, new SortedByPerimeter());
        System.out.println("Фигура с вторым по величине периметром:");
        System.out.println(shapes[shapes.length - 2].toString());
    }

    public static void main(String[] args) {
        Shape s1 = new Square(3);
        Shape s2 = new Triangle(2, 0, 5, 0, 0, 4);
        Shape s3 = new Rectangle(5, 3);
        Shape s4 = new Circle(5);
        Shape s5 = new Square(3);

        seekMaxArea(s1, s2, s3, s4, s5);
        seekSecondMaxPerimeter(s1, s2, s3, s4, s5);
    }
}
