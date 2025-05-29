package metododecorrelacion;

public class MetodoDeCorrelacion {
      public static void main(String[] args) {
        correlacionCruzadaBasica();
        correlacionTemperaturas();
        correlacionAudio();
        correlacionVentas();
        correlacionEstudioCalificaciones();
    }

    // 1. Ejemplo básico de correlación cruzada
    public static void correlacionCruzadaBasica() {
        System.out.println("=== Correlación Cruzada Básica ===");
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {0, 0, 1, 2, 3, 4, 5, 0};
        double[] correlacion = correlacionCruzada(x, y);
        mostrarCorrelacion(correlacion, x.length);
    }

    // 2. Correlación de temperaturas
    public static void correlacionTemperaturas() {
        System.out.println("\n=== Correlación de Temperaturas ===");
        double[] semana1 = {22.5, 23.1, 24.3, 25.0, 23.8, 22.0, 21.5};
        double[] semana2 = {19.0, 20.2, 21.3, 22.5, 23.1, 24.3, 25.0, 23.8, 22.0, 21.5, 20.0};
        double[] correlacion = correlacionCruzada(semana1, semana2);
        mostrarCorrelacion(correlacion, semana1.length);
    }

    // 3. Correlación de fragmento de audio
    public static void correlacionAudio() {
        System.out.println("\n=== Correlación de Fragmento de Audio ===");
        double[] fragmento = {0.1, 0.5, 0.8, 0.3, -0.2};
        double[] grabacion = {0.0, 0.1, 0.2, 0.1, 0.5, 0.8, 0.3, -0.2, 0.0, 0.1, -0.1};
        double[] correlacion = correlacionCruzada(fragmento, grabacion);
        mostrarCorrelacion(correlacion, fragmento.length);
    }

    // 4. Correlación de ventas
    public static void correlacionVentas() {
        System.out.println("\n=== Correlación de Ventas ===");
        double[] ventas2022 = {150, 170, 200, 180, 220, 250};
        double[] ventas2023 = {100, 120, 150, 170, 200, 180, 220, 250, 230};
        double[] correlacion = correlacionCruzada(ventas2022, ventas2023);
        mostrarCorrelacion(correlacion, ventas2022.length);
    }

    // 5. Correlación de Pearson: estudio vs calificaciones
    public static void correlacionEstudioCalificaciones() {
        System.out.println("\n=== Correlación Horas de Estudio vs Calificaciones ===");
        double[] horasEstudio = {5, 8, 3, 10, 6};
        double[] calificaciones = {6.0, 7.5, 4.5, 9.0, 7.0};
        double r = calcularCorrelacion(horasEstudio, calificaciones);
        System.out.printf("Coeficiente de correlación de Pearson: %.4f%n", r);
        interpretarCorrelacion(r);
    }

    // MÉTODOS AUXILIARES
    public static double[] correlacionCruzada(double[] x, double[] y) {
        int n = x.length;
        int m = y.length;
        double[] resultado = new double[n + m - 1];
        for (int k = 0; k < resultado.length; k++) {
            double suma = 0.0;
            for (int i = 0; i < n; i++) {
                int j = k + i - (n - 1);
                if (j >= 0 && j < m) {
                    suma += x[i] * y[j];
                }
            }
            resultado[k] = suma;
        }
        return resultado;
    }

    public static int encontrarMaximoLag(double[] correlacion) {
        int maxIndex = 0;
        double maxValor = correlacion[0];
        for (int i = 1; i < correlacion.length; i++) {
            if (correlacion[i] > maxValor) {
                maxValor = correlacion[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void mostrarCorrelacion(double[] correlacion, int xLength) {
        for (int k = 0; k < correlacion.length; k++) {
            int lag = k - (xLength - 1);
            System.out.printf("Lag %2d: %.2f%n", lag, correlacion[k]);
        }
        int maxLag = encontrarMaximoLag(correlacion) - (xLength - 1);
        System.out.println("El mejor desplazamiento (Lag) es: " + maxLag);
    }

    public static double calcularCorrelacion(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
        }
        double numerador = sumXY - (sumX * sumY / n);
        double denominador = Math.sqrt((sumX2 - (sumX * sumX / n)) * (sumY2 - (sumY * sumY / n)));
        return numerador / denominador;
    }

    public static void interpretarCorrelacion(double r) {
        System.out.println("\nInterpretación:");
        if (r >= 0.9) System.out.println("Correlación positiva muy fuerte.");
        else if (r >= 0.7) System.out.println("Correlación positiva fuerte.");
        else if (r >= 0.5) System.out.println("Correlación positiva moderada.");
        else if (r >= 0.3) System.out.println("Correlación positiva débil.");
        else if (r > -0.3) System.out.println("No hay correlación significativa.");
        else if (r > -0.5) System.out.println("Correlación negativa débil.");
        else System.out.println("Correlación negativa fuerte.");
    }
}
