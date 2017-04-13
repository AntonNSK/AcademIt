package ru.academits.gusev.cftoop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String help = System.lineSeparator() + "Введите последовательно через пробел 4 аргумента:" +
                System.lineSeparator() + "1й аргумент - путь к входному файлу" +
                System.lineSeparator() + "2й аргумент - путь к выходному файлу" +
                System.lineSeparator() + "3й аргумент - тип содержимого файла (-i - целые числа, -s - строки)" +
                System.lineSeparator() + "4й аргумент - режим сортировки (-a - по возрастанию, -d по убыванию, для строк только -a)" +
                System.lineSeparator() + "Пример(сортировка целых чисел по возрастанию): C:\\Users\\1\\Desktop\\New\\in.txt C:\\Users\\1\\Desktop\\New\\out.txt -i -a";

        try {
            if (args.length != 4) {
                throw new WrongDataException("Не верное количество аргументов" + help);
            }

            boolean isNumber;
            boolean isAscending;

            switch (args[2]) {
                case "-i":
                    isNumber = true;
                    break;
                case "-s":
                    isNumber = false;
                    break;
                default:
                    throw new WrongDataException("Некорректный 3й аргумент" + help);
            }

            switch (args[3]) {
                case "-a":
                    isAscending = true;
                    break;
                case "-d":
                    isAscending = false;
                    break;
                default:
                    throw new WrongDataException("Некорректный 4й аргумент" + help);
            }

            try (PrintWriter writer = new PrintWriter(new FileOutputStream(args[1]));
                 Scanner scanner = new Scanner(new FileInputStream(args[0]))) {

                if (isNumber) {
                    ArrayList<Integer> numbers = new ArrayList<>();
                    while (scanner.hasNextInt()) {
                        numbers.add(scanner.nextInt());
                    }
                    if (isAscending) {
                        InsertionSort.sort(numbers, new IntegerComparator());
                    } else {
                        InsertionSort.sort(numbers, new IntegerComparator().reversed());
                    }
                    for (int e : numbers) {
                        writer.println(e);
                    }
                } else {
                    ArrayList<String> line = new ArrayList<>();
                    while (scanner.hasNextLine()) {
                        line.add(scanner.nextLine());
                    }
                    if (isAscending) {
                        InsertionSort.sort(line, new StringComparator());
                    } else {
                        InsertionSort.sort(line, new StringComparator().reversed());
                    }
                    for (String e : line) {
                        writer.println(e);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден" + help);
            }

        } catch (WrongDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
