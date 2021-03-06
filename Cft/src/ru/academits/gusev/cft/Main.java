package ru.academits.gusev.cft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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

    public static void main(String[] args) {
        String help = System.lineSeparator() + "Введите последовательно через пробел 4 аргумента:" +
                System.lineSeparator() + "1й аргумент - имя входного файла" +
                System.lineSeparator() + "2й аргумент - имя выходного файла" +
                System.lineSeparator() + "3й аргумент - тип содержимого файла (-i - целые числа, -s - строки)" +
                System.lineSeparator() + "4й аргумент - режим сортировки (-a - по возрастанию, -d по убыванию, для строк только -a)" +
                System.lineSeparator() + "Пример(сортировка целых чисел по возрастанию): in.txt out.txt -i -a";
        if (args.length != 4) {
            System.out.println("Не верное колличество аргументов" + help);
            return;
        }
        boolean isNumber, isAscending;
        if (args[2].equals("-i")) {
            isNumber = true;
        } else if (args[2].equals("-s")) {
            isNumber = false;
        } else {
            System.out.println("Некорректный 3й аргумент" + help);
            return;
        }
        if (args[3].equals("-a")) {
            isAscending = true;
        } else if (args[3].equals("-d")) {
            if (isNumber) {
                System.out.println("Строки сортируются только по возрастанию (-a)" + help);
                return;
            }
            isAscending = false;
        } else {
            System.out.println("Некорректный 4й аргумент" + help);
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(args[1]));
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            if (isNumber) {
                ArrayList<Integer> numbers = new ArrayList<>();
                while (scanner.hasNextInt()) {
                    numbers.add(scanner.nextInt());
                }
                if (isAscending) {
                    sortAscending(numbers);
                } else {
                    sortDecreasing(numbers);
                }
                for (int e : numbers) {
                    writer.println(e);
                }
            } else {
                ArrayList<String> lines = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
                sortLines(lines);
                for (String e : lines) {
                    writer.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + help);
        }
    }
}

