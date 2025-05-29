package sistemas.de.ecuaciones.diferenciales.ordinarias.método.de.euler;

import java.text.DecimalFormat;

public class SistemasDeEcuacionesDiferencialesOrdinariasMétodoDeEuler {
    static DecimalFormat df = new DecimalFormat("#.###");

    // Ejercicio 1: dy/dx = x + y
    public static double f1(double x, double y) {
        return x + y;
    }

    // Ejercicio 2: dy/dx = y - x^2 + 1
    public static double f2(double x, double y) {
        return y - x * x + 1;
    }

    // Ejercicio 3: dy/dx = y - 2x
    public static double f3(double x, double y) {
        return y - 2 * x;
    }

    // Ejercicio 4: dy/dx = -2y + 3x
    public static double f4(double x, double y) {
        return -2 * y + 3 * x;
    }

    // Ejercicio 5: Solución exacta
    public static double yExactaEj5(double x) {
        return -x - 1 + 2 * Math.exp(x);
    }

    public static void ejercicio1() {
        System.out.println("=== EJERCICIO 1: dy/dx = x + y ===");
        double x = 0, y = 1, h = 0.1;
        int n = 10;
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f1(x, y);
            x = x + h;
        }
        System.out.println();
    }

    public static void ejercicio2() {
        System.out.println("=== EJERCICIO 2: dy/dx = y - x^2 + 1 ===");
        double x = 0, y = 0.5, h = 0.2;
        int n = 10;
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f2(x, y);
            x = x + h;
        }
        System.out.println();
    }

    public static void ejercicio3() {
        System.out.println("=== EJERCICIO 3: dy/dx = y - 2x ===");
        double x = 0, y = 1, h = 0.1;
        int n = 15;
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f3(x, y);
            x = x + h;
        }
        System.out.println();
    }

    public static void ejercicio4() {
        System.out.println("=== EJERCICIO 4: dy/dx = -2y + 3x ===");
        double x = 0, y = 1, h = 0.1;
        int n = 12;
        System.out.println("x\t\ty");
        for (int i = 0; i <= n; i++) {
            System.out.println(df.format(x) + "\t\t" + df.format(y));
            y = y + h * f4(x, y);
            x = x + h;
        }
        System.out.println();
    }

    public static void ejercicio5() {
        System.out.println("=== EJERCICIO 5: dy/dx = x + y (con error) ===");
        double x = 0, y = 1, h = 0.1;
        int n = 10;
        System.out.println("x\t\tEuler y\t\ty exacta\tError abs");
        for (int i = 0; i <= n; i++) {
            double yExacta = yExactaEj5(x);
            double error = Math.abs(yExacta - y);
            System.out.println(df.format(x) + "\t\t" + df.format(y) + "\t\t" + df.format(yExacta) + "\t\t" + df.format(error));
            y = y + h * f1(x, y);
            x = x + h;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
