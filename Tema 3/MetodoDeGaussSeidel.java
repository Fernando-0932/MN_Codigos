package metododegaussseidel;

public class MetodoDeGaussSeidel {
    public static void resolver(double[][] A, double[] b, int n, String nombre) {
        double[] x = new double[n];
        double[] xNuevo = new double[n];
        double tol = 1e-6;
        int maxIter = 100, iteraciones = 0;

        for (int iter = 0; iter < maxIter; iter++) {
            System.arraycopy(x, 0, xNuevo, 0, n);
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) suma += A[i][j] * xNuevo[j];
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }
            double error = 0;
            for (int i = 0; i < n; i++) error = Math.max(error, Math.abs(xNuevo[i] - x[i]));
            if (error < tol) {
                System.out.println("\n" + nombre + " (convergencia en " + (iteraciones + 1) + " iteraciones):");
                for (int i = 0; i < n; i++) System.out.printf("x[%d] = %.3f\n", i + 1, xNuevo[i]);
                return;
            }
            System.arraycopy(xNuevo, 0, x, 0, n);
            iteraciones++;
        }
        System.out.println("No converge");
    }

    public static void ejercicio1() {
        double[][] A = {
            {10, 2, 1},
            {3, 10, 4},
            {2, 3, 10}
        };
        double[] b = {9, 24, 18};
        resolver(A, b, 3, "Ejercicio 1");
    }

    public static void ejercicio2() {
        double[][] A = {
            {3, 1, -1},
            {2, 4, 1},
            {-1, 2, 5}
        };
        double[] b = {7, 4, 6};
        resolver(A, b, 3, "Ejercicio 2");
    }

    public static void ejercicio3() {
        double[][] A = {
            {4, -1, 0},
            {-2, 5, 1},
            {0, 1, 3}
        };
        double[] b = {8, -3, 4};
        resolver(A, b, 3, "Ejercicio 3");
    }

    public static void ejercicio4() {
        double[][] A = {
            {5, 2, 1},
            {3, 8, -2},
            {1, -2, 7}
        };
        double[] b = {10, 3, -2};
        resolver(A, b, 3, "Ejercicio 4");
    }

    public static void ejercicio5() {
        double[][] A = {
            {8, -3, 2},
            {4, 11, -1},
            {2, -1, 9}
        };
        double[] b = {20, 33, 14};
        resolver(A, b, 3, "Ejercicio 5");
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
