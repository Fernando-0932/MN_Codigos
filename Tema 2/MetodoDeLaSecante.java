package metododelasecante;

public class MetodoDeLaSecante {
        interface Function {
        double eval(double x);
    }

    public static double secante(Function f, double x0, double x1, double tol, int maxIter) {
        double x2;
        for (int i = 0; i < maxIter; i++) {
            double fx0 = f.eval(x0);
            double fx1 = f.eval(x1);

            if (fx1 - fx0 == 0) {
                throw new ArithmeticException("Division por cero en la iteracion " + i);
            }

            x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);

            if (Math.abs(x2 - x1) < tol) {
                return x2;
            }

            x0 = x1;
            x1 = x2;
        }
        return x1;
    }

    public static void main(String[] args) {
        System.out.println("---- Metodo de la Secante ----");

        Function f1 = x -> x*x - 2;
        double r1 = secante(f1, 0, 2, 1e-6, 100);
        System.out.println("Ejercicio 1: f(x)=x^2 - 2 | Raiz ~ " + r1);

        Function f2 = x -> Math.exp(x) - 3*x;
        double r2 = secante(f2, 0, 1, 1e-6, 100);
        System.out.println("Ejercicio 2: f(x)=e^x - 3x | Raiz ~ " + r2);

        Function f3 = x -> x*x*x - x - 1;
        double r3 = secante(f3, 1, 2, 1e-6, 100);
        System.out.println("Ejercicio 3: f(x)=x^3 - x - 1 | Raiz ~ " + r3);

        Function f4 = x -> Math.log(x) + x - 2;
        double r4 = secante(f4, 1, 2, 1e-6, 100);
        System.out.println("Ejercicio 4: f(x)=ln(x) + x - 2 | Raiz ~ " + r4);

        Function f5 = x -> Math.sin(x) - 0.5;
        double r5 = secante(f5, 0, 2, 1e-6, 100);
        System.out.println("Ejercicio 5: f(x)=sin(x) - 0.5 | Raiz ~ " + r5);

        Function f6 = x -> x*x - 4*x + 3;
        double r6 = secante(f6, 0, 3, 1e-6, 100);
        System.out.println("Ejercicio 6: f(x)=x^2 - 4x + 3 | Raiz ~ " + r6);
    }
}
