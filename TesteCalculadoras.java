public class TesteCalculadoras {

    public static void main(String[] args)
            throws ComplexRootException, NotasInsuficientesException {
        TestCalcCientifica.main();
        TestCalcNotas.main();
        TestsCalc.main();

        System.out.println("Todos os testes passaram!");
    }
}
