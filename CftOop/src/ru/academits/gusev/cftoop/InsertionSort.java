package ru.academits.gusev.cftoop;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort {
    public static <T> void sort(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (comparator.compare(list.get(i), list.get(j)) < 0) {
                    list.add(j, list.get(i));
                    list.remove(i + 1);
                    break;
                }
            }
        }
    }
}
