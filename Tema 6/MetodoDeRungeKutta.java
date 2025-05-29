package metododerunge.kutta;

public class MetodoDeRungeKutta {
      // Funciones derivadas para cada ejercicio
    public static double f1(double x, double y) {
        return y;
    }

    public static double f2(double t, double T) {
        double k = 0.1, Tamb = 20.0;
        return -k * (T - Tamb);
    }

    public static double g1(double t, double y, double z) {
        return z;
    }

    public static double g2_Ej3(double t, double y, double z) {
        double g = 9.8;
        double b = 0.01;
        return -g + b * z * z;
    }

    public static double g2_Ej4(double t, double y, double z) {
        return -y;
    }

    public static double f5(double x, double y) {
        return x + y;
    }

    // Interfaces funcionales
    public interface Derivada {
        double f(double x, double y);
    }

    public interface DerivadaSistema {
        double f(double t, double y, double z);
    }

    // Método RK4 para ecuación escalar
    public static void rungeKuttaEscalar(double x0, double y0, double xf, double h, Derivada derivada) {
        int n = (int) ((xf - x0) / h);
        System.out.println("x\t\ty");
        System.out.printf("%.2f\t%.6f%n", x0, y0);

        for (int i = 0; i < n; i++) {
            double k1 = h * derivada.f(x0, y0);
            double k2 = h * derivada.f(x0 + h / 2, y0 + k1 / 2);
            double k3 = h * derivada.f(x0 + h / 2, y0 + k2 / 2);
            double k4 = h * derivada.f(x0 + h, y0 + k3);

            y0 += (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x0 += h;

            System.out.printf("%.2f\t%.6f%n", x0, y0);
        }
    }

    // Método RK4 para sistema de segundo orden
    public static void rungeKuttaSistema(double t0, double y0, double z0, double tf, double h,
                                         DerivadaSistema g1, DerivadaSistema g2) {
        double t = t0, y = y0, z = z0;

        System.out.println("t\t\ty\t\tz");
        System.out.printf("%.2f\t%.6f\t%.6f%n", t, y, z);

        while (t < tf + 1e-6) {
            double k1y = h * g1.f(t, y, z);
            double k1z = h * g2.f(t, y, z);

            double k2y = h * g1.f(t + h / 2, y + k1y / 2, z + k1z / 2);
            double k2z = h * g2.f(t + h / 2, y + k1y / 2, z + k1z / 2);

            double k3y = h * g1.f(t + h / 2, y + k2y / 2, z + k2z / 2);
            double k3z = h * g2.f(t + h / 2, y + k2y / 2, z + k2z / 2);

            double k4y = h * g1.f(t + h, y + k3y, z + k3z);
            double k4z = h * g2.f(t + h, y + k3y, z + k3z);

            y += (k1y + 2 * k2y + 2 * k3y + k4y) / 6.0;
            z += (k1z + 2 * k2z + 2 * k3z + k4z) / 6.0;
            t += h;

            System.out.printf("%.2f\t%.6f\t%.6f%n", t, y, z);
        }
    }

    // Ejercicios
    public static void ejercicio1() {
        System.out.println("\nEjercicio 1 - Crecimiento exponencial");
        rungeKuttaEscalar(0, 1, 1, 0.2, (x, y) -> f1(x, y));
    }

    public static void ejercicio2() {
        System.out.println("\nEjercicio 2 - Enfriamiento");
        rungeKuttaEscalar(0, 90, 5, 1, (x, y) -> f2(x, y));
    }

    public static void ejercicio3() {
        System.out.println("\nEjercicio 3 - Caída libre con fricción");
        rungeKuttaSistema(0, 0, 0, 5, 1,
            (t, y, z) -> g1(t, y, z),
            (t, y, z) -> g2_Ej3(t, y, z)
        );
    }

    public static void ejercicio4() {
        System.out.println("\nEjercicio 4 - Movimiento armónico simple");
        rungeKuttaSistema(0, 0, 1, 2, 0.4,
            (t, y, z) -> g1(t, y, z),
            (t, y, z) -> g2_Ej4(t, y, z)
        );
    }

    public static void ejercicio5() {
        System.out.println("\nEjercicio 5 - Estimación con error");
        rungeKuttaEscalar(0, 1, 0.4, 0.2, (x, y) -> f5(x, y));
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
