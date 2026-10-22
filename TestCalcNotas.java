public class TestCalcNotas {
    static void testSituacao() {
        CalculadoraNotas calc = new CalculadoraNotas();
        assert calc.situacao(7.0, 8.0, 9.0) == "APROVADO" : "❌ Era pra ser Aprovado!";
        assert calc.situacao(5.0, 5.0, 5.0) == "RECUPERACAO" : "❌ Era pra ser Recuperacao!";
        assert calc.situacao(1.0, 3.0, 2.0) == "REPROVADO" : "❌ Era pra ser Reprovado!";
        System.out.println("✅  testSituacao passou!");
    }
    
    public static void main() {
        testSituacao();
    }
}
