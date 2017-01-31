package ru.academits.gusev.shapes;


public class Main {
    public static void seekMaxArea(Shape... numbers) {
        double maxArea = 0.0;
        for (Shape s : numbers) {
            if (s.getArea() > maxArea) {
                maxArea = s.getArea();
            }
        }
        System.out.printf("%.2f", maxArea);
    }

    public static void seekSecondMaxPerimetr(Shape... numbers) {
        double maxPerimeter = 0.0;
        double secondMaxPerimeter = 0.0;
        for (Shape s : numbers) {
            if (s.getPerimeter() >= maxPerimeter) {
                secondMaxPerimeter = maxPerimeter;
                maxPerimeter = s.getPerimeter();
            } else if (s.getPerimeter() > secondMaxPerimeter) {
                secondMaxPerimeter = s.getPerimeter();
            }
        }
        System.out.printf(System.lineSeparator() + "%.2f", secondMaxPerimeter);
    }

    public static void main(String[] args) {
        Shape s1 = new Square(6);
        Shape s2 = new Triangle(2, 0, 5, 0, 0, 4);
        Shape s3 = new Rectangle(5, 3);
        Shape s4 = new Circle(5);
        Shape s5 = new Square(3);

        seekMaxArea(s1, s2, s3, s4, s5);
        seekSecondMaxPerimetr(s1, s2, s3, s4, s5);


    }
}
