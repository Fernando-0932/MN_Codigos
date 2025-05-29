package metododeltrapecio;

import java.util.Scanner;

public class MetodoDelTrapecio {
    // Código 1
    public static double f1(double x) {
        return Math.log(x);
    }

    public static double integrarTrapecio1(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = (f1(a) + f1(b)) / 2.0;
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += f1(xi);
        }
        return h * suma;
    }

    public static void metodo1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Método del Trapecio - Metodos Numericos (ln x)");
        System.out.print("Ingresa el límite inferior: ");
        double a = scanner.nextDouble();
        System.out.print("Ingresa el límite superior: ");
        double b = scanner.nextDouble();
        System.out.print("Ingresa el número de subintervalos n: ");
        int n = scanner.nextInt();
        double resultado = integrarTrapecio1(a, b, n);
        System.out.printf("La aproximación de la integral es: %.4f%n", resultado);
        double resultadoExacto = 2 * Math.log(2) - 1;
        System.out.printf("Resultado exacto (estimado): 2 * ln(2) - 1 ≈ %.4f%n", resultadoExacto);
    }

    // Código 2
    public static double f2(double x) {
        return 2 * x * x + 1;
    }

    public static double metodoTrapecio2(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = f2(a) + f2(b);
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += 2 * f2(xi);
        }
        return (h / 2) * suma;
    }

    public static void metodo2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Metodo del Trapecio (2x² + 1)");
        System.out.print("Ingresa el limite inferior a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingresa el limite superior b: ");
        double b = scanner.nextDouble();
        System.out.print("Ingresa el numero de subintervalos n: ");
        int n = scanner.nextInt();
        double resultado = metodoTrapecio2(a, b, n);
        System.out.printf("La aproximacion de la integral es: %.4f%n", resultado);
    }

    // Código 3
    public static double f3(double x) {
        return 2 * x + 3;
    }

    public static void metodo3() {
        double a = 1, b = 5;
        int n = 4;
        double h = (b - a) / n;
        double suma = 0.5 * (f3(a) + f3(b));
        for (int i = 1; i < n; i++) {
            suma += f3(a + i * h);
        }
        double integral = h * suma;
        System.out.println("Aproximación (2x + 3): " + integral);
    }

    // Código 4
    public static double f4(double x) {
        return x * x;
    }

    public static void metodo4() {
        double a = 0, b = 4;
        int n = 4;
        double h = (b - a) / n;
        double suma = 0.5 * (f4(a) + f4(b));
        for (int i = 1; i < n; i++) {
            suma += f4(a + i * h);
        }
        double integral = h * suma;
        System.out.println("Aproximación (x²): " + integral);
    }

    // Código 5
    public static double f5(double x) {
        return Math.pow(x, 3) - 2 * Math.pow(x, 2) + x;
    }

    public static void metodo5() {
        double a = 0.0;
        double b = 2.0;
        int n = 5;
        double h = (b - a) / n;
        double suma = f5(a) + f5(b);
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += 2 * f5(xi);
        }
        double integral = (h / 2) * suma;
        System.out.printf("Aproximación (x³ - 2x² + x): %.2f%n", integral);
    }

    // Código 6
    public static double f6(double x) {
        return Math.sqrt(x);
    }

    public static double integrarTrapecio6(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = (f6(a) + f6(b)) / 2.0;
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += f6(xi);
        }
        return h * suma;
    }

    public static void metodo6() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Método del Trapecio - Metodos Numericos (√x)");
        System.out.print("Ingresa el límite inferior: ");
        double a = scanner.nextDouble();
        System.out.print("Ingresa el límite superior: ");
        double b = scanner.nextDouble();
        System.out.print("Ingresa el número de subintervalos n: ");
        int n = scanner.nextInt();
        double resultado = integrarTrapecio6(a, b, n);
        System.out.printf("La aproximación de la integral es: %.4f%n", resultado);
        double resultadoExacto = (2.0 / 3.0) * (Math.pow(b, 1.5) - Math.pow(a, 1.5));
        System.out.printf("Resultado exacto (estimado): (2/3)*(%.1f^1.5 - %.1f^1.5) ≈ %.4f%n", b, a, resultadoExacto);
    }

    public static void main(String[] args) {
        // Llamas aquí a los métodos que deseas ejecutar uno a uno
        metodo1(); // ln(x)
        metodo2(); // 2x² + 1
        metodo3(); // 2x + 3
        metodo4(); // x²
        metodo5(); // x³ - 2x² + x
        metodo6(); // √x
    }
}
