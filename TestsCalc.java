public class TestsCalc {

    static void testSum() {
        Calculadora calc = new Calculadora();

        assert calc.soma(2, 3) == 5;
        assert calc.soma(2, -3) == -1;
        assert calc.soma(10, 0) == 10;
        assert calc.soma(0, 0) == 0;
        assert calc.soma(5, 5) == 10;
        assert calc.soma(200000, 3) == 200003;

        System.out.println("✅  testSum passou!");
    }
    
    static void testSubtraction () {
        Calculadora calc = new Calculadora();

        assert calc.subtracao(2, 3) == -1 : "❌ Era pra ser -1!";
        assert calc.subtracao(2, -3) == 5;
        assert calc.subtracao(10, 0) == 10;
        assert calc.subtracao(0, 0) == 0;
        assert calc.subtracao(5, 5) == 0;
        assert calc.subtracao(200000, 3) == 199997;

        System.out.println("✅  testSubtraction passou!");
    }
 
    static void testProduct () {
        Calculadora calc = new Calculadora();

        assert calc.multiplicacao(2, 3) == 6 : "❌ Era pra ser 6!";
        assert calc.multiplicacao(2, -3) == -6;
        assert calc.multiplicacao(10, 0) == 0;
        assert calc.multiplicacao(0, 0) == 0;
        assert calc.multiplicacao(5, 5) == 25;
        assert calc.multiplicacao(200000, 3) == 600000;

        System.out.println("✅  testProduct passou!");
    } 
    static void testDivision () {
        Calculadora calc = new Calculadora();
        assert calc.divisao(18, 3) == 6 : "❌ Era pra ser 6!";
        System.out.println("✅  testDivision passou!");
    }

    static void testDivisionByZero () {
        Calculadora calc = new Calculadora();

        try {
            calc.divisao(10, 0);
            assert false : "❌ Era pra levantar ArithmeticException!";
        } catch (ArithmeticException ae) {
            System.out.println("✅  testDivisionByZero passou!");
        }
    }

    public static void main() {
        testSum();
        testSubtraction();
        testProduct();
        testDivision();
        testDivisionByZero();
        System.out.println("Todos os testes passaram!");
    }

}
