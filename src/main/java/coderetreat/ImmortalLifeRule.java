package coderetreat;

import java.util.HashSet;
import java.util.Set;

public class ImmortalLifeRule extends Rule {

    private Boolean breakChain;

    @Override
    public Boolean breakChain() {
        return breakChain;
    }

    @Override
    public Set<Life> handle(RuleRequest request) {
        Set<Life> lifeToNextGeneration = new HashSet<>();
        breakChain = false;

        if (request.getLife() instanceof ImmortalLife) {
            lifeToNextGeneration.add(request.getLife());
            breakChain = true;
            return lifeToNextGeneration;
        }

        int liveNeighbours = request.getNeighbourResolver().resolvePopulated(request.getLife(), request.getCurrentGeneration()).size();

        if (liveNeighbours == 3) {
            lifeToNextGeneration.add(new ImmortalLife(request.getLife().getX(), request.getLife().getY()));
            breakChain = true;
        }

        return lifeToNextGeneration;
    }
}
