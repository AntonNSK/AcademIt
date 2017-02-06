package ru.academits.gusev.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Не верное значение, размерность вектора должна быть положительной");
        }
        vector = new double[n];
    }

    public Vector(Vector variant) {
        this(variant.vector);
    }

    public Vector(double[] variant) {
        this(variant.length, variant);
    }

    public Vector(int n, double[] variant) {
        this(n);
        System.arraycopy(variant, 0, vector, 0, Math.min(n, variant.length));
    }

    public int getSize() {
        return vector.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < vector.length; ++i) {
            sb.append(vector[i]);
            if (i == vector.length - 1) {
                sb.append(" }");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }

    public Vector sum(Vector variant) {
        if (vector.length >= variant.vector.length) {
            for (int i = 0; i < variant.vector.length; ++i) {
                vector[i] = vector[i] + variant.vector[i];
            }
            return this;
        } else {
            double[] vector1 = new double[variant.vector.length];
            for (int i = 0; i < variant.vector.length; ++i) {
                if (i < vector.length) {
                    vector1[i] = vector[i] + variant.vector[i];
                } else {
                    vector1[i] = variant.vector[i];
                }
            }
            vector = vector1;
            return this;
        }
    }

    public Vector subtract(Vector variant) {
        if (vector.length >= variant.vector.length) {
            for (int i = 0; i < variant.vector.length; ++i) {
                vector[i] = vector[i] - variant.vector[i];
            }
            return this;
        } else {
            double[] vector1 = new double[variant.vector.length];
            for (int i = 0; i < variant.vector.length; ++i) {
                if (i < vector.length) {
                    vector1[i] = vector[i] - variant.vector[i];
                } else {
                    vector1[i] = vector1[i] - variant.vector[i];
                }
            }
            vector = vector1;
            return this;
        }
    }

    public Vector multiplyByScalar(double b) {
        for (int i = 0; i < vector.length; ++i) {
            vector[i] = vector[i] * b;
        }
        return this;
    }

    public Vector spread() {
        multiplyByScalar(-1);
        return this;
    }

    public double length() {
        double sum = 0;
        for (double e : vector) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return vector[index];
    }

    public double setComponent(int index, double component) {
        return vector[index] = component;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector variant = (Vector) o;
        if (vector.length != variant.vector.length) {
            return false;
        }
        for (int i = 0; i < vector.length; ++i) {
            if (vector[i] != variant.vector[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    public static Vector sum(Vector variant1, Vector variant2) {
        Vector vector = new Vector(variant1);
        return vector.sum(variant2);
    }

    public static Vector subtract(Vector variant1, Vector variant2) {
        Vector vector = new Vector(variant1);
        return vector.subtract(variant2);
    }

    public static double calculateScalarProduct(Vector variant1, Vector variant2) {
        double scalarProduct = 0;
        int minSize = Math.min(variant1.getSize(), variant2.getSize());
        for (int i = 0; i < minSize; ++i) {
            scalarProduct = scalarProduct + variant1.getComponent(i) * variant2.getComponent(i);
        }
        return scalarProduct;
    }
}
