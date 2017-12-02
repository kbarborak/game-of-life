package coderetreat;

public class RuleRequest {

    private Life life;
    private Generation currentGeneration;
    private NeighbourResolver neighbourResolver;

    public RuleRequest(Life life, Generation currentGeneration, NeighbourResolver neighbourResolver) {
        ArgumentValidator.throwIfNotPresent(life, "life");
        ArgumentValidator.throwIfNotPresent(currentGeneration, "currentGeneration");
        ArgumentValidator.throwIfNotPresent(neighbourResolver, "neighbourResolver");

        this.life = life;
        this.currentGeneration = currentGeneration;
        this.neighbourResolver = neighbourResolver;
    }

    public Life getLife() {
        return life;
    }

    public Generation getCurrentGeneration() {
        return currentGeneration;
    }

    public NeighbourResolver getNeighbourResolver() {
        return neighbourResolver;
    }
}
