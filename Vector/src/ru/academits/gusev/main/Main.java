package ru.academits.gusev.main;

import ru.academits.gusev.matrix.Matrix;
import ru.academits.gusev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        int b = 2;
        double[] array = {1.2, 2.3, 1.7, 5.9, 6};
        Vector vector1 = new Vector(3, array);
        Vector vector2 = new Vector(7, array);
        Vector vector3 = new Vector(vector2);
        Vector vector4 = new Vector(6, array);
        vector4.setComponent(1, 5);
        vector4.setComponent(5, 3);

        Matrix matrix = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(matrix);
        double[][] a = {{1, 3, 7}, {5, 4, 9}};
        Vector [] v = {vector2, vector3};
        Matrix matrix3 = new Matrix(v);
        Matrix matrix1 = new Matrix(a);
        System.out.println(matrix);
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);


    }
}
