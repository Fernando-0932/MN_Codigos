package metododebiseccion;

public class MetodoDeBiseccion {
      interface Function {
        double eval(double x);
    }

    public static double biseccion(Function f, double a, double b, double tol, int maxIter) {
        if (f.eval(a) * f.eval(b) >= 0) {
            throw new IllegalArgumentException("No cumple f(a)*f(b)<0");
        }
        double c = a;
        for (int i = 0; i < maxIter; i++) {
            c = (a + b) / 2;
            double fc = f.eval(c);

            if (Math.abs(fc) < tol || (b - a) / 2 < tol) {
                return c;
            }

            if (f.eval(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("---- Metodo de Biseccion ----");

        Function f1 = x -> x*x - 3;
        double r1 = biseccion(f1, 1, 2, 1e-6, 100);
        System.out.println("Ejercicio 1: f(x)=x^2 - 3 | Raiz ~ " + r1);

        Function f2 = x -> Math.exp(-x) - x;
        double r2 = biseccion(f2, 0, 1, 1e-6, 100);
        System.out.println("Ejercicio 2: f(x)=e^-x - x | Raiz ~ " + r2);

        Function f3 = x -> x*x*x - 2*x - 5;
        double r3 = biseccion(f3, 2, 3, 1e-6, 100);
        System.out.println("Ejercicio 3: f(x)=x^3 - 2x - 5 | Raiz ~ " + r3);

        Function f4 = x -> Math.log(x) - 1;
        double r4 = biseccion(f4, 2, 3, 1e-6, 100);
        System.out.println("Ejercicio 4: f(x)=ln(x) - 1 | Raiz ~ " + r4);

        Function f5 = x -> Math.sin(x) - 0.7;
        double r5 = biseccion(f5, 0, 2, 1e-6, 100);
        System.out.println("Ejercicio 5: f(x)=sin(x) - 0.7 | Raiz ~ " + r5);

        Function f6 = x -> x*x - 5*x + 6;
        double r6 = biseccion(f6, 1, 3, 1e-6, 100);
        System.out.println("Ejercicio 6: f(x)=x^2 -5x +6 | Raiz ~ " + r6);
    }
}
