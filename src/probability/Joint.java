package probability;
import java.util.HashMap;
import java.util.Map;

public class Joint {

    private final Map<String, Double> jointProbabilities;
    private double totalProbs;
    private double[] probsJ; // Almacena los valores de probsJ

    public Joint(char[][] events, double[] probsJ, double probsTotal) {
        jointProbabilities = new HashMap<>();
        totalProbs = 0.0;
        this.probsJ = probsJ; // Almacena los valores de probsJ

        for (int i = 0; i < events.length; i++) {
            String event = String.valueOf(events[i][0]) + events[i][1];
            addJointProbability(event, probsTotal);
        }
    }

    public void addJointProbability(String event, double probsTotal) {
        jointProbabilities.put(event, probsTotal);
    }

    public void showJointProbabilities() {
        System.out.println("\nProbabilidades Conjuntas:");
        int i = 0;
        for (Map.Entry<String, Double> entry : jointProbabilities.entrySet()) {
            String event = entry.getKey();
            double probsTotal = entry.getValue();
            double probability = this.probsJ[i] / probsTotal; // Usar el valor de probsJ correspondiente
            System.out.println("P(" + event + ") = " + this.probsJ[i] + "/" + probsTotal + " = " + probability );
            i++;
        }
    }
}
