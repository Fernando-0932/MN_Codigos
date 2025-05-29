package metododelacuadraturagaussiana;

public class MetodoDeLaCuadraturaGaussiana {
     // === Ejemplo 1: ∫ln(x) dx de 1 a 3 con n=2 ===
    public static double ejemplo1() {
        double a = 1.0, b = 3.0;
        double[] xi = { -1.0 / Math.sqrt(3), 1.0 / Math.sqrt(3) };
        double[] wi = { 1.0, 1.0 };
        double suma = 0.0;
        for (int i = 0; i < 2; i++) {
            double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
            double fx = Math.log(x);
            suma += wi[i] * fx;
        }
        return ((b - a) / 2.0) * suma;
    }

    // === Ejemplo 2: ∫e^(-x^2) dx de 0 a 2 con n=2 ===
    public static double ejemplo2() {
        double a = 0.0, b = 2.0;
        double[] xi = { -1.0 / Math.sqrt(3), 1.0 / Math.sqrt(3) };
        double[] wi = { 1.0, 1.0 };
        double suma = 0.0;
        for (int i = 0; i < 2; i++) {
            double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
            double fx = Math.exp(-x * x);
            suma += wi[i] * fx;
        }
        return ((b - a) / 2.0) * suma;
    }

    // === Ejemplo 3: ∫(3x² + 2x + 1) dx de -1 a 1 con n=2 ===
    public static double ejemplo3() {
        double a = -1.0, b = 1.0;
        double[] xi = { -1.0 / Math.sqrt(3), 1.0 / Math.sqrt(3) };
        double[] wi = { 1.0, 1.0 };
        double suma = 0.0;
        for (int i = 0; i < 2; i++) {
            double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
            double fx = 3 * Math.pow(x, 2) + 2 * x + 1;
            suma += wi[i] * fx;
        }
        return ((b - a) / 2.0) * suma;
    }

    // === Ejemplo 4: ∫sin(x) dx de 0 a π con n=3 ===
    public static double ejemplo4() {
        double a = 0.0, b = Math.PI;
        double[] xi = { -Math.sqrt(3.0 / 5.0), 0.0, Math.sqrt(3.0 / 5.0) };
        double[] wi = { 5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0 };
        double suma = 0.0;
        for (int i = 0; i < 3; i++) {
            double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
            double fx = Math.sin(x);
            suma += wi[i] * fx;
        }
        return ((b - a) / 2.0) * suma;
    }

    // === Ejemplo 5: ∫ln(x)/(x+1) dx de 0 a 1 con n=5 ===
    public static double ejemplo5() {
        double a = 0.0, b = 1.0;
        double[] xi = { -0.906180, -0.538469, 0.0, 0.538469, 0.906180 };
        double[] wi = { 0.236927, 0.478629, 0.568889, 0.478629, 0.236927 };
        double suma = 0.0;
        for (int i = 0; i < 5; i++) {
            double x = ((b - a) / 2.0) * xi[i] + (a + b) / 2.0;
            double fx = Math.log(x) / (x + 1);
            suma += wi[i] * fx;
        }
        return ((b - a) / 2.0) * suma;
    }

    // === Método principal ===
    public static void main(String[] args) {
        System.out.println("========== EJEMPLO 1 ==========");
        System.out.printf("∫ln(x) dx de 1 a 3 ≈ %.6f\n\n", ejemplo1());

        System.out.println("========== EJEMPLO 2 ==========");
        System.out.printf("∫e^(-x^2) dx de 0 a 2 ≈ %.6f\n\n", ejemplo2());

        System.out.println("========== EJEMPLO 3 ==========");
        System.out.printf("∫(3x² + 2x + 1) dx de -1 a 1 ≈ %.6f (Valor exacto: 4.0)\n\n", ejemplo3());

        System.out.println("========== EJEMPLO 4 ==========");
        double approx4 = ejemplo4();
        System.out.printf("∫sin(x) dx de 0 a π ≈ %.6f (Valor exacto: 2.0)\n", approx4);
        System.out.printf("Error absoluto: %.6f\n\n", Math.abs(2.0 - approx4));

        System.out.println("========== EJEMPLO 5 ==========");
        double approx5 = ejemplo5();
        double exact5 = -Math.pow(Math.PI, 2) / 12;
        System.out.printf("∫ln(x)/(x+1) dx de 0 a 1 ≈ %.8f (Valor exacto: %.8f)\n", approx5, exact5);
        System.out.printf("Error absoluto: %.8f\n", Math.abs(exact5 - approx5));
    }
}
