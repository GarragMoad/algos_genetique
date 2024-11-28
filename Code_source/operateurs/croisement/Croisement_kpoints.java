package operateurs.croisement;

import representation.Solution;
import java.util.Arrays;

public class Croisement_kpoints extends Croisement {

    private int k;

    public Croisement_kpoints(Solution parent1, Solution parent2, double proba, int k) {
        super(parent1, parent2, proba);
        this.k = k;
    }

    @Override
    public void croiser() {
        int nb_variables_decision = parent1.getNb_variables_decision();

        enfant1 = new Solution(parent1);
        enfant2 = new Solution(parent2);

        double aleatoire = Math.random();

        if (aleatoire <= proba) {
            int[] points = new int[k];
            for (int i = 0; i < k; i++) {
                points[i] = (int) (Math.random() * nb_variables_decision);
            }
            Arrays.sort(points);

            boolean swap = false;
            int start = 0;
            for (int point : points) {
                for (int i = start; i < point; i++) {
                    if (swap) {
                        enfant1.setVariable(i, parent2.getDoubleVariable(i));
                        enfant2.setVariable(i, parent1.getDoubleVariable(i));
                    } else {
                        enfant1.setVariable(i, parent1.getDoubleVariable(i));
                        enfant2.setVariable(i, parent2.getDoubleVariable(i));
                    }
                }
                swap = !swap;
                start = point;
            }

            for (int i = start; i < nb_variables_decision; i++) {
                if (swap) {
                    enfant1.setVariable(i, parent2.getDoubleVariable(i));
                    enfant2.setVariable(i, parent1.getDoubleVariable(i));
                } else {
                    enfant1.setVariable(i, parent1.getDoubleVariable(i));
                    enfant2.setVariable(i, parent2.getDoubleVariable(i));
                }
            }
        }
    }
}