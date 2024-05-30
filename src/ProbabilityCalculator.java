import java.util.HashMap;
import java.util.Map;

public class ProbabilityCalculator {
    private final Map<String, Double> jointProbabilities;
    private final Map<Character, Double> marginalProbabilities;
    private double totalProbs;

    public ProbabilityCalculator() {
        jointProbabilities = new HashMap<>();
        marginalProbabilities = new HashMap<>();
    }

    public void addJointProbability(String event, double probability) {
        jointProbabilities.put(event, probability);
        for (char c : event.toCharArray()) {
            marginalProbabilities.put(c, marginalProbabilities.getOrDefault(c, 0.0) + probability);
        }
        totalProbs += probability /2;
    }

    public double getTotalProbs() {
        return totalProbs;
    }

    public double getMarginalProbability(char event) {
        return marginalProbabilities.getOrDefault(event, 0.0);
    }

    public double getJointProbability(String event) {
        int omega = event.length();
        return jointProbabilities.getOrDefault(event, 0.0);
    }

    public double getConditionalProbability(String jointEvent, char conditionalEvent) {
        double jointProb = getJointProbability(jointEvent);
        double marginalProb = getMarginalProbability(conditionalEvent);
        if (marginalProb == 0.0) return 0.0;
        return jointProb / marginalProb;
    }
}
