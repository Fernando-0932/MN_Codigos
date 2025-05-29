package metododejacobi;

public class MetodoDeJacobi {
public static void jacobi(double[][] A, double[] b, int n, String nombre) {
        double[] x = new double[n];
        double[] xNuevo = new double[n];
        double tol = 0.001;
        int maxIter = 100, iter = 0;

        while (iter < maxIter) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) suma += A[i][j] * x[j];
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }
            double error = 0;
            for (int i = 0; i < n; i++) error += Math.abs(xNuevo[i] - x[i]);
            if (error < tol) break;
            System.arraycopy(xNuevo, 0, x, 0, n);
            iter++;
        }

        System.out.println("\n" + nombre + " (convergencia en " + iter + " iteraciones):");
        for (int i = 0; i < n; i++) System.out.printf("x[%d] = %.3f\n", i + 1, x[i]);
    }

    public static void ejercicio1() {
        double[][] A = {{4, -1, 1}, {4, -8, 1}, {-2, 1, 5}};
        double[] b = {7, -21, 15};
        jacobi(A, b, 3, "Ejercicio 1");
    }

    public static void ejercicio2() {
        double[][] A = {{5, 2, -1}, {1, 4, 2}, {2, -1, 6}};
        double[] b = {12, 15, 20};
        jacobi(A, b, 3, "Ejercicio 2");
    }

    public static void ejercicio3() {
        double[][] A = {{10, -1, 2, 0}, {-1, 11, -1, 3}, {2, -1, 10, -1}, {0, 3, -1, 8}};
        double[] b = {6, 25, -11, 15};
        jacobi(A, b, 4, "Ejercicio 3");
    }

    public static void ejercicio4() {
        double[][] A = {{4, 1, -1}, {2, 5, 1}, {1, 1, 6}};
        double[] b = {3, 12, 10};
        jacobi(A, b, 3, "Ejercicio 4");
    }

    public static void ejercicio5() {
        double[][] A = {{6, 2, -1}, {1, 5, 1}, {2, 1, 4}};
        double[] b = {4, 3, 7};
        jacobi(A, b, 3, "Ejercicio 5");
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }    
}
