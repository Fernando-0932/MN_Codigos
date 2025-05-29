package metododeunpasoeuler;

import java.text.DecimalFormat;

public class MetodoDeUnPasoEuler {
     // Ejercicio 1: dy/dx = x + y
    public static double f1(double x, double y) {
        return x + y;
    }

    // Ejercicio 2: dy/dx = y - x^2 + 1
    public static double f2(double x, double y) {
        return y - x * x + 1;
    }

    // Ejercicio 3: dy/dx = cos(x) - y
    public static double f3(double x, double y) {
        return Math.cos(x) - y;
    }

    // Ejercicio 4: dy/dx = 2xy
    public static double f4(double x, double y) {
        return 2 * x * y;
    }

    // Ejercicio 5: dy/dx = y (con error respecto a e^x)
    public static double f5(double x, double y) {
        return y;
    }

    public static void resolverEuler(double x0, double y0, double h, int n, int ejercicio) {
        double x = x0;
        double y = y0;
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("\nEjercicio " + ejercicio);
        System.out.println("Paso\t x\t\t y");

        for (int i = 0; i <= n; i++) {
            System.out.printf("%d\t %.2f\t %.6f%n", i, x, y);
            switch (ejercicio) {
                case 1: y = y + h * f1(x, y); break;
                case 2: y = y + h * f2(x, y); break;
                case 3: y = y + h * f3(x, y); break;
                case 4: y = y + h * f4(x, y); break;
                case 5: y = y + h * f5(x, y); break;
            }
            x = x + h;
        }

        // Comparación con solución exacta para el ejercicio 5
        if (ejercicio == 5) {
            double yExacto = Math.exp(1); // e^1
            double error = Math.abs(yExacto - y);
            System.out.printf("Valor exacto en x = 1: %.6f%n", yExacto);
            System.out.printf("Valor estimado con Euler: %.6f%n", y);
            System.out.printf("Error absoluto: %.6f%n", error);
        }
    }

    public static void main(String[] args) {
        resolverEuler(0, 1, 0.1, 10, 1);             // Ejercicio 1
        resolverEuler(0, 0.5, 0.2, 5, 2);            // Ejercicio 2
        resolverEuler(0, 2, 0.2, 5, 3);              // Ejercicio 3
        resolverEuler(0, 1, 0.2, 5, 4);              // Ejercicio 4
        resolverEuler(0, 1, 0.2, 5, 5);              // Ejercicio 5 (con error)
    }
}
