package interpolacionlineal;

public class InterpolacionLineal {
    public static Double interpolar(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            return null; // evitar división por cero
        }
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    // Caso 1: Precio de manzanas
    public static void casoPrecioManzanas() {
        double peso1 = 0.5, precio1 = 1.50;
        double peso2 = 1.0, precio2 = 2.80;
        double pesoDeseado = 0.75;
        Double precioEstimado = interpolar(peso1, precio1, peso2, precio2, pesoDeseado);

        if (precioEstimado != null) {
            System.out.printf("Precio estimado para %.2f kg de manzanas: $%.2f%n", pesoDeseado, precioEstimado);
        } else {
            System.out.println("Error en los datos para interpolar el precio.");
        }
    }

    // Caso 2: Distancia de frenado
    public static void casoDistanciaFrenado() {
        double v1 = 30.0, d1 = 10.0;
        double v2 = 80.0, d2 = 50.0;
        double vDeseada = 60.0;

        if (vDeseada < Math.min(v1, v2) || vDeseada > Math.max(v1, v2)) {
            System.out.println("¡Advertencia! La velocidad deseada está fuera del rango de datos conocidos.");
        }

        Double dEstimada = interpolar(v1, d1, v2, d2, vDeseada);

        if (dEstimada != null) {
            System.out.printf("A %.1f km/h, la distancia estimada de frenado es: %.2f metros.%n", vDeseada, dEstimada);
        } else {
            System.out.println("Error en los datos para interpolar la distancia de frenado.");
        }
    }

    // Caso 3: Datos genéricos 1
    public static void casoGenerico1() {
        double x0 = 6, y0 = 12.35, x1 = 9.5, y1 = 13.88, x = 8;
        Double resultado = interpolar(x0, y0, x1, y1, x);

        if (resultado != null) {
            System.out.printf("El valor interpolado en x = %.2f es: f(x) = %.2f%n", x, resultado);
        } else {
            System.out.println("Error: x0 y x1 no pueden ser iguales (división por cero).");
        }
    }

    // Caso 4: Datos genéricos 2
    public static void casoGenerico2() {
        double x0 = 15, y0 = 997.1, x1 = 35, y1 = 994, x = 22.5;
        Double resultado = interpolar(x0, y0, x1, y1, x);

        if (resultado != null) {
            System.out.printf("El valor interpolado en x = %.2f es: f(x) = %.2f%n", x, resultado);
        } else {
            System.out.println("Error: x0 y x1 no pueden ser iguales (división por cero).");
        }
    }

    // Caso 5: División por cero (error esperado)
    public static void casoErrorDivisionPorCero() {
        double x0 = 12, y0 = 45, x1 = 12, y1 = 48.2, x = 12;
        Double resultado = interpolar(x0, y0, x1, y1, x);

        if (resultado != null) {
            System.out.printf("El valor interpolado en x = %.2f es: f(x) = %.2f%n", x, resultado);
        } else {
            System.out.println("Error: x0 y x1 no pueden ser iguales (división por cero).");
        }
    }

    public static void main(String[] args) {
        System.out.println("CASO 1: Precio de manzanas");
        casoPrecioManzanas();

        System.out.println("\nCASO 2: Distancia de frenado");
        casoDistanciaFrenado();

        System.out.println("\nCASO 3: Interpolación genérica 1");
        casoGenerico1();

        System.out.println("\nCASO 4: Interpolación genérica 2");
        casoGenerico2();

        System.out.println("\nCASO 5: Error por división entre cero");
        casoErrorDivisionPorCero();
    }
}
