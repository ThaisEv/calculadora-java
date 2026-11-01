# Testes Unitários com `assert` e TDD

**Universidade Federal do Rio Grande do Norte**  
**Instituto Metrópole Digital - IMD**  
**Tecnologia da Informação**  
**LINGUAGEM DE PROGRAMAÇÃO II**  
**Atividade Prática Assíncrona**

**Aluna:** Thais Evelin Barbosa da Silva
**Matrícula:** 20250039913


## Contexto

Nas últimas aulas vimos testes unitários, a palavra-chave assert e o TDD
(Test-Driven Development). No TDD, cada comportamento nasce de um teste: você
escreve o teste, vê o teste falhar, escreve o mínimo de código para ele passar e por
fim melhora o código sem mudar o comportamento (refatoração).

Na última aula, você recebeu a classe Calculadora.java, já implementada, e
começou a desenvolver duas subclasses a partir dela. Nesta prática, você vai
concluir esse trabalho seguindo o ciclo do TDD: fazendo primeiro os cenários de
teste, depois a implementação.

## Como executar os testes

Compile as classes e execute os testes com as asserções habilitadas:

```bash
javac *.java
java -ea TesteCalculadoras
```

A opção `-ea` (*enable assertions*) é obrigatória. Sem ela, os comandos
`assert` são ignorados e os testes podem aparentar passar mesmo quando há
erros.

## Cenários de teste planejados

Os cenários abaixo foram definidos antes da implementação, seguindo o ciclo
do TDD. Os testes devem ser métodos `static` com `assert`, chamados pelo
`main` de `TesteCalculadoras.java`.

## Resultados esperados por cenário

Além de verificar se o teste passa, foram registrados os valores retornados
ou as exceções esperadas em cada cenário.

### `CalculadoraCientifica`

#### Funções trigonométricas

| Cenário | Retorno esperado |
|---|---|
| `sen(0)` | `0.0` |
| `sen(90)` | `1.0` |
| `sen(180)` | aproximadamente `0.0` |
| `sen(270)` | `-1.0` |
| `cos(0)` | `1.0` |
| `cos(90)` | aproximadamente `0.0` |
| `cos(180)` | `-1.0` |
| `cos(270)` | aproximadamente `0.0` |
| `tg(0)` | `0.0` |
| `tg(45)` | aproximadamente `1.0` |
| `tg(180)` | aproximadamente `0.0` |
| `tg(90)` | lança `ArithmeticException` |
| `tg(270)` | lança `ArithmeticException` |
| `tg(-90)` | lança `ArithmeticException` |

Os ângulos são recebidos em graus e convertidos com `Math.toRadians`.


#### Logaritmo

| Cenário | Retorno esperado |
|---|---|
| `log(100)` | `2.0`, usando base 10 |
| `log(8, 2)` | `3.0` |
| `log(1, 10)` | `0.0` |
| `log(0, 10)` | lança `IllegalArgumentException` |
| `log(-1, 10)` | lança `IllegalArgumentException` |
| `log(10, 0)` | lança `IllegalArgumentException` |
| `log(10, -2)` | lança `IllegalArgumentException` |
| `log(10, 1)` | lança `IllegalArgumentException` |

#### Raiz

| Cenário | Retorno esperado |
|---|---|
| `root(9)` | `3.0`, usando índice 2 |
| `root(16, 2)` | `4.0` |
| `root(27, 3)` | `3.0` |
| `root(1, 10)` | `1.0` |
| `root(0)` | `0.0` |
| `root(-1)` | lança `ComplexRootException` |
| `root(-8, 3)` | lança `ComplexRootException` |

Raízes de números negativos são consideradas complexas conforme a regra da
atividade.

### `CalculadoraNotas`

#### Validação das notas

| Cenário | Retorno esperado |
|---|---|
| `checarSituacao(0, 10)` | `"RECUPERACAO"` |
| Nota menor que `0` | lança `IllegalArgumentException` |
| Nota maior que `10` | lança `IllegalArgumentException` |
| Mais de três notas | lança `IllegalArgumentException` |

#### Três notas

| Cenário | Retorno esperado |
|---|---|
| `checarSituacao(7, 8, 9)` | `"APROVADO"` |
| Média exatamente `6`, como em `(6, 6, 6)` | `"APROVADO"` |
| `checarSituacao(5, 5, 5)` | `"RECUPERACAO"` |
| Média exatamente `4`, como em `(4, 4, 4)` | `"RECUPERACAO"` |
| Uma nota abaixo de `4` e média maior ou igual a `6`, como `(3, 8, 8)` | `"RECUPERACAO"` |
| Uma nota exatamente `4`, como `(4, 6, 6)` | `"RECUPERACAO"` |
| Média menor que `4`, como `(1, 3, 2)` | `"REPROVADO"` |
| Duas notas abaixo de `4`, como `(3, 3, 8)` | `"REPROVADO"` |
| Três notas abaixo de `4` | `"REPROVADO"` |

#### Duas notas

| Cenário | Retorno esperado |
|---|---|
| `checarSituacao(6, 7)` | `"5.0"` |
| `checarSituacao(9, 9)` | `"4.0"` |
| `checarSituacao(4, 4)` | `"10.0"` |
| Uma nota abaixo de `4`, como `(3, 8)` | `"RECUPERACAO"` |
| Duas notas abaixo de `4`, como `(3, 2)` | `"REPROVADO"` |

#### Quantidade insuficiente de notas

| Cenário | Retorno esperado |
|---|---|
| `checarSituacao()` | lança `NotasInsuficientesException` |
| `checarSituacao(8)` | lança `NotasInsuficientesException` |

### Registro da primeira execução no TDD

Na primeira execução, antes da aplicação da tolerância, o teste de
`sen(180)` usava comparação exata (`== 0`). O terminal retornou:

```text
Exception in thread "main" java.lang.AssertionError: ? Era pra ser 0!
        at TestCalcCientifica.testsSen(TestCalcCientifica.java:8)
        at TestCalcCientifica.main(TestCalcCientifica.java:56)
        at TesteCalculadoras.main(TesteCalculadoras.java:4)
```

Esse resultado registrou a etapa de falha do ciclo TDD. O teste falhou não
porque o resultado matemático estivesse incorreto, mas porque o valor
calculado pelo Java era um resíduo muito próximo de zero. Depois da análise,
o teste foi corrigido para comparar o resultado com a tolerância
`0.000001`.

Na mesma etapa inicial do TDD, antes da implementação de
`CalculadoraNotas`, os testes científicos passaram, mas o teste de situação
das notas falhou. O terminal retornou:

```text
testSen passou!
testCos passou!
testTg passou!
testLog passou!
testRoot passou!
Exception in thread "main" java.lang.AssertionError: ? Era pra ser Aprovado!
        at TestCalcNotas.testSituacao(TestCalcNotas.java:4)
        at TestCalcNotas.main(TestCalcNotas.java:11)
        at TesteCalculadoras.main(TesteCalculadoras.java:5)
```

Essa falha era esperada, pois `CalculadoraNotas` ainda não havia sido
implementada. O resultado confirma a etapa de falha do TDD para a regra de
situação acadêmica: primeiro o teste falha e, em seguida, a implementação
deve ser criada para fazê-lo passar.

### Execução final após a implementação

Depois da implementação das calculadoras, das exceções personalizadas e dos
testes dos casos-limite, a suíte foi executada com as asserções habilitadas:

```text
javac *.java
java -ea TesteCalculadoras
```

Resultado final:

```text
testSen passou!
testCos passou!
testTg passou!
testLog passou!
testRoot passou!
testSituacao passou!
testDuasNotas passou!
testValidacao passou!
testSum passou!
testSubtraction passou!
testProduct passou!
testDivision passou!
testDivisionByZero passou!
Todos os testes passaram!
Todos os testes passaram!
```

O primeiro `Todos os testes passaram!` é exibido pelo executor central após
os testes das calculadoras, e o segundo é exibido pelo teste da calculadora
básica. Os arquivos `.class` foram removidos após a execução para que não
sejam incluídos no ZIP de entrega.

### TDD antes das exceções personalizadas

Antes de implementar `ComplexRootException` e
`NotasInsuficientesException`, os testes desses dois comportamentos foram
planejados primeiro. Nessa etapa, ainda não havia uma classe de exceção
personalizada para representar:

- a tentativa de calcular a raiz de um número negativo;
- a chamada de `checarSituacao` com zero ou uma nota.

Assim, os cenários de exceção foram escritos para falhar antes da
implementação. A expectativa era que a compilação ou a execução falhasse por
as classes personalizadas ainda não existirem. Depois, as classes foram
criadas como subclasses de `Exception`, e os testes passaram a verificar os
tipos corretos:

```text
root(-1)       -> ComplexRootException
root(-8, 3)    -> ComplexRootException
checarSituacao()   -> NotasInsuficientesException
checarSituacao(8) -> NotasInsuficientesException
```

##
