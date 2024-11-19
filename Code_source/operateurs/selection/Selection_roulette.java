package operateurs.selection;

import java.util.ArrayList;
import java.util.Random;
import representation.Solution;

public class Selection_roulette extends Selection {

    private Random random;

    public Selection_roulette(ArrayList<Solution> population) {
        super(population);
        this.random = new Random();
    }

    @Override
    public Solution selectionner() {
        double totalFitness = 0.0;
        for (Solution solution : population) {
            totalFitness += solution.getF();
        }

        double randomValue = random.nextDouble() * totalFitness;
        double cumulativeFitness = 0.0;

        for (Solution solution : population) {
            cumulativeFitness += solution.getF();
            if (cumulativeFitness >= randomValue) {
                return solution;
            }
        }

        return population.get(population.size() - 1);
    }
}