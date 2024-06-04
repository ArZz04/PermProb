package probability;

import java.util.HashMap;
import java.util.Map;

public class Marginal {

    private final Map<Character, Double> marginalProbabilities;
    private double totalProbs;

    public Marginal(char[] chars, double[] probs) {
        marginalProbabilities = new HashMap<>();
        totalProbs = 0.0;

        for (int i = 0; i < chars.length; i++) {;
            addMarginalProbability(chars[i], probs[i]);
        }
    }

    public double getTotalProbs() {
        return totalProbs;
    }

    public double getMarginalProbability(char event) {
        return marginalProbabilities.getOrDefault(event, 0.0);
    }

    public void addMarginalProbability(char event, double probability) {
        marginalProbabilities.put(event, probability);
        totalProbs += probability / 2;
    }

    public void showMarginals() {
        System.out.println("\nProbabilidades Marginales:");
        for (char c : marginalProbabilities.keySet()) {
            System.out.println("P(" + c + ") = " + getMarginalProbability(c) + "/" + totalProbs + " = " + getMarginalProbability(c) / totalProbs);
        }
    }

    public void rMarginal(char character, double total, double value) {
        System.out.println("P(" + character + ") = " + value + "/" + totalProbs + " = " + value / totalProbs);
    }
}
