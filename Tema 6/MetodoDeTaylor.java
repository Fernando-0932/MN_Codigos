package metododetaylor;

public class MetodoDeTaylor {
      public static void ejercicio1() {
        double t = 0;
        double v = 0;
        double h = 0.1;
        int pasos = 10;
        double g = 9.8;

        System.out.println("\nEjercicio 1 - Caída libre con resistencia");
        System.out.println("t\t\tv");

        for (int i = 0; i <= pasos; i++) {
            System.out.printf("%.1f\t\t%.4f%n", t, v);
            double dv = -g;
            double dv2 = 0; // Segunda derivada de constante -g es cero
            v = v + h * dv + (h * h / 2) * dv2;
            t += h;
        }
    }

    // Ejercicio 2: Enfriamiento (T' = -k(T - Tamb))
    public static void ejercicio2() {
        double T = 90;
        double h = 1;
        double k = 0.1;
        double Tamb = 20;
        int pasos = 5;

        System.out.println("\nEjercicio 2 - Enfriamiento");
        System.out.println("t\t\tT");

        for (int t = 0; t <= pasos; t++) {
            System.out.printf("%d\t\t%.4f%n", t, T);
            double dT = -k * (T - Tamb);
            double dT2 = -k * dT;
            T = T + h * dT + (h * h / 2) * dT2;
        }
    }

    // Ejercicio 3: Crecimiento poblacional logístico
    public static void ejercicio3() {
        double P = 100;
        double K = 1000;
        double r = 0.1;
        double h = 1;
        int pasos = 5;

        System.out.println("\nEjercicio 3 - Crecimiento logístico");
        System.out.println("t\t\tP");

        for (int t = 0; t <= pasos; t++) {
            System.out.printf("%d\t\t%.4f%n", t, P);
            double dP = r * P * (1 - P / K);
            double dP2 = r * (1 - 2 * P / K) * dP;
            P = P + h * dP + (h * h / 2) * dP2;
        }
    }

    // Ejercicio 4: Aproximación de f(x) = e^x con n términos
    public static void ejercicio4() {
        double a = 0;
        double x = 1;
        int n = 5;
        double resultado = 0;
        double factorial = 1;
        double potencia = 1;

        System.out.println("\nEjercicio 4 - Aproximación de e^x con n=5");

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                factorial *= i;
                potencia *= (x - a);
            }
            resultado += Math.exp(a) * potencia / factorial;
        }

        System.out.printf("Aproximación de e^1: %.5f%n", resultado);
    }

    // Ejercicio 5: Error de la aproximación de e^x
    public static void ejercicio5() {
        double a = 0;
        double x = 1;
        int n = 5;
        double resultado = 0;
        double factorial = 1;
        double potencia = 1;

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                factorial *= i;
                potencia *= (x - a);
            }
            resultado += Math.exp(a) * potencia / factorial;
        }

        double valorReal = Math.exp(x);
        double error = valorReal - resultado;

        System.out.println("\nEjercicio 5 - Error de aproximación de e^x");
        System.out.printf("Aproximación de e^1: %.5f%n", resultado);
        System.out.printf("Valor real de e^1: %.5f%n", valorReal);
        System.out.printf("Error: %.5f%n", error);
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
