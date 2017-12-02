package coderetreat;

import java.util.HashSet;
import java.util.Set;

public class SurvivalRule extends Rule {

    @Override
    public Boolean breakChain() {
        return false;
    }

    @Override
    public Set<Life> handle(RuleRequest request) {
        Set<Life> lifeToNextGeneration = new HashSet<>();
        int liveNeighbours = request.getNeighbourResolver().resolvePopulated(request.getLife(), request.getCurrentGeneration()).size();

        if (liveNeighbours == 2 || liveNeighbours == 3) {
            lifeToNextGeneration.add(request.getLife());
        }

        return lifeToNextGeneration;
    }
}
