package ru.academits.gusev.cftoop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String help = System.lineSeparator() + "Введите последовательно через пробел 4 аргумента:" +
                System.lineSeparator() + "1й аргумент - имя входного файла" +
                System.lineSeparator() + "2й аргумент - имя выходного файла" +
                System.lineSeparator() + "3й аргумент - тип содержимого файла (-i - целые числа, -s - строки)" +
                System.lineSeparator() + "4й аргумент - режим сортировки (-a - по возрастанию, -d по убыванию, для строк только -a)" +
                System.lineSeparator() + "Пример(сортировка целых чисел по возрастанию): in.txt out.txt -i -a";
        if (args.length != 4) {
            throw new MyException("Не верное колличество аргументов" + help);
        }
        boolean isNumber, isAscending;
        if (args[2].equals("-i")) {
            isNumber = true;
        } else if (args[2].equals("-s")) {
            isNumber = false;
        } else {
            throw new MyException("Некорректный 3й аргумент" + help);
        }
        if (args[3].equals("-a")) {
            isAscending = true;
        } else if (args[3].equals("-d")) {
            if (!isNumber) {
                throw new MyException("Строки сортируются только по возрастанию (-a)" + help);
            }
            isAscending = false;
        } else {
            throw new MyException("Некорректный 4й аргумент" + help);
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
                InsertionSort.sort(line, new StringComparator());
                for (String e : line) {
                    writer.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + help);
        } catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
