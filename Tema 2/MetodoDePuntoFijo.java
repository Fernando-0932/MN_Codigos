package metododepuntofijo;

public class MetodoDePuntoFijo {
     interface Function {
        double eval(double x);
    }

    public static double puntoFijo(Function g, double x0, double tol, int maxIter) {
        double x1;
        for (int i = 0; i < maxIter; i++) {
            x1 = g.eval(x0);
            if (Math.abs(x1 - x0) < tol) {
                return x1;
            }
            x0 = x1;
        }
        return x0;
    }

    public static void main(String[] args) {
        System.out.println("---- Metodo de Punto Fijo ----");

        // g(x) = (3/x)^0.5 (para raiz de x^2 - 3 = 0)
        Function g1 = x -> Math.sqrt(3 / x);
        double r1 = puntoFijo(g1, 1.5, 1e-6, 100);
        System.out.println("Ejercicio 1: g(x) = sqrt(3/x) | Raiz ~ " + r1);

        // g(x) = ln(3 - x) (para x + ln(x) = 3)
        Function g2 = x -> Math.log(3 - x);
        double r2 = puntoFijo(g2, 0.5, 1e-6, 100);
        System.out.println("Ejercicio 2: g(x) = ln(3 - x) | Raiz ~ " + r2);

        // g(x) = (5 / (x + 1)) (para x^2 + x -5 = 0)
        Function g3 = x -> 5 / (x + 1);
        double r3 = puntoFijo(g3, 1.5, 1e-6, 100);
        System.out.println("Ejercicio 3: g(x) = 5/(x + 1) | Raiz ~ " + r3);

        // g(x) = cos(x) (para x = cos(x))
        Function g4 = x -> Math.cos(x);
        double r4 = puntoFijo(g4, 0.5, 1e-6, 100);
        System.out.println("Ejercicio 4: g(x) = cos(x) | Raiz ~ " + r4);

        // g(x) = (x + 2) / 3 (para 3x - 2 = x)
        Function g5 = x -> (x + 2) / 3;
        double r5 = puntoFijo(g5, 0.5, 1e-6, 100);
        System.out.println("Ejercicio 5: g(x) = (x + 2)/3 | Raiz ~ " + r5);

        // g(x) = (x^2 + 4) / 5 (para 5x - x^2 - 4 = 0)
        Function g6 = x -> (x*x + 4) / 5;
        double r6 = puntoFijo(g6, 1.0, 1e-6, 100);
        System.out.println("Ejercicio 6: g(x) = (x^2 + 4)/5 | Raiz ~ " + r6);
    }
}
