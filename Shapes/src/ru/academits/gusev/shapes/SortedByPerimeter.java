package ru.academits.gusev.shapes;

import java.util.Comparator;

class SortedByPerimeter implements Comparator<Shape> {
    public int compare(Shape s1, Shape s2) {
        if (s1.getPerimeter() > s2.getPerimeter()) {
            return 1;
        } else if (s1.getPerimeter() < s2.getPerimeter()) {
            return -1;
        } else {
            return 0;
        }
    }
}
