package errorrelativounificado;

public class ErrorRelativoUnificado {

    public static void main(String[] args) {
        ejercicio1();  // Error relativo en medición de gravedad
        ejercicio2();  // Error relativo en temperatura
        ejercicio3();  // Error relativo en aproximación de √2
        ejercicio4();  // Error relativo en área de círculo
        ejercicio5();  // Error relativo en aproximación de e^1
    }

    // Método genérico para calcular el error relativo
    public static double calcularErrorRelativo(double valorExacto, double valorAproximado) {
        return Math.abs(valorExacto - valorAproximado) / Math.abs(valorExacto);
    }

    // Ejercicio 1: Error relativo en medición de gravedad
    public static void ejercicio1() {
        System.out.println("\n** Problema 1: Error relativo en medición de gravedad **");
        System.out.println("Valor exacto: 9.81 m/s² | Valor aproximado: 9.78 m/s²");

        double exacto = 9.81;
        double aproximado = 9.78;
        double errorRelativo = calcularErrorRelativo(exacto, aproximado);

        System.out.printf("Error relativo: %.6f (%.2f%%)%n", errorRelativo, errorRelativo * 100);
        // Resultado: 0.003058 (0.31%)
    }

    // Ejercicio 2: Error relativo en sensor de temperatura
    public static void ejercicio2() {
        System.out.println("\n** Problema 2: Error relativo en sensor de temperatura **");
        System.out.println("Valor exacto: -40.0°C | Valor aproximado: -39.5°C");

        double exacto = -40.0;
        double aproximado = -39.5;
        double errorRelativo = calcularErrorRelativo(exacto, aproximado);

        System.out.printf("Error relativo: %.6f (%.2f%%)%n", errorRelativo, errorRelativo * 100);
        // Resultado: 0.012500 (1.25%)
    }

    // Ejercicio 3: Error relativo en aproximación de √2
    public static void ejercicio3() {
        System.out.println("\n** Problema 3: Error relativo en aproximación de √2 **");
        System.out.println("Valor exacto: 1.41421356237 | Valor aproximado: 1.4142");

        double exacto = 1.41421356237;
        double aproximado = 1.4142;
        double errorRelativo = calcularErrorRelativo(exacto, aproximado);

        System.out.printf("Error relativo: %.8f (%.4f%%)%n", errorRelativo, errorRelativo * 100);
        // Resultado: 0.00000959 (0.00096%)
    }

    // Ejercicio 4: Error relativo en área de círculo
    public static void ejercicio4() {
        System.out.println("\n** Problema 4: Error relativo en área de círculo **");
        System.out.println("Radio exacto: 5.0 cm | Radio aproximado: 4.95 cm");

        double radioExacto = 5.0;
        double radioAproximado = 4.95;
        double areaExacta = Math.PI * Math.pow(radioExacto, 2);
        double areaAproximada = Math.PI * Math.pow(radioAproximado, 2);
        double errorRelativo = calcularErrorRelativo(areaExacta, areaAproximada);

        System.out.printf("Error relativo en área: %.6f (%.2f%%)%n", errorRelativo, errorRelativo * 100);
        // Resultado: 0.019901 (1.99%)
    }

    // Ejercicio 5: Error relativo en aproximación de e^1 (serie de Taylor)
    public static void ejercicio5() {
        System.out.println("\n** Problema 5: Error relativo en aproximación de e^1 **");
        System.out.println("Valor exacto: Math.exp(1) ≈ 2.718281828459045");
        System.out.println("Aproximación: 1 + 1 + 1/2! + 1/3! ≈ 2.6666666666666665");

        double exacto = Math.exp(1);
        double aproximado = 1 + 1 + (1.0 / 2) + (1.0 / 6);  // Serie de Taylor hasta tercer orden
        double errorRelativo = calcularErrorRelativo(exacto, aproximado);

        System.out.printf("Error relativo en e^1: %.6f (%.2f%%)%n", errorRelativo, errorRelativo * 100);
        // Resultado: 0.018988 (1.90%)
    }
}