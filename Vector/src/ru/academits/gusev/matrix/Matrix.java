package ru.academits.gusev.matrix;

import ru.academits.gusev.vector.Vector;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Не верное значение, размерность матрицы должна быть положительной");
        }
        matrix = new Vector[m];
        for (int i = 0; i < m; ++i) {
            matrix[i] = new Vector(n);
        }
    }

    public Matrix(Matrix variant) {
        this(variant.matrix);
    }

    public Matrix(double[][] variant) {
        matrix = new Vector[variant.length];
        for (int i = 0; i < variant.length; ++i) {
            matrix[i] = new Vector(variant[i]);
        }
    }

    public Matrix(Vector[] variant) {
        matrix = new Vector[variant.length];
        System.arraycopy(variant, 0, matrix, 0, variant.length);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < matrix.length; ++i) {
            sb.append(matrix[i].toString());
            if (i == matrix.length - 1) {
                sb.append(" }");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }

    public int getLines() {
        return matrix[0].getSize();
    }

    public int getColumns() {
        return matrix.length;
    }

    public Vector getLineVector(int index) {
        return matrix[index];
    }

    public Vector setLineVector(int index, Vector variant) {
        return matrix[index] = variant;
    }

    //public Vector getColumnVector(int index) {
      //  Vector vector = new Vector(matrix.length);
        //for (int i = 0; i <= matrix.length; ++i)
          //  return matrix[index];
    //}
}
