public class CalculadoraNotas extends Calculadora {

    public String checarSituacao(float... notas)
            throws NotasInsuficientesException {
        validarNotas(notas);

        if (notas.length < 2) {
            throw new NotasInsuficientesException(
                    "É necessário informar pelo menos duas notas");
        }
        if (notas.length == 2) {
            return calcularNotaNecessaria(notas);
        }

        double media = (notas[0] + notas[1] + notas[2]) / 3.0;
        int abaixoDeQuatro = contarNotasAbaixoDeQuatro(notas);

        if (abaixoDeQuatro >= 2 || media < 4) {
            return "REPROVADO";
        }
        if (abaixoDeQuatro == 1) {
            return media >= 6 ? "RECUPERACAO" : "REPROVADO";
        }
        return media >= 6 ? "APROVADO" : "RECUPERACAO";
    }

    public String situacao(double n1, double n2, double n3)
            throws NotasInsuficientesException {
        return checarSituacao((float) n1, (float) n2, (float) n3);
    }

    private void validarNotas(float[] notas) {
        if (notas.length > 3) {
            throw new IllegalArgumentException(
                    "A quantidade máxima de notas é três");
        }
        for (float nota : notas) {
            if (Float.isNaN(nota) || nota < 0 || nota > 10) {
                throw new IllegalArgumentException(
                        "Cada nota deve estar entre 0 e 10");
            }
        }
    }

    private String calcularNotaNecessaria(float[] notas) {
        int abaixoDeQuatro = contarNotasAbaixoDeQuatro(notas);
        if (abaixoDeQuatro == 2) {
            return "REPROVADO";
        }
        if (abaixoDeQuatro == 1) {
            return "RECUPERACAO";
        }
        float necessaria = Math.max(4.0f, 18.0f - notas[0] - notas[1]);
        return String.valueOf(necessaria);
    }

    private int contarNotasAbaixoDeQuatro(float[] notas) {
        int quantidade = 0;
        for (float nota : notas) {
            if (nota < 4) {
                quantidade++;
            }
        }
        return quantidade;
    }
}
