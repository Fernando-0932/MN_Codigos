package metododeregresion;

public class MetodoDeRegresion {
      public static double lagrange(double[] x, double[] y, double xEval) {
        double result = 0;
        int n = x.length;
        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }
        return result;
    }

    public static void problemaLagrange1() {
        double[] x = {0, 1, 2};
        double[] y = {1, 3, 2};
        double xEval = 1.5;
        double resultado = lagrange(x, y, xEval);
        System.out.printf("Lagrange - Problema 1: P(%.1f) = %.3f\n", xEval, resultado);
    }

    public static void problemaLagrange2() {
        double[] x = {1, 2, 4};
        double[] y = {2, 1, 3};
        double xEval = 3;
        double resultado = lagrange(x, y, xEval);
        System.out.printf("Lagrange - Problema 2: P(%.1f) = %.3f\n", xEval, resultado);
    }

    public static void problemaLagrangeConError() {
        double[] x = {1, 2, 3};
        double[] y = {1, 4, 9};
        double xEval = 2.5;
        double resultado = lagrange(x, y, xEval);
        System.out.printf("Lagrange - Problema 4 (con error inicial): P(%.1f) = %.3f\n", xEval, resultado);
    }

    // ---------- INTERPOLACIÓN DE NEWTON ----------
    public static double[][] diferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return tabla;
    }

    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        double resultado = tabla[0][0];
        double producto = 1;
        for (int i = 1; i < x.length; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }
        return resultado;
    }

    public static void problemaNewton1() {
        double[] x = {0, 1, 2};
        double[] y = {1, 3, 2};
        double xEval = 1.5;
        double[][] tabla = diferenciasDivididas(x, y);
        double resultado = evaluarNewton(x, tabla, xEval);
        System.out.printf("Newton - Problema 1: P(%.1f) = %.3f\n", xEval, resultado);
    }

    public static void problemaRendimientoMaquina() {
        double[] tiempo = {1, 2, 4};
        double[] rendimiento = {2, 1, 3};
        double tiempoEstimado = 3;
        double[][] tabla = diferenciasDivididas(tiempo, rendimiento);
        double resultado = evaluarNewton(tiempo, tabla, tiempoEstimado);
        System.out.printf("Rendimiento Máquina: A las %.1f horas = %.3f unidades\n", tiempoEstimado, resultado);
    }

    // ---------- REGRESIÓN LINEAL ----------
    public static void regresionLineal(double[] x, double[] y, String nombreProblema) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];  // Corregido en todos menos problema 5
        }
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;
        System.out.printf("Regresión Lineal - %s: y = %.3f + %.3fx\n", nombreProblema, a, b);
    }

    public static void problemaRegresion1() {
        double[] x = {1, 2, 3};
        double[] y = {2, 3, 5};
        regresionLineal(x, y, "Problema 1");
    }

    public static void problemaRegresion2() {
        double[] x = {0, 1, 2};
        double[] y = {1, 2, 4};
        regresionLineal(x, y, "Problema 2");
    }

    public static void problemaRegresion3() {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 1.3};
        regresionLineal(x, y, "Problema 3");
    }

    public static void problemaRegresion4() {
        double[] x = {2, 4, 6, 8};
        double[] y = {4, 2, 4, 6};
        regresionLineal(x, y, "Problema 4");
    }

    public static void problemaRegresionConError() {
        double[] x = {1, 2, 3};
        double[] y = {2, 4, 6};
        // ERROR intencional: sumX2 calculado como y[i]*y[i]
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += y[i] * y[i];  // ERROR intencional
        }
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;
        System.out.printf("Regresión Lineal - Problema 5 (con error): y = %.3f + %.3fx\n", a, b);
    }

    public static void main(String[] args) {
        // Lagrange
        problemaLagrange1();
        problemaLagrange2();
        problemaLagrangeConError();

        // Newton
        problemaNewton1();
        problemaRendimientoMaquina();

        // Regresión Lineal
        problemaRegresion1();
        problemaRegresion2();
        problemaRegresion3();
        problemaRegresion4();
        problemaRegresionConError();
    }
}
