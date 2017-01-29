package ru.academits.gusev.range;

public class Main {
    public static void main(String[] args) {
        double number = 25.1;

        Range range1 = new Range(1, 10);
        Range range2 = new Range(7.3, 15.5);
        range1.setFrom(5.9);
        range1.setTo(21.3);

        if (range1.isInside(number)) {
            System.out.printf("Число %.2f принадлежит диапазону от %.2f до %.2f", number, range1.getFrom(), range1.getTo());
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону от %.2f до %.2f", number, range1.getFrom(), range1.getTo());
        }

        Range intersection = range1.doIntersection(range2);
        if (intersection == null) {
            System.out.printf(System.lineSeparator() + "Интервалы не пересекаются");
        } else {
            System.out.printf(System.lineSeparator() + "Пересечение интервалов - интервал от %.2f до %.2f", intersection.getFrom(), intersection.getTo());
        }

        Range union = range1.doUnion(range2);
        if (range1.isInside(range2.getFrom()) || range1.isInside(range2.getTo())) {
            System.out.printf(System.lineSeparator() + "Объединение интервалов - интервал от %.2f до %.2f", union.getFrom(), union.getTo());
        } else {
            System.out.printf(System.lineSeparator() + "Объединение интервалов - интервал от %.2f до %.2f и интервал от %.2f до %.2f", union.getFrom(), union.getTo(), union.getFrom1(), union.getTo1());
        }

        Range difference = range1.doDifference(range2);
        if (range1.isInside(range2.getFrom()) && range1.isInside(range2.getTo())) {
            System.out.printf(System.lineSeparator() + "Вычитание интервалов - интервал от %.2f до %.2f и интервал от %.2f до %.2f", difference.getFrom(), difference.getTo(), difference.getFrom1(), difference.getTo1());
        } else {
            System.out.printf(System.lineSeparator() + "Вычитание интервалов - интервал от %.2f до %.2f", difference.getFrom(), difference.getTo());
        }
    }
}

