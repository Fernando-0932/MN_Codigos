package metododepasomultiple;

public class MetodoDePasoMultiple {
    public static double f1(double t, double y) { return y; } // Ej. 1
    public static double f2(double t, double y) { return Math.pow(y + t, 2) - 1; } // Ej. 2
    public static double f3(double t, double v) { return 9.8 - 0.1 * v; } // Ej. 3
    public static double f4(double t, double T) { return -0.07 * (T - 22); } // Ej. 4
    public static double f5(double t, double y) { return -2 * y; } // Ej. 5

    // Ejercicio 1: Adams-Bashforth 4 pasos
    public static void ejercicio1() {
        double h = 0.2, t0 = 0.0, y0 = 1.0, tf = 1.0;
        int n = (int) ((tf - t0) / h);
        double[] t = new double[n+1];
        double[] y = new double[n+1];
        double[] exacto = new double[n+1];

        t[0] = t0; y[0] = y0; exacto[0] = Math.exp(t0);

        for (int i = 0; i < 3; i++) {
            double k1 = f1(t[i], y[i]);
            double k2 = f1(t[i] + h/2, y[i] + h*k1/2);
            double k3 = f1(t[i] + h/2, y[i] + h*k2/2);
            double k4 = f1(t[i] + h, y[i] + h*k3);
            y[i+1] = y[i] + h*(k1 + 2*k2 + 2*k3 + k4)/6;
            t[i+1] = t[i] + h;
            exacto[i+1] = Math.exp(t[i+1]);
        }

        for (int i = 3; i < n; i++) {
            y[i+1] = y[i] + h * (55*f1(t[i],y[i]) - 59*f1(t[i-1],y[i-1]) + 37*f1(t[i-2],y[i-2]) - 9*f1(t[i-3],y[i-3])) / 24;
            t[i+1] = t[i] + h;
            exacto[i+1] = Math.exp(t[i+1]);
        }

        System.out.println("\nEjercicio 1 - AB4 vs Exacto");
        System.out.println("Paso\t t\t\t y(AB4)\t\t y(Exacto)\t Error");
        for (int i = 0; i <= n; i++) {
            double error = Math.abs(exacto[i] - y[i]);
            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f%n", i, t[i], y[i], exacto[i], error);
        }
    }

    // Ejercicio 2: Predictor-Corrector (AB3 + AM3)
    public static void ejercicio2() {
        double h = 0.1, tf = 0.5;
        int n = (int) (tf / h);
        double[] t = new double[n+1];
        double[] y = new double[n+1];
        t[0] = 0; y[0] = 0;

        for (int i = 0; i < 2; i++) {
            double k1 = f2(t[i], y[i]);
            double k2 = f2(t[i] + h/2, y[i] + h*k1/2);
            double k3 = f2(t[i] + h/2, y[i] + h*k2/2);
            double k4 = f2(t[i] + h, y[i] + h*k3);
            y[i+1] = y[i] + h*(k1 + 2*k2 + 2*k3 + k4)/6;
            t[i+1] = t[i] + h;
        }

        for (int i = 2; i < n; i++) {
            double yp = y[i] + h*(23*f2(t[i],y[i]) - 16*f2(t[i-1],y[i-1]) + 5*f2(t[i-2],y[i-2])) / 12;
            double tp = t[i] + h;
            y[i+1] = y[i] + h*(9*f2(tp, yp) + 19*f2(t[i],y[i]) - 5*f2(t[i-1],y[i-1]) + f2(t[i-2],y[i-2])) / 24;
            t[i+1] = tp;
        }

        System.out.println("\nEjercicio 2 - AB3 + AM3");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%.2f\t %.6f%n", t[i], y[i]);
        }
    }

    // Ejercicio 3: v' = 9.8 - 0.1v
    public static void ejercicio3() {
        double h = 0.2;
        double[] t = {0.0, 0.2, 0.4};
        double[] v = {0.0, 1.96, 3.724};
        double f0 = f3(t[0], v[0]);
        double f1 = f3(t[1], v[1]);
        double f2 = f3(t[2], v[2]);
        double v3 = v[2] + h * (23*f2 - 16*f1 + 5*f0) / 12;
        System.out.printf("\nEjercicio 3 - v(0.6) ≈ %.5f m/s%n", v3);
    }

    // Ejercicio 4: Ley de Enfriamiento
    public static void ejercicio4() {
        double h = 0.1;
        double[] t = {0.0, 0.1, 0.2};
        double[] T = {90.0, 83.66, 78.02};
        double f0 = f4(t[0], T[0]);
        double f1 = f4(t[1], T[1]);
        double f2 = f4(t[2], T[2]);
        double T3 = T[2] + h * (23*f2 - 16*f1 + 5*f0) / 12;
        System.out.printf("\nEjercicio 4 - T(0.3) ≈ %.5f °C%n", T3);
    }

    // Ejercicio 5: Error comparado con solución exacta y = e^(-2t)
    public static void ejercicio5() {
        double h = 0.1;
        double[] t = {0.0, 0.1, 0.2};
        double[] y = {1.0, 0.81873, 0.67032};
        double f0 = f5(t[0], y[0]);
        double f1 = f5(t[1], y[1]);
        double f2 = f5(t[2], y[2]);
        double y3 = y[2] + h * (23*f2 - 16*f1 + 5*f0) / 12;
        double exact = Math.exp(-2 * 0.3);
        double error = Math.abs(exact - y3);
        System.out.printf("\nEjercicio 5 - y(0.3) ≈ %.5f (Exacto: %.5f, Error: %.5f)%n", y3, exact, error);
    }

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }
}
