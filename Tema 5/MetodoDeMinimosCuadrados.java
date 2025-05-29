package metododeminimoscuadrados;

public class MetodoDeMinimosCuadrados {
       public static void main(String[] args) {
        Problema1();
        Problema2();
        Problema3();
        Problema4();
        Problema5();
    }

    static void Problema1() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 5};
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;
        System.out.printf("Problema 1: y = %.2fx + %.2f%n", m, b);
    }

    static void Problema2() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {1, 4, 9, 16, 25};
        int n = x.length;
        double sumX = 0, sumY = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0, sumXY = 0, sumX2Y = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumX3 += x[i] * x[i] * x[i];
            sumX4 += x[i] * x[i] * x[i] * x[i];
            sumXY += x[i] * y[i];
            sumX2Y += x[i] * x[i] * y[i];
        }
        double[][] A = {
            {n, sumX, sumX2},
            {sumX, sumX2, sumX3},
            {sumX2, sumX3, sumX4}
        };
        double[] B = {sumY, sumXY, sumX2Y};
        int size = B.length;
        for (int i = 0; i < size; i++) {
            double max = A[i][i];
            int maxRow = i;
            for (int k = i + 1; k < size; k++) {
                if (Math.abs(A[k][i]) > Math.abs(max)) {
                    max = A[k][i];
                    maxRow = k;
                }
            }
            double[] temp = A[i];
            A[i] = A[maxRow];
            A[maxRow] = temp;
            double t = B[i];
            B[i] = B[maxRow];
            B[maxRow] = t;
            for (int k = i + 1; k < size; k++) {
                double factor = A[k][i] / A[i][i];
                B[k] -= factor * B[i];
                for (int j = i; j < size; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }
        double[] coef = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            coef[i] = B[i] / A[i][i];
            for (int k = i - 1; k >= 0; k--) {
                B[k] -= A[k][i] * coef[i];
            }
        }
        System.out.printf("Problema 2: y = %.2fx^2 + %.2fx + %.2f%n", coef[2], coef[1], coef[0]);
    }

    static void Problema3() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2.7, 7.4, 20.1, 54.6, 148.4};
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += Math.log(y[i]);
            sumXY += x[i] * Math.log(y[i]);
            sumX2 += x[i] * x[i];
        }
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A_ln = (sumY - B * sumX) / n;
        double A = Math.exp(A_ln);
        System.out.printf("Problema 3: y = %.2fe^(%.2fx)%n", A, B);
    }

    static void Problema4() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2.3, 3.1, 3.8, 4.4, 4.9};
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            double lnX = Math.log(x[i]);
            sumX += lnX;
            sumY += y[i];
            sumXY += lnX * y[i];
            sumX2 += lnX * lnX;
        }
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A = (sumY - B * sumX) / n;
        System.out.printf("Problema 4: y = %.2f + %.2fln(x)%n", A, B);
    }

    static void Problema5() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {3, 7, 12, 18, 26};
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        for (int i = 0; i < n; i++) {
            double lnX = Math.log(x[i]);
            double lnY = Math.log(y[i]);
            sumX += lnX;
            sumY += lnY;
            sumXY += lnX * lnY;
            sumX2 += lnX * lnX;
        }
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A_ln = (sumY - B * sumX) / n;
        double A = Math.exp(A_ln);
        System.out.printf("Problema 5: y = %.2fx^%.2f%n", A, B);
    }
}
