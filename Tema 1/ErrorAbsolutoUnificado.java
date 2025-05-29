package errorabsolutounificado;

public class ErrorAbsolutoUnificado {

    public static void main(String[] args) {
        ejercicio1();  // Aceleración de la gravedad
        ejercicio2();  // Temperaturas bajo cero
        ejercicio3();  // Aproximación de √2
        ejercicio4();  // Área de un círculo
        ejercicio5();  // Aproximación de e^1 con serie de Taylor
    }

    // Ejercicio 1: Error en medición de gravedad
    public static void ejercicio1() {
        System.out.println("\n** Problema 1: Error en medición de gravedad **");
        System.out.println("Valor real: 10.0 m/s² | Valor aproximado: 9.5 m/s²");

        double valorReal = 10.0;
        double valorAproximado = 9.5;
        double errorAbsoluto = calcularErrorAbsoluto(valorReal, valorAproximado);

        System.out.println("Error absoluto: " + errorAbsoluto + " m/s²");
    }

    // Ejercicio 2: Error en sensor de temperatura
    public static void ejercicio2() {
        System.out.println("\n** Problema 2: Error en sensor de temperatura **");
        System.out.println("Valor real: -3.0°C | Valor aproximado: -2.5°C");

        double valorReal = -3.0;
        double valorAproximado = -2.5;
        double errorAbsoluto = calcularErrorAbsoluto(valorReal, valorAproximado);

        System.out.println("Error absoluto: " + errorAbsoluto + "°C");
    }

    // Ejercicio 3: Error en aproximación de √2
    public static void ejercicio3() {
        System.out.println("\n** Problema 3: Error en aproximación de √2 **");
        System.out.println("Valor real: 1.41421356237 | Valor aproximado: 1.4142");

        double valorReal = 1.41421356237;
        double valorAproximado = 1.4142;
        double errorAbsoluto = calcularErrorAbsoluto(valorReal, valorAproximado);

        System.out.printf("Error absoluto: %.8f%n", errorAbsoluto);
    }

    // Ejercicio 4: Error en área de círculo
    public static void ejercicio4() {
        System.out.println("\n** Problema 4: Error en área de círculo **");
        System.out.println("Radio real: 5.0 cm | Radio aproximado: 4.9 cm");

        double radioReal = 5.0;
        double radioAproximado = 4.9;
        double areaReal = Math.PI * Math.pow(radioReal, 2);
        double areaAproximada = Math.PI * Math.pow(radioAproximado, 2);
        double errorAbsoluto = calcularErrorAbsoluto(areaReal, areaAproximada);

        System.out.printf("Error absoluto en área: %.4f cm²%n", errorAbsoluto);
    }

    // Ejercicio 5: Error en aproximación de e^1 (serie de Taylor)
    public static void ejercicio5() {
        System.out.println("\n** Problema 5: Error en aproximación de e^1 **");
        System.out.println("Valor real: Math.exp(1) | Aproximación: 1 + x + x²/2 (x=1)");

        double x = 1.0;
        double valorReal = Math.exp(x);
        double valorAproximado = 1 + x + (x * x / 2);
        double errorAbsoluto = calcularErrorAbsoluto(valorReal, valorAproximado);

        System.out.printf("Error absoluto en e^1: %.6f%n", errorAbsoluto);
    }

    // Método reusable para calcular el error absoluto
    public static double calcularErrorAbsoluto(double real, double aproximado) {
        return Math.abs(real - aproximado);
    }
}
