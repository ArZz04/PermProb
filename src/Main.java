import permutaciones.Permutation;
import probability.Conditional;
import probability.Joint;
import probability.Marginal;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicializacion de la clase DS
        DS ds = new DS();
        NewDS dds = new NewDS();

        System.out.println("---------------| DATOS          |-----------------");

        // Obtener los datos de la clase DS
        List<Character> listChars = (List<Character>) ds.getAllSums().getFirst();
        List<Double> listSums = (List<Double>) ds.getAllSums().get(1);

        // Obtener los datos necesarios para las clases
        char[] chars = {listChars.getFirst(), listChars.get(1), listChars.get(2), listChars.get(3)};
        double[] probsM = {listSums.getFirst(), listSums.get(1), listSums.get(2), listSums.get(3)};
        double[] probsJ = {ds.getValue(0,0), ds.getValue(1,1)};
        char[][] jointEvents = {{chars[0], chars[2]}, {chars[1], chars[3]}};

        System.out.println("---------------| INICIALIZACION |-----------------");

        // Inicializacion de las clases
        Permutation permutationsCalc = new Permutation(chars);
        Marginal marginalCalc = new Marginal(chars, probsM);
        Joint jointCalc = new Joint(jointEvents, probsJ , marginalCalc.getTotalProbs());
        Conditional conditionalCalc = new Conditional();

        System.out.println("---------------| PERMUTACIONES  |-----------------");

        // Imprimir las permutaciones
        permutationsCalc.showPermutations();

        System.out.println("\n---------------| MARGINALES |-----------------");

        //Imprimipir las probabilidades marginales
        marginalCalc.showMarginals();

        System.out.println("\n---------------| CONJUNTAS  |-----------------");

        // Imprimir las probabilidades conjuntas
        jointCalc.showJointProbabilities();

        System.out.println("\n---------------| CONDICIONALES |-----------------");

        // Imprimir las probabilidades condicionales

        //   |  A  |  a  |
        // B | 0,0 | 0,1 |
        // b | 1,0 | 1,1 |

        // ----------------------| Bajo Dependencia |--------------------
        System.out.println("\n---------------| DEPENDENCIA   |-----------------");

        // Llueva dado que este nublado | P(B|A)
        // Llueva dado que no este nublado | P(B|a)
        // No llueva dado que este nublado | P(b|A)
        // No llueva dado que no este nublado | P(b|a)
        // Este nublando dado que llueva | P(A|B)
        // Este nublando dado que no llueva | P(A|b)
        // Definir los eventos y los resultados esperados

        Object[][] events = {
                {listChars.get(0), listChars.get(2), ds.getValue(0, 0), ds.getColSum(0)},  // Llueva dado que este nublado | P(B|A)
                {listChars.get(0), listChars.get(3), ds.getValue(0, 1), ds.getColSum(1)},  // Llueva dado que no este nublado | P(B|a)
                {listChars.get(1), listChars.get(2), ds.getValue(1, 0), ds.getColSum(0)},  // No llueva dado que este nublado | P(b|A)
                {listChars.get(1), listChars.get(3), ds.getValue(1, 1), ds.getColSum(1)},  // No llueva dado que no este nublado | P(b|a)
                {listChars.get(2), listChars.get(0), ds.getValue(0, 0), ds.getRowSum(0)},  // Este nublando dado que llueva | P(A|B)
                {listChars.get(2), listChars.get(0), ds.getValue(1, 0), ds.getRowSum(1)}   // Este nublando dado que no llueva | P(A|b)
        };

        // Iterar sobre los eventos y calcular las probabilidades condicionales
        for (Object[] event : events) {
            char[] eventChars = {(char) event[0], (char) event[1]};
            double value = ((Number) event[2]).intValue(); // Convertir a int y luego a double
            double sum = (double) event[3];
            conditionalCalc.getConditional(eventChars, value, sum);
        }

        // ----------------------| Bajo Independencia |--------------------
        System.out.println("---------------| INDEPENDENCIA |-----------------");

        // Llueva dado que este nublado | P(B|A)
        // Lluvia dado que no este nublado | P(B|a)
        // No llueva dado que este nublado | P(b|A)
        // No llueva dado que no este nublado | P(b|a)

        Object[][] events2 = {
                {listChars.get(0), listChars.get(2), dds.getValue(0, 0), dds.getColSum(0)},  // Llueva dado que este nublado | P(B|A)
                {listChars.get(0), listChars.get(3), dds.getValue(0, 1), dds.getColSum(1)},  // Llueva dado que no este nublado | P(B|a)
                {listChars.get(1), listChars.get(2), dds.getValue(1, 0), dds.getColSum(0)},  // No llueva dado que este nublado | P(b|A)
                {listChars.get(1), listChars.get(3), dds.getValue(1, 1), dds.getColSum(1)},  // No llueva dado que no este nublado | P(b|a)
        };

        for (Object[] event : events2) {
            char[] eventChars = {(char) event[0], (char) event[1]};
            double value = ((Number) event[2]).intValue(); // Convertir a int y luego a double
            double sum = (double) event[3];
            conditionalCalc.getConditional(eventChars, value, sum);
        }

        System.out.println("---------------| MARGINAL |-----------------");
        marginalCalc.rMarginal(listChars.get(0), dds.getTotalSum(), dds.getRowSum(0));
        marginalCalc.rMarginal(listChars.get(1), dds.getTotalSum(), dds.getRowSum(1));

    }

}
