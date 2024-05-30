import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Definir el arreglo de caracteres\
        
        // NO INTENTAR, TARDA MUCHO 
        // char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; // 27! = 10888869450418352160768000000
        char[] chars = {'A', 'C', 'B', 'D'}; // A, C, B, C // 4! = 24

        long startTime = System.currentTimeMillis();

        // Generar Permutaciones
        PermutationCalculate permutationGenerator = new PermutationCalculate(chars);
        List<String> permutations = permutationGenerator.getPermutations();

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        // Imprimir las permutaciones
        int count = 0;
        for (String perm : permutations) {
            System.out.println(count+1 + ". " + perm);
            count++;
        }
        System.out.println("Cantidad de Permutaciones: " + count);
 
        System.out.println("Tiempo transcurrido en calcular el número: " + elapsedTime + " milisegundos");


        // Inicializar los datos de probabilidad conjunta
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator();
        probabilityCalculator.addJointProbability("A", 9);  // Nublado
        probabilityCalculator.addJointProbability("C", 9); // No Nublado
        probabilityCalculator.addJointProbability("B", 10); // Llueve
        probabilityCalculator.addJointProbability("D", 8); // No Llueve
        
        /* 
        // Imprimir probabilidades marginales
        System.out.println("\nProbabilidades Marginales:");
        for (char c : chars) {
            System.out.println("P(" + c + ") = " + probabilityCalculator.getMarginalProbability(c) + "/" + probabilityCalculator.getTotalProbs() + " = " + probabilityCalculator.getMarginalProbability(c) / probabilityCalculator.getTotalProbs());
        }
        */
        

        // Imprimir probabilidades conjuntas
        System.out.println("\nProbabilidades Conjuntas:");
        for (String perm : permutations) {
            List<String> permutaciones = new List<String>();
            permutaciones.add(perm);

            double prob = probabilityCalculator.getJointProbability(perm);
            System.out.println(permutaciones);
            System.out.println(prob);
            if (prob > 0.0) {
                System.out.println("P(" + perm + ") = " + prob);
            }
        }

        /* 
        // Imprimir probabilidades condicionales
        System.out.println("\nProbabilidades Condicionales:");
        for (String perm : permutations) {
            for (char c : chars) {
                double condProb = probabilityCalculator.getConditionalProbability(perm, c);
                if (condProb > 0.0) {
                    System.out.println("P(" + perm + " | " + c + ") = " + condProb);
                }
            }
        }
        */
    }
}
