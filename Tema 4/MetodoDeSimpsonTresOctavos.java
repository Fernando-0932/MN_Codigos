package metododesimpsontresoctavos;

public class MetodoDeSimpsonTresOctavos {
      public static void main(String[] args) {
        System.out.println("Ejemplo 1: f(x) = sin(x)");
        SimpsonSin.main(null);

        System.out.println("\nEjemplo 2: f(x) = x^4 - 2x + 1");
        SimpsonPolinomio.main(null);

        System.out.println("\nEjemplo 3: f(x) = e^x");
        SimpsonExponencial.main(null);

        System.out.println("\nEjemplo 4: f(x) = x^2");
        SimpsonCuadrado.main(null);

        System.out.println("\nEjemplo 5: f(x) = ln(x + 1) en [1, 2]");
        SimpsonLog1.main(null);

        System.out.println("\nEjemplo 6: f(x) = ln(x + 1) en [1, 2.5]");
        SimpsonLog2.main(null);
    }
}

// Ejemplo 1: f(x) = sin(x)
class SimpsonSin {
    public static double f(double x) {
        return Math.sin(x);
    }

    public static double simpsonThreeEighths(double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n debe ser múltiplo de 3 para el método de Simpson 3/8.");
        }
        double h = (b - a) / n;
        double sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 3 == 0 ? 2 : 3) * f(x);
        }
        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        double a = 0, b = Math.PI / 2;
        int n = 6;
        double resultado = simpsonThreeEighths(a, b, n);
        System.out.println("Resultado aproximado con Simpson 3/8: " + resultado);
        System.out.println("Valor exacto esperado: 1.0");
        System.out.println("Error absoluto: " + Math.abs(1.0 - resultado));
    }
}

// Ejemplo 2: f(x) = x^4 - 2x + 1
class SimpsonPolinomio {
    public static double f(double x) {
        return Math.pow(x, 4) - 2 * x + 1;
    }

    public static double simpsonThreeEighths(double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n debe ser múltiplo de 3 para Simpson 3/8.");
        }
        double h = (b - a) / n;
        double sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 3 == 0 ? 2 : 3) * f(x);
        }
        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        double a = 0, b = 3;
        int n = 6;
        double result = simpsonThreeEighths(a, b, n);
        System.out.println("Resultado usando Simpson 3/8: " + result);
    }
}

// Ejemplo 3: f(x) = e^x
class SimpsonExponencial {
    public static double f(double x) {
        return Math.exp(x);
    }

    public static void main(String[] args) {
        double a = 0.0, b = 1.0;
        int n = 6;

        if (a >= b) {
            System.out.println("Error: El límite inferior debe ser menor que el superior.");
            return;
        }
        if (n % 3 != 0) {
            System.out.println("Error: El número de subintervalos debe ser múltiplo de 3.");
            return;
        }

        double h = (b - a) / n;
        double suma = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += (i % 3 == 0 ? 2 : 3) * f(xi);
        }

        double resultado = (3 * h / 8) * suma;
        System.out.printf("El valor aproximado de la integral es: %.6f%n", resultado);
    }
}

// Ejemplo 4: f(x) = x^2
class SimpsonCuadrado {
    public static double f(double x) {
        return x * x;
    }

    public static double simpson38(double a, double b, int n) {
        if (n % 3 != 0) {
            System.out.println("n debe ser múltiplo de 3 para Simpson 3/8");
            return -1;
        }
        double h = (b - a) / n;
        double sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 3 == 0 ? 2 : 3) * f(x);
        }
        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        double a = 0, b = 3;
        int n = 6;
        double resultado = simpson38(a, b, n);
        System.out.println("Resultado con Simpson 3/8: " + resultado);
    }
}

// Ejemplo 5: f(x) = ln(x + 1) en [1, 2]
class SimpsonLog1 {
    public static double f(double x) {
        return Math.log(x + 1);
    }

    public static void main(String[] args) {
        double a = 1.0, b = 2.0;
        int n = 6;

        if (a >= b) {
            System.out.println("Error: El límite inferior debe ser menor que el superior.");
            return;
        }
        if (n % 3 != 0) {
            System.out.println("Error: El número de subintervalos debe ser múltiplo de 3.");
            return;
        }

        double h = (b - a) / n;
        double suma = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += (i % 3 == 0 ? 2 : 3) * f(xi);
        }

        double resultado = (3 * h / 8) * suma;
        System.out.printf("El valor aproximado de la integral es: %.6f%n", resultado);
    }
}

// Ejemplo 6: f(x) = ln(x + 1) en [1, 2.5]
class SimpsonLog2 {
    public static double f(double x) {
        return Math.log(x + 1);
    }

    public static void main(String[] args) {
        double a = 1.0, b = 2.5;
        int n = 6;

        if (a >= b) {
            System.out.println("Error: El límite inferior debe ser menor que el superior.");
            return;
        }
        if (n % 3 != 0) {
            System.out.println("Error: El número de subintervalos debe ser múltiplo de 3.");
            return;
        }

        double h = (b - a) / n;
        double suma = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += (i % 3 == 0 ? 2 : 3) * f(xi);
        }

        double resultado = (3 * h / 8) * suma;
        System.out.printf("El valor aproximado de la integral es: %.6f%n", resultado);
    }
}
