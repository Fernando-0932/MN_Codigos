package metododeeliminaciongaussiana;

public class MetodoDeEliminacionGaussiana {
    static final int N = 3;

    // Ejercicio 1
    public static void ejercicio1() {
        double[][] mat = {
            { 2.0, 3.0, -1.0, 5.0 },
            { 4.0, 2.0, 3.0, 12.0 },
            { 3.0, -1.0, 2.0, 6.0 }
        };
        resolverSistema(mat, "Ejercicio 1");
    }

    // Ejercicio 2
    public static void ejercicio2() {
        double[][] mat = {
            { 2.0, 1.0, -3.0, -10.0 },
            { 4.0, -6.0, 0.0, 32.0 },
            { -2.0, 7.0, 2.0, 15.0 }
        };
        resolverSistema(mat, "Ejercicio 2");
    }

    // Ejercicio 3
    public static void ejercicio3() {
        double[][] mat = {
            { 2.0, 3.0, -1.0, 10.0 },
            { 4.0, -1.0, 2.0, 20.0 },
            { 3.0, 5.0, 1.0, 30.0 }
        };
        resolverSistema(mat, "Ejercicio 3");
    }

    // Ejercicio 4 (repite Ejercicio 1)
    public static void ejercicio4() {
        ejercicio1(); // misma matriz que Ejercicio 1
    }

    // Ejercicio 5
    public static void ejercicio5() {
        double[][] mat = {
            {4.0, -2.0, 3.0, 5.0},
            {1.0, 5.0, -1.0, 10.0},
            {2.0, -3.0, 6.0, 12.0}
        };
        resolverSistema(mat, "Ejercicio 5");
    }

    // Método general para resolver
    public static void resolverSistema(double[][] A, String nombre) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int pivotRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[pivotRow][i])) {
                    pivotRow = j;
                }
            }
            if (pivotRow != i) {
                for (int j = i; j <= n; j++) {
                    double temp = A[i][j];
                    A[i][j] = A[pivotRow][j];
                    A[pivotRow][j] = temp;
                }
            }
            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                for (int k = i; k <= n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (A[i][n] - sum) / A[i][i];
        }

        System.out.println("\n" + nombre + " - Solución:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.3f\n", i + 1, x[i]);
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
