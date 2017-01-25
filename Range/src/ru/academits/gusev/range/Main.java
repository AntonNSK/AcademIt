package ru.academits.gusev.range;

public class Main {
    public static void main(String[] args) {
        int number = 15;

        Range range = new Range(1, 10);
        range.setFrom(11);
        range.setTo(21);

        if (range.isInside(number)) {
            System.out.printf("Число %d принадлежит диапазону от %d до %d", number, range.getFrom(), range.getTo());
        } else {
            System.out.printf("Число %d не принадлежит диапазону от %d до %d", number, range.getFrom(), range.getTo());
        }
    }
}

