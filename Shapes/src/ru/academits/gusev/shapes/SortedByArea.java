package ru.academits.gusev.shapes;

import java.util.Comparator;

class SortedByArea implements Comparator<Shape> {
    public int compare(Shape s1, Shape s2) {
        if (s1.getArea() > s2.getArea()) {
            return 1;
        } else if (s1.getArea() < s2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
