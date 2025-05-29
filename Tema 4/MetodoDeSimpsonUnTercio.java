package metododesimpson;


public class MetodoDeSimpsonUnTercio {
       // f(x) = x^2
    public static class Cuadratica {
        public static double f(double x) {
            return x * x;
        }

        public static double calcular(double a, double b, int n) {
            if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par para Simpson 1/3.");
            double h = (b - a) / n;
            double sum = f(a) + f(b);
            for (int i = 1; i < n; i++) {
                double x = a + i * h;
                sum += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
            }
            return (h / 3) * sum;
        }
    }

    // f(x) = x^4 - 2x + 1
    public static class Polinomica {
        public static double f(double x) {
            return Math.pow(x, 4) - 2 * x + 1;
        }

        public static double calcular(double a, double b, int n) {
            if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par.");
            double h = (b - a) / n;
            double sum = f(a) + f(b);
            for (int i = 1; i < n; i += 2) sum += 4 * f(a + i * h);
            for (int i = 2; i < n; i += 2) sum += 2 * f(a + i * h);
            return (h / 3) * sum;
        }
    }

    // f(x) = ln(x)
    public static class Logaritmica {
        public static double f(double x) {
            return Math.log(x);
        }

        public static double calcular(double a, double b, int n) {
            if (a >= b) throw new IllegalArgumentException("El límite inferior debe ser menor que el superior.");
            if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par.");
            double h = (b - a) / n;
            double sum = f(a) + f(b);
            for (int i = 1; i < n; i++) {
                double x = a + i * h;
                sum += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
            }
            return (h / 3) * sum;
        }
    }

    // f(x) = sin(x)
    public static class Seno {
        public static double f(double x) {
            return Math.sin(x);
        }

        public static double calcular(double a, double b, int n) {
            if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par.");
            double h = (b - a) / n;
            double sum = f(a) + f(b);
            for (int i = 1; i < n; i += 2) sum += 4 * f(a + i * h);
            for (int i = 2; i < n; i += 2) sum += 2 * f(a + i * h);
            return (h / 3) * sum;
        }
    }

    // f(x) = e^(-x^2)
    public static class Exponencial {
        public static double f(double x) {
            return Math.exp(-x * x);
        }

        public static double calcular(double a, double b, int n) {
            if (a >= b) throw new IllegalArgumentException("El límite inferior debe ser menor que el superior.");
            if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par.");
            double h = (b - a) / n;
            double sum = f(a) + f(b);
            for (int i = 1; i < n; i++) {
                double x = a + i * h;
                sum += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
            }
            return (h / 3) * sum;
        }
    }

    public static void main(String[] args) {
        System.out.printf("Integral f(x) = x^2: %.6f\n", Cuadratica.calcular(0, 3, 6));
        System.out.printf("Integral f(x) = x^4 - 2x + 1: %.6f\n", Polinomica.calcular(0, 3, 6));
        System.out.printf("Integral f(x) = ln(x): %.6f\n", Logaritmica.calcular(1, 4, 6));
        System.out.printf("Integral f(x) = sin(x): %.6f\n", Seno.calcular(0, Math.PI, 6));
        System.out.printf("Integral f(x) = e^(-x^2): %.6f\n", Exponencial.calcular(0, 2, 4));
    }
    
}
