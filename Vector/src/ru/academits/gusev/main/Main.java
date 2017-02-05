package ru.academits.gusev.main;

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

        if (vector3.equals(vector2) && vector3.hashCode() == vector2.hashCode()) {
            System.out.println("Вектор 2 равен вектору 3");
        }

        System.out.println("Сумма:" + vector2.sum(vector1).toString());
        System.out.println("Разность:" + vector1.subtract(vector2).toString());
        System.out.println("Умножение на скаляр (5):" + vector1.multiplyByScalar(b).toString());
        System.out.println("Разворот:" + vector1.spread().toString());
        System.out.printf("Длина: %.2f" + System.lineSeparator(), vector1.length());
        System.out.println("Компонент под индексом 1:" + vector1.getComponent(1));
        System.out.println("Сумма (static):" + Vector.sum(vector3, vector4).toString());
        System.out.println("Разность (static):" + Vector.subtract(vector4, vector3).toString());
        System.out.printf("Скалярное произведение:%.2f", Vector.calculateScalarProduct(vector4, vector3));
    }
}
