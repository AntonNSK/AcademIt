package ru.academits.gusev.range;

public class Main {
    public static void main(String[] args) {
        double number = 25.1;

        Range range = new Range(1, 10);
        range.setFrom(11.5);
        range.setTo(21.3);

        if (range.isInside(number)) {
            System.out.printf("Число %.2f принадлежит диапазону от %.2f до %.2f", number, range.getFrom(), range.getTo());
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону от %.2f до %.2f", number, range.getFrom(), range.getTo());
        }
        System.out.printf(System.lineSeparator() + "Длина интервала: %.2f", range.lengthRange());
    }
}

