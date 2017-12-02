package coderetreat;

import java.util.HashSet;
import java.util.Set;

public class ReproductionRule extends Rule {

    @Override
    public Boolean breakChain() {
        return false;
    }

    @Override
    public Set<Life> handle(RuleRequest request) {
        Set<Life> lifeToNextGeneration = new HashSet<>();

        request.getNeighbourResolver()
                .resolveUnpopulated(request.getLife(), request.getCurrentGeneration())
                .forEach(possibleLife -> {
                    int liveNeighbours = request.getNeighbourResolver().resolvePopulated(possibleLife, request.getCurrentGeneration()).size();

                    if (liveNeighbours == 3) {
                        lifeToNextGeneration.add(new Life(possibleLife.getX(), possibleLife.getY()));
                    }
                });

        return lifeToNextGeneration;
    }
}
