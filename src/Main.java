import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Definir el arreglo de caracteres
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // Generar Permutaciones
        PermutationCalculate permutationGenerator = new PermutationCalculate(chars);
        List<String> permutations = permutationGenerator.getPermutations();

        // Imprimir las permutaciones
        System.out.println("Permutaciones:");
        for (String perm : permutations) {
            System.out.println(perm);
        }

        // Inicializar los datos de probabilidad conjunta
        ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator();
        probabilityCalculator.addJointProbability("AB", 0.2);
        probabilityCalculator.addJointProbability("AC", 0.3);
        probabilityCalculator.addJointProbability("BA", 0.1);
        probabilityCalculator.addJointProbability("BC", 0.4);

        // Imprimir probabilidades marginales
        System.out.println("\nProbabilidades Marginales:");
        for (char c : chars) {
            System.out.println("P(" + c + ") = " + probabilityCalculator.getMarginalProbability(c));
        }

        // Imprimir probabilidades conjuntas
        System.out.println("\nProbabilidades Conjuntas:");
        for (String perm : permutations) {
            double prob = probabilityCalculator.getJointProbability(perm);
            if (prob > 0.0) {
                System.out.println("P(" + perm + ") = " + prob);
            }
        }

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
    }
}
