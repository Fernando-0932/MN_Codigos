package metododereglafalsa;

public class MetodoDeReglaFalsa {
    interface Function {
        double eval(double x);
    }

    public static double reglaFalsa(Function f, double a, double b, double tol, int maxIter) {
        if (f.eval(a) * f.eval(b) >= 0) {
            throw new IllegalArgumentException("No cumple f(a)*f(b)<0");
        }

        double c = a;
        for (int i = 0; i < maxIter; i++) {
            double fa = f.eval(a);
            double fb = f.eval(b);
            c = (a * fb - b * fa) / (fb - fa);
            double fc = f.eval(c);

            if (Math.abs(fc) < tol) {
                return c;
            }

            if (fa * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("---- Metodo de Regla Falsa ----");

        Function f1 = x -> x*x - 2;
        double r1 = reglaFalsa(f1, 0, 2, 1e-6, 100);
        System.out.println("Ejercicio 1: f(x)=x^2 - 2 | Raiz ~ " + r1);

        Function f2 = x -> Math.exp(x) - 3*x;
        double r2 = reglaFalsa(f2, 0, 1, 1e-6, 100);
        System.out.println("Ejercicio 2: f(x)=e^x - 3x | Raiz ~ " + r2);

        Function f3 = x -> x*x*x - x - 1;
        double r3 = reglaFalsa(f3, 1, 2, 1e-6, 100);
        System.out.println("Ejercicio 3: f(x)=x^3 - x - 1 | Raiz ~ " + r3);

        Function f4 = x -> Math.log(x) + x - 2;
        double r4 = reglaFalsa(f4, 1, 2, 1e-6, 100);
        System.out.println("Ejercicio 4: f(x)=ln(x) + x - 2 | Raiz ~ " + r4);

        Function f5 = x -> Math.sin(x) - 0.5;
        double r5 = reglaFalsa(f5, 0, 2, 1e-6, 100);
        System.out.println("Ejercicio 5: f(x)=sin(x) - 0.5 | Raiz ~ " + r5);

        Function f6 = x -> x*x - 4*x + 3;
        double r6 = reglaFalsa(f6, 0, 3, 1e-6, 100);
        System.out.println("Ejercicio 6: f(x)=x^2 - 4x + 3 | Raiz ~ " + r6);
    }
}
