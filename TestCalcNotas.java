public class TestCalcNotas {
    static void testSituacao() throws NotasInsuficientesException {
        CalculadoraNotas calc = new CalculadoraNotas();
        assert calc.checarSituacao(7, 8, 9).equals("APROVADO");
        assert calc.checarSituacao(5, 5, 5).equals("RECUPERACAO");
        assert calc.checarSituacao(1, 3, 2).equals("REPROVADO");
        assert calc.checarSituacao(6, 6, 6).equals("APROVADO");
        assert calc.checarSituacao(4, 4, 4).equals("RECUPERACAO");
        assert calc.checarSituacao(3, 8, 8).equals("RECUPERACAO");
        assert calc.checarSituacao(3, 5, 5).equals("REPROVADO");
        assert calc.checarSituacao(3, 3, 8).equals("REPROVADO");
        assert calc.checarSituacao(4, 6, 6).equals("RECUPERACAO");
        System.out.println("testSituacao passou!");
    }

    static void testDuasNotas() throws NotasInsuficientesException {
        CalculadoraNotas calc = new CalculadoraNotas();
        assert calc.checarSituacao(6, 7).equals("5.0");
        assert calc.checarSituacao(9, 9).equals("4.0");
        assert calc.checarSituacao(4, 4).equals("10.0");
        assert calc.checarSituacao(3, 8).equals("RECUPERACAO");
        assert calc.checarSituacao(3, 2).equals("REPROVADO");
        System.out.println("testDuasNotas passou!");
    }

    static void testValidacao() throws NotasInsuficientesException {
        CalculadoraNotas calc = new CalculadoraNotas();
        assert calc.checarSituacao(0, 10).equals("RECUPERACAO");
        esperaIllegalArgumentException(() -> calc.checarSituacao(-1, 8));
        esperaIllegalArgumentException(() -> calc.checarSituacao(11, 8));
        esperaIllegalArgumentException(() -> calc.checarSituacao(1, 2, 3, 4));
        esperaNotasInsuficientesException(() -> calc.checarSituacao());
        esperaNotasInsuficientesException(() -> calc.checarSituacao(8));
        System.out.println("testValidacao passou!");
    }

    private static void esperaIllegalArgumentException(TesteNotas teste) {
        try {
            teste.executar();
            assert false : "Era esperada IllegalArgumentException!";
        } catch (IllegalArgumentException e) {
            // Exceção esperada.
        } catch (NotasInsuficientesException e) {
            throw new AssertionError("Exceção inesperada", e);
        }
    }

    private static void esperaNotasInsuficientesException(TesteNotas teste) {
        try {
            teste.executar();
            assert false : "Era esperada NotasInsuficientesException!";
        } catch (NotasInsuficientesException e) {
            // Exceção esperada.
        }
    }

    interface TesteNotas {
        void executar() throws NotasInsuficientesException;
    }

    public static void main() throws NotasInsuficientesException {
        testSituacao();
        testDuasNotas();
        testValidacao();
    }
}
