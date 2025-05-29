package interpolacionpolinomica;

public class InterpolacionPolinomica {
      public static double lagrange(double[] x, double[] y, double xEval) {
        double result = 0; // CORREGIDO: estaba en 1 en el problema 4
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

    // Método de diferencias divididas (Newton)
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

    // Evaluación con Newton
    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        double resultado = tabla[0][0];
        double producto = 1;

        for (int i = 1; i < x.length; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // -------- Problema 1: Lagrange --------
        double[] x1 = {0, 1, 2};
        double[] y1 = {1, 3, 2};
        double xEval1 = 1.5;
        double resultado1 = lagrange(x1, y1, xEval1);
        System.out.printf("Problema 1 (Lagrange): P(%.1f) = %.3f\n", xEval1, resultado1);

        // -------- Problema 2: Newton --------
        double[] x2 = {0, 1, 2};
        double[] y2 = {1, 3, 2};
        double xEval2 = 1.5;
        double[][] tabla2 = diferenciasDivididas(x2, y2);
        double resultado2 = evaluarNewton(x2, tabla2, xEval2);
        System.out.printf("Problema 2 (Newton): P(%.1f) = %.3f\n", xEval2, resultado2);

        // -------- Problema 3: Estimación producción --------
        double[] tiempo = {1, 2, 4}; // horas
        double[] rendimiento = {2, 1, 3}; // unidades
        double tiempoEstimado = 3;
        double[][] tabla3 = diferenciasDivididas(tiempo, rendimiento);
        double resultado3 = evaluarNewton(tiempo, tabla3, tiempoEstimado);
        System.out.printf("Problema 3 (Producción estimada): a las %.1f horas = %.3f unidades\n", tiempoEstimado, resultado3);

        // -------- Problema 4: Lagrange (con cuadrática) --------
        double[] x4 = {1, 2, 3};
        double[] y4 = {1, 4, 9}; // y = x^2
        double xEval4 = 2.5;
        double resultado4 = lagrange(x4, y4, xEval4);
        System.out.printf("Problema 4 (Lagrange cuadrática): P(%.1f) = %.3f\n", xEval4, resultado4);
    }
}
