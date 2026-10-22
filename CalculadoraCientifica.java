public class CalculadoraCientifica extends Calculadora {

    public double sen(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tg(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    public double log(double x, double base) {
        if (x <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("O logaritmo não é definido para valores menores ou iguais a zero, e a base não pode ser 1");
        }
        return Math.log(x) / Math.log(base);
    }

    public double root(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo");
        }
        double index = 2;
        return Math.pow(x, 1.0 / index);
    }
    


}
