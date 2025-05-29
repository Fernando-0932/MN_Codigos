package metododegaussjordan;

import java.text.DecimalFormat;

public class MetodoDeGaussJordan {
    static DecimalFormat df = new DecimalFormat("#.####");

    public static void ejercicio1() {
        double[][] matrix = {
            {2, -1, 1, 3},
            {1, 3, 2, 12},
            {1, -1, 2, 0}
        };
        gaussJordan(matrix, 3, "Ejercicio 1");
    }

    public static void ejercicio2() {
        double[][] matrix = {
            {1, 1, 1, 6},
            {0, 2, 5, -4},
            {2, 5, -1, 27}
        };
        gaussJordan(matrix, 3, "Ejercicio 2");
    }

    public static void ejercicio3() {
        double[][] matrix = {
            {3, -2, 5, 1},
            {2, 3, -1, 3},
            {1, 3, 2, 12}
        };
        gaussJordan(matrix, 3, "Ejercicio 3");
    }

    public static void ejercicio4() {
        double[][] matrix = {
            {4, -3, 2, 5},
            {3, 2, -4, 7},
            {2, -1, 3, -2}
        };
        gaussJordan(matrix, 3, "Ejercicio 4");
    }

    public static void ejercicio5() {
        double[][] matrix = {
            {1, 2, 3, 14},
            {3, 2, 1, 10},
            {2, 3, 2, 13}
        };
        gaussJordan(matrix, 3, "Ejercicio 5");
    }

    public static void gaussJordan(double[][] matrix, int n, String nombre) {
        System.out.println("\n" + nombre + ":");
        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];
            if (pivot == 0) {
                System.out.println("No se puede resolver: hay un pivote cero.");
                return;
            }
            for (int j = 0; j < n + 1; j++) {
                matrix[i][j] /= pivot;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j < n + 1; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }
        System.out.println("Solución del sistema:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + df.format(matrix[i][n]));
        }
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
