package ru.academits.gusev.cft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
    public static void sortAscending(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrayList.get(i) < arrayList.get(j)) {
                    arrayList.add(j, arrayList.get(i));
                    arrayList.remove(i + 1);
                    break;
                }
            }
        }
    }

    public static void sortDecreasing(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrayList.get(i) > arrayList.get(j)) {
                    arrayList.add(j, arrayList.get(i));
                    arrayList.remove(i + 1);
                    break;
                }
            }
        }
    }

    public static void sortLines(ArrayList<String> arrayList) {
        for (int i = 1; i < arrayList.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrayList.get(i).compareTo(arrayList.get(j)) < 0) {
                    arrayList.add(j, arrayList.get(i));
                    arrayList.remove(i + 1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            System.out.println("Не верное колличество аргументов");
            return;
        }
        boolean isNumber;
        boolean isAscending;
        if (args[2].equals("-i")) {
            isNumber = true;
        } else if (args[2].equals("-s")) {
            isNumber = false;
        } else {
            System.out.println("Некорректный аргумент");
            return;
        }
        if (args[3].equals("-a")) {
            isAscending = true;
        } else if (args[3].equals("-d")) {
            isAscending = false;
        } else {
            System.out.println("Некорректный аргумент");
            return;
        }
        if (isNumber) {
            ArrayList<Integer> numbers = new ArrayList<>();
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(args[1]));
                 Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
                while (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                }
                if (isAscending){
                    sortAscending(numbers);
                } else {
                    sortDecreasing(numbers);
                }
                for (int e : numbers) {
                    writer.println(e);
                }
            }
        } else {
            ArrayList<String> lines = new ArrayList<>();
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(args[1]));
                 Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
                if (isAscending) {
                    sortLines(lines);
                } else {
                    System.out.println("Некорректный аргумент");
                    return;
                }
                for (String e : lines) {
                    writer.println(e);
                }
            }
        }
    }
}

