package ru.academits.gusev.shapes;

import java.util.Arrays;

public class Main {
    public static Shape seekMaxArea(Shape... shapes) {
        Arrays.sort(shapes, new SortedByArea());
        return shapes[shapes.length - 1];
    }

    public static Shape seekSecondMaxPerimeter(Shape... shapes) {
        Arrays.sort(shapes, new SortedByPerimeter());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape s1 = new Square(3);
        Shape s2 = new Triangle(2, 0, 5, 0, 0, 4);
        Shape s3 = new Rectangle(5, 3);
        Shape s4 = new Circle(5);
        Shape s5 = new Square(3);

        System.out.println("Фигура с максимальной площадью:" + System.lineSeparator() + seekMaxArea(s1, s2, s3, s4, s5).toString());
        System.out.println("Фигура со вторым по величине периметром:" + System.lineSeparator() + seekSecondMaxPerimeter(s1, s2, s3, s4, s5).toString());
    }
}
