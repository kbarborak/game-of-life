package coderetreat;

public class GenerationFactory {

    private NeighbourResolver neighbourResolver;
    private RuleChain ruleChain;

    public GenerationFactory() {
        neighbourResolver = new NeighbourResolver();
        ruleChain = new RuleChain();

        ruleChain.addRule(new ReproductionRule());
        ruleChain.addRule(new SurvivalRule());
    }

    public GenerationFactory(RuleChain ruleChain, NeighbourResolver neighbourResolver) {
        ArgumentValidator.throwIfNotPresent(ruleChain, "ruleChain");
        ArgumentValidator.throwIfNotPresent(neighbourResolver, "neighbourResolver");

        this.neighbourResolver = neighbourResolver;
        this.ruleChain = ruleChain;
    }

    public Generation createNextGeneration(Generation currentGeneration) {
        ArgumentValidator.throwIfNotPresent(currentGeneration, "currentGeneration");

        Generation nextGeneration = new Generation(currentGeneration.getAge() + 1);

        currentGeneration.streamPopulation().forEach(life ->
                ruleChain.apply(new RuleRequest(life, currentGeneration, neighbourResolver)).forEach(nextLife ->
                        nextGeneration.addLife(nextLife)
                )
        );

        return nextGeneration;
    }
}
