public class TestCalcCientifica {
    private static final double TOLERANCIA = 0.000001;

    static void testsSen() {
        CalculadoraCientifica c = new CalculadoraCientifica();
        assert Math.abs(c.sen(0)) < TOLERANCIA;
        assert Math.abs(c.sen(90) - 1) < TOLERANCIA;
        assert Math.abs(c.sen(180)) < TOLERANCIA;
        assert Math.abs(c.sen(270) + 1) < TOLERANCIA;
        System.out.println("testSen passou!");
    }

    static void testsCos() {
        CalculadoraCientifica c = new CalculadoraCientifica();
        assert Math.abs(c.cos(0) - 1) < TOLERANCIA;
        assert Math.abs(c.cos(90)) < TOLERANCIA;
        assert Math.abs(c.cos(180) + 1) < TOLERANCIA;
        assert Math.abs(c.cos(270)) < TOLERANCIA;
        System.out.println("testCos passou!");
    }

    static void testsTg() {
        CalculadoraCientifica c = new CalculadoraCientifica();
        assert Math.abs(c.tg(0)) < TOLERANCIA;
        assert Math.abs(c.tg(45) - 1) < TOLERANCIA;
        assert Math.abs(c.tg(180)) < TOLERANCIA;
        esperaArithmeticException(() -> c.tg(90));
        esperaArithmeticException(() -> c.tg(270));
        esperaArithmeticException(() -> c.tg(-90));
        System.out.println("testTg passou!");
    }

    static void testsLog() {
        CalculadoraCientifica c = new CalculadoraCientifica();
        assert Math.abs(c.log(100) - 2) < TOLERANCIA;
        assert Math.abs(c.log(100, 10) - 2) < TOLERANCIA;
        assert Math.abs(c.log(8, 2) - 3) < TOLERANCIA;
        assert Math.abs(c.log(1, 10)) < TOLERANCIA;
        esperaIllegalArgumentException(() -> c.log(0, 10));
        esperaIllegalArgumentException(() -> c.log(-1, 10));
        esperaIllegalArgumentException(() -> c.log(10, 0));
        esperaIllegalArgumentException(() -> c.log(10, -2));
        esperaIllegalArgumentException(() -> c.log(10, 1));
        System.out.println("testLog passou!");
    }

    static void testsRoot() throws ComplexRootException {
        CalculadoraCientifica c = new CalculadoraCientifica();
        assert Math.abs(c.root(0)) < TOLERANCIA;
        assert Math.abs(c.root(9) - 3) < TOLERANCIA;
        assert Math.abs(c.root(16, 2) - 4) < TOLERANCIA;
        assert Math.abs(c.root(27, 3) - 3) < TOLERANCIA;
        assert Math.abs(c.root(1, 10) - 1) < TOLERANCIA;
        esperaComplexRootException(() -> c.root(-1));
        esperaComplexRootException(() -> c.root(-8, 3));
        System.out.println("testRoot passou!");
    }

    private static void esperaArithmeticException(TesteSemExcecao teste) {
        try {
            teste.executar();
            assert false : "Era esperada ArithmeticException!";
        } catch (ArithmeticException e) {
            // Exceção esperada.
        } catch (ComplexRootException e) {
            throw new AssertionError("Exceção inesperada", e);
        }
    }

    private static void esperaIllegalArgumentException(TesteSemExcecao teste) {
        try {
            teste.executar();
            assert false : "Era esperada IllegalArgumentException!";
        } catch (IllegalArgumentException e) {
            // Exceção esperada.
        } catch (ComplexRootException e) {
            throw new AssertionError("Exceção inesperada", e);
        }
    }

    private static void esperaComplexRootException(TesteSemExcecao teste) {
        try {
            teste.executar();
            assert false : "Era esperada ComplexRootException!";
        } catch (ComplexRootException e) {
            // Exceção esperada.
        }
    }

    interface TesteSemExcecao {
        void executar() throws ArithmeticException, IllegalArgumentException,
                ComplexRootException;
    }

    public static void main() throws ComplexRootException {
        testsSen();
        testsCos();
        testsTg();
        testsLog();
        testsRoot();
    }
}
