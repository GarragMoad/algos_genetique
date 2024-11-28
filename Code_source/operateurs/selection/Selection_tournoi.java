package operateurs.selection;

import java.util.ArrayList;
import java.util.Random;
import representation.Solution;
public class Selection_tournoi extends Selection{
    private int k;
    private Random random;

    public Selection_tournoi(ArrayList<Solution> population, int k) {
        super(population);
        this.k = k;
        this.random = new Random();
    }

    @Override
    public Solution selectionner() {
        ArrayList<Solution> tournoi = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int index = random.nextInt(population.size());
            tournoi.add(population.get(index));
        }

        Solution meilleureSolution = tournoi.get(0);
        for (Solution solution : tournoi) {
            if (solution.getF() > meilleureSolution.getF()) {
                meilleureSolution = solution;
            }
        }

        return meilleureSolution;
    }
}
