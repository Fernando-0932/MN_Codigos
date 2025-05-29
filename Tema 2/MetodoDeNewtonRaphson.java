package metododenewtonraphson;

public class MetodoDeNewtonRaphson {
    interface Function {
        double eval(double x);
    }

    interface Derivative {
        double eval(double x);
    }

    public static double newtonRaphson(Function f, Derivative df, double x0, double tol, int maxIter) {
        double x1;
        for (int i = 0; i < maxIter; i++) {
            double fx0 = f.eval(x0);
            double dfx0 = df.eval(x0);

            if (dfx0 == 0) {
                throw new ArithmeticException("Derivada cero en la iteracion " + i);
            }

            x1 = x0 - fx0 / dfx0;

            if (Math.abs(x1 - x0) < tol) {
                return x1;
            }
            x0 = x1;
        }
        return x0;
    }

    public static void main(String[] args) {
        System.out.println("---- Metodo de Newton-Raphson ----");

        Function f1 = x -> x*x - 2;
        Derivative df1 = x -> 2*x;
        double r1 = newtonRaphson(f1, df1, 1, 1e-6, 100);
        System.out.println("Ejercicio 1: f(x)=x^2 - 2 | Raiz ~ " + r1);

        Function f2 = x -> Math.exp(x) - 3*x;
        Derivative df2 = x -> Math.exp(x) - 3;
        double r2 = newtonRaphson(f2, df2, 1, 1e-6, 100);
        System.out.println("Ejercicio 2: f(x)=e^x - 3x | Raiz ~ " + r2);

        Function f3 = x -> x*x*x - x - 1;
        Derivative df3 = x -> 3*x*x - 1;
        double r3 = newtonRaphson(f3, df3, 1, 1e-6, 100);
        System.out.println("Ejercicio 3: f(x)=x^3 - x - 1 | Raiz ~ " + r3);

        Function f4 = x -> Math.log(x) + x - 2;
        Derivative df4 = x -> 1/x + 1;
        double r4 = newtonRaphson(f4, df4, 1.5, 1e-6, 100);
        System.out.println("Ejercicio 4: f(x)=ln(x) + x - 2 | Raiz ~ " + r4);

        Function f5 = x -> Math.sin(x) - 0.5;
        Derivative df5 = x -> Math.cos(x);
        double r5 = newtonRaphson(f5, df5, 0.5, 1e-6, 100);
        System.out.println("Ejercicio 5: f(x)=sin(x) - 0.5 | Raiz ~ " + r5);

        Function f6 = x -> x*x - 4*x + 3;
        Derivative df6 = x -> 2*x - 4;
        double r6 = newtonRaphson(f6, df6, 3, 1e-6, 100);
        System.out.println("Ejercicio 6: f(x)=x^2 - 4x + 3 | Raiz ~ " + r6);
    }
}
