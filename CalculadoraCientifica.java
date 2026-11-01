public class CalculadoraCientifica extends Calculadora {
    private static final double TOLERANCIA = 0.000001;

    public double sen(double angulo) {
        return Math.sin(Math.toRadians(angulo));
    }

    public double cos(double angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    public double tg(double angulo) {
        double anguloNormalizado = angulo % 180;
        if (Math.abs(Math.abs(anguloNormalizado) - 90) < TOLERANCIA) {
            throw new ArithmeticException("Tangente não existe nesse ângulo");
        }
        return Math.tan(Math.toRadians(angulo));
    }

    public double log(double x) {
        return log(x, 10);
    }

    public double log(double x, double base) {
        if (x <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException(
                    "O argumento deve ser positivo e a base deve ser positiva e diferente de 1");
        }
        return Math.log(x) / Math.log(base);
    }

    public double root(double x) throws ComplexRootException {
        return root(x, 2);
    }

    public double root(double x, double indice) throws ComplexRootException {
        if (x < 0) {
            throw new ComplexRootException(
                    "A raiz de um número negativo é complexa");
        }
        if (indice <= 0) {
            throw new IllegalArgumentException("O índice deve ser positivo");
        }
        return Math.pow(x, 1.0 / indice);
    }
}
