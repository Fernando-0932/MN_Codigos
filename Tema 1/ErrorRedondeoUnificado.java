package errorredondeounificado;

public class ErrorRedondeoUnificado {

    public static void main(String[] args) {
        ejercicio1();  // Redondeo en enteros
        ejercicio2();  // Redondeo en decimales (precisión baja)
        ejercicio3();  // Redondeo en cálculos financieros
        ejercicio4();  // Redondeo en series matemáticas (π)
        ejercicio5();  // Redondeo en conversión de unidades
    }

    // Método genérico para calcular el error de redondeo
    public static double calcularErrorRedondeo(double valorExacto, double valorRedondeado) {
        return Math.abs(valorExacto - valorRedondeado);
    }

    // Ejercicio 1: Redondeo en enteros (población de una ciudad)
    public static void ejercicio1() {
        System.out.println("\n** Problema 1: Redondeo en enteros **");
        System.out.println("Valor exacto: 1,249,823 habitantes | Valor redondeado: 1,250,000 habitantes");

        double exacto = 1_249_823;
        double redondeado = 1_250_000;
        double error = calcularErrorRedondeo(exacto, redondeado);

        System.out.printf("Error de redondeo: %.0f habitantes%n", error);  // Resultado: 177
    }

    // Ejercicio 2: Redondeo en decimales (precisión baja)
    public static void ejercicio2() {
        System.out.println("\n** Problema 2: Redondeo en decimales (2 dígitos) **");
        System.out.println("Valor exacto: 3.1415926535 | Valor redondeado: 3.14");

        double exacto = Math.PI;
        double redondeado = 3.14;
        double error = calcularErrorRedondeo(exacto, redondeado);

        System.out.printf("Error de redondeo: %.6f%n", error);  // Resultado: 0.001593
    }

    // Ejercicio 3: Redondeo en cálculos financieros (interés compuesto)
    public static void ejercicio3() {
        System.out.println("\n** Problema 3: Redondeo en interés compuesto **");
        System.out.println("Valor exacto: $1,000.6589 | Valor redondeado (2 decimales): $1,000.66");

        double exacto = 1000.6589;
        double redondeado = 1000.66;
        double error = calcularErrorRedondeo(exacto, redondeado);

        System.out.printf("Error de redondeo: $%.4f%n", error);  // Resultado: 0.0011
    }

    // Ejercicio 4: Redondeo en series matemáticas (aproximación de π)
    public static void ejercicio4() {
        System.out.println("\n** Problema 4: Redondeo en aproximación de π **");
        System.out.println("Valor exacto: 3.141592653589793 | Aproximación: 22/7 ≈ 3.142857");

        double exacto = Math.PI;
        double aproximacion = 22.0 / 7;
        double error = calcularErrorRedondeo(exacto, aproximacion);

        System.out.printf("Error de redondeo: %.6f%n", error);  // Resultado: 0.001264
    }

    // Ejercicio 5: Redondeo en conversión de unidades (millas a kilómetros)
    public static void ejercicio5() {
        System.out.println("\n** Problema 5: Redondeo en conversión de unidades **");
        System.out.println("Valor exacto: 1 milla = 1.609344 km | Valor redondeado: 1.61 km");

        double exacto = 1.609344;
        double redondeado = 1.61;
        double error = calcularErrorRedondeo(exacto, redondeado);

        System.out.printf("Error de redondeo: %.6f km%n", error);  // Resultado: 0.000656
    }
}
