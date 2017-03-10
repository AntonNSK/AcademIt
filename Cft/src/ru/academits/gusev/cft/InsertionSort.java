package ru.academits.gusev.cft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InsertionSort {
    public static void sortArray(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] < array[j]) {
                    int number = array[i];
                    for (int h = i; h > j; --h) {
                        array[h] = array[h - 1];
                    }
                    array[j] = number;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        if (args.length != 4){
            System.out.println("Не верное колличество аргументов");
            return;
        }

        boolean isAscending;
        if (args[2].equals("-a")){
            isAscending = true;
        } else if (args[2].equals("-d")){
            isAscending = false;
        } else {
            System.out.println("Некорректный аргумент");
        }

        try(Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int[] array = {90, 25, 50, 10, 16, 1};


        sortArray(array);
        for (int e : array) {
            System.out.print(e + " ");
        }
    }
}
