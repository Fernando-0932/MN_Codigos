package errortruncamientounificado;

public class ErrorTruncamientoUnificado {

    public static void main(String[] args) {
        ejercicio1();  // Serie de Taylor para e^x
        ejercicio2();  // Aproximación de π con serie de Leibniz
        ejercicio3();  // Derivada numérica (diferencias finitas)
        ejercicio4();  // Integral numérica (regla del trapecio)
        ejercicio5();  // Serie truncada para ln(1+x)
    }

    // Método genérico para calcular el error de truncamiento
    public static double calcularErrorTruncamiento(double valorExacto, double valorAproximado) {
        return Math.abs(valorExacto - valorAproximado);
    }

    // Ejercicio 1: Error en serie de Taylor para e^1 (truncada en n=3)
    public static void ejercicio1() {
        System.out.println("\n** Problema 1: Error de truncamiento en e^1 (Serie de Taylor) **");
        System.out.println("Valor exacto: Math.exp(1) ≈ 2.718281828459045");
        System.out.println("Aproximación (3 términos): 1 + 1 + 1/2! + 1/3! ≈ 2.6666666666666665");

        double exacto = Math.exp(1);
        double aproximado = 1 + 1 + (1.0 / 2) + (1.0 / 6); // e^1 ≈ 1 + x + x²/2! + x³/3! (x=1)
        double error = calcularErrorTruncamiento(exacto, aproximado);

        System.out.printf("Error de truncamiento: %.10f%n", error); // 0.0516151618
    }

    // Ejercicio 2: Error en aproximación de π (Serie de Leibniz truncada)
    public static void ejercicio2() {
        System.out.println("\n** Problema 2: Error de truncamiento en π (Serie de Leibniz) **");
        System.out.println("Valor exacto: Math.PI ≈ 3.141592653589793");
        System.out.println("Aproximación (4 términos): 4*(1 - 1/3 + 1/5 - 1/7) ≈ 2.8952380952380956");

        double exacto = Math.PI;
        double aproximado = 4 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7)); // Leibniz: π/4 = 1 - 1/3 + 1/5 - 1/7 + ...
        double error = calcularErrorTruncamiento(exacto, aproximado);

        System.out.printf("Error de truncamiento: %.10f%n", error); // 0.2463545584
    }

    // Ejercicio 3: Error en derivada numérica (diferencias finitas hacia adelante)
    public static void ejercicio3() {
        System.out.println("\n** Problema 3: Error de truncamiento en derivada numérica **");
        System.out.println("Función: f(x) = x², x = 2.0");
        System.out.println("Derivada exacta: f'(2) = 4.0");
        System.out.println("Aproximación (h=0.1): (f(2.1) - f(2)) / 0.1 ≈ 4.100000000000001");

        double exacto = 4.0; // f'(x) = 2x → f'(2) = 4
        double h = 0.1;
        double aproximado = (Math.pow(2 + h, 2) - Math.pow(2, 2)) / h; // (f(x+h) - f(x))/h
        double error = calcularErrorTruncamiento(exacto, aproximado);

        System.out.printf("Error de truncamiento: %.10f%n", error); // 0.1000000000
    }

    // Ejercicio 4: Error en integral numérica (regla del trapecio)
    public static void ejercicio4() {
        System.out.println("\n** Problema 4: Error de truncamiento en integral (regla del trapecio) **");
        System.out.println("Función: ∫(0 a 1) e^x dx ≈ 1.718281828459045");
        System.out.println("Aproximación (n=1 trapecio): (e^0 + e^1)/2 ≈ 1.8591409142295225");

        double exacto = Math.exp(1) - 1; // ∫e^x dx = e^x |_0^1 = e - 1 ≈ 1.718281828459045
        double aproximado = (Math.exp(0) + Math.exp(1)) / 2; // Regla del trapecio (n=1)
        double error = calcularErrorTruncamiento(exacto, aproximado);

        System.out.printf("Error de truncamiento: %.10f%n", error); // 0.1408590858
    }

    // Ejercicio 5: Error en serie truncada para ln(1+x) (x=0.5)
    public static void ejercicio5() {
        System.out.println("\n** Problema 5: Error de truncamiento en ln(1+0.5) (Serie de Taylor) **");
        System.out.println("Valor exacto: Math.log(1.5) ≈ 0.4054651081081644");
        System.out.println("Aproximación (3 términos): 0.5 - 0.5²/2 + 0.5³/3 ≈ 0.4166666666666667");

        double exacto = Math.log(1.5);
        double x = 0.5;
        double aproximado = x - Math.pow(x, 2) / 2 + Math.pow(x, 3) / 3; // ln(1+x) ≈ x - x²/2 + x³/3 - ...
        double error = calcularErrorTruncamiento(exacto, aproximado);

        System.out.printf("Error de truncamiento: %.10f%n", error); // 0.0112015586
    }
}