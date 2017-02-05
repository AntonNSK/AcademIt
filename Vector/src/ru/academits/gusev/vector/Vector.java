package ru.academits.gusev.vector;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Не верное значение");
        }
        vector = new double[n];
    }

    public Vector(Vector variant) {
        vector = new double[variant.vector.length];
        System.arraycopy(variant.vector, 0, this.vector, 0, variant.vector.length);
    }

    Vector(double[] variant) {
        vector = new double[variant.length];
        System.arraycopy(variant, 0, vector, 0, variant.length);
    }

    Vector(int n, double[] variant) {
        if (n < 0) {
            throw new IllegalArgumentException("Не верное значение");
        }
        vector = new double[n];
        if (n <= variant.length) {
            System.arraycopy(variant, 0, vector, 0, n);
        } else {
            System.arraycopy(variant, 0, vector, 0, variant.length);
        }
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

    public Vector multiplyByScalar(double a) {
        for (int i = 0; i < vector.length; ++i) {
            vector[i] = vector[i] * a;
        }
        return this;
    }

    public Vector unwrap() {
        for (int i = 0; i < vector.length; ++i) {
            if (vector[i] != 0) {
                vector[i] = -vector[i];
            }
        }
        return this;
    }

    public double length() {
        double sum = 0;
        for (int i = 0; i < vector.length; ++i) {
            sum += Math.pow(vector[i], 2);
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
        if (o == null) {
            return false;
        }
        Vector variant = (Vector) o;
        for (int i = 0; i < vector.length; ++i) {
            if (vector[i] - variant.vector[i] >= 0.0001) {
                return false;
            }
        }
        return vector.length == variant.vector.length;
    }

    public int hashCode() {
        int prime = 31;
        int result = vector.length;
        for (int i = 0; i < vector.length; ++i) {
            result = prime * result + (int) vector[i];
        }
        return result;
    }

    public static Vector sum(Vector variant1, Vector variant2) {
        if (variant1.getSize() >= variant2.getSize()) {
            Vector vector = new Vector(variant1.getSize());
            for (int i = 0; i < variant1.getSize(); ++i) {
                if (i < variant2.getSize()) {
                    vector.setComponent(i, variant1.getComponent(i) + variant2.getComponent(i));
                } else {
                    vector.setComponent(i, variant1.getComponent(i));
                }
            }
            return vector;
        } else {
            Vector vector = new Vector(variant2.getSize());
            for (int i = 0; i < variant2.getSize(); ++i) {
                if (i < variant1.getSize()) {
                    vector.setComponent(i, variant1.getComponent(i) + variant2.getComponent(i));
                } else {
                    vector.setComponent(i, variant2.getComponent(i));
                }
            }
            return vector;
        }
    }

    public static Vector subtract(Vector variant1, Vector variant2) {
        if (variant1.getSize() >= variant2.getSize()) {
            Vector vector = new Vector(variant1.getSize());
            for (int i = 0; i < variant1.getSize(); ++i) {
                if (i < variant2.getSize()) {
                    vector.setComponent(i, variant1.getComponent(i) - variant2.getComponent(i));
                } else {
                    vector.setComponent(i, variant1.getComponent(i));
                }
            }
            return vector;
        } else {
            Vector vector = new Vector(variant2.getSize());
            for (int i = 0; i < variant2.getSize(); ++i) {
                if (i < variant1.getSize()) {
                    vector.setComponent(i, variant1.getComponent(i) - variant2.getComponent(i));
                } else {
                    vector.setComponent(i, vector.getComponent(i) - variant2.getComponent(i));
                }
            }
            return vector;
        }
    }

    public static double calculateScalarProduct(Vector variant1, Vector variant2) {
        double scalarProduct = 0;
        if (variant1.getSize() >= variant2.getSize()) {
            for (int i = 0; i < variant2.getSize(); ++i) {
                scalarProduct = scalarProduct + variant1.getComponent(i) * variant2.getComponent(i);
            }
            return scalarProduct;
        } else {
            for (int i = 0; i < variant1.getSize(); ++i) {
                scalarProduct = scalarProduct + variant1.getComponent(i) * variant2.getComponent(i);
            }
            return scalarProduct;
        }
    }
}
