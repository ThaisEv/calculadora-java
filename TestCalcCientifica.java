public class TestCalcCientifica {

    static void testsSen() {
        CalculadoraCientifica c = new CalculadoraCientifica();

        assert c.sen(0) == 0 : "❌ Era pra ser 0!";
        assert c.sen(90) == 1 : "❌ Era pra ser 1!";
        assert c.sen(180) == 0 : "❌ Era pra ser 0!";
        assert c.sen(270) == -1 : "❌ Era pra ser -1!";

        System.out.println("✅  testSen passou!");
    }

    static void testsCos() {
        CalculadoraCientifica c = new CalculadoraCientifica();

        assert c.cos(0) == 1 : "❌ Era pra ser 1!";
        assert c.cos(90) == 0 : "❌ Era pra ser 0!";
        assert c.cos(180) == -1 : "❌ Era pra ser -1!";
        assert c.cos(270) == 0 : "❌ Era pra ser 0!";

        System.out.println("✅  testCos passou!");
    }

    static void testsTg() {
        CalculadoraCientifica c = new CalculadoraCientifica();

        assert c.tg(0) == 0 : "❌ Era pra ser 0!";
        assert c.tg(45) == 1 : "❌ Era pra ser 1!";
        assert c.tg(180) == 0 : "❌ Era pra ser 0!";

        System.out.println("✅  testTg passou!");
    }

    static void testsLog() {
        CalculadoraCientifica c = new CalculadoraCientifica();

        assert c.log(100, 10) == 2 : "❌ Era pra ser 2!";
        assert c.log(8, 2) == 3 : "❌ Era pra ser 3!";
        assert c.log(27, 3) == 3 : "❌ Era pra ser 3!";

        System.out.println("✅  testLog passou!");
    }

    static void testsRoot() {
        CalculadoraCientifica c = new CalculadoraCientifica();

        assert c.root(4) == 2 : "❌ Era pra ser 2!";
        assert c.root(9) == 3 : "❌ Era pra ser 3!";
        assert c.root(16) == 4 : "❌ Era pra ser 4!";

        System.out.println("✅  testRoot passou!");
    }

    public static void main() {
        testsSen();
        testsCos();
        testsTg();
        testsLog();
        testsRoot();
    }
    
}
