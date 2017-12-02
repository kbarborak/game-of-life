package coderetreat;

/**
 * Conway's Game of Life implementation.
 */
public class GameOfLife {

    private Boolean isInitialized = false;
    private Generation currentGeneration;
    private GenerationFactory generationFactory;

    public GameOfLife() {
        generationFactory = new GenerationFactory();
    }

    public GameOfLife(GenerationFactory generationFactory) {
        ArgumentValidator.throwIfNotPresent(generationFactory, "generationFactory");

        this.generationFactory = generationFactory;
    }

    public void initialize(Generation seedGeneration) {
        validateSeedGeneration(seedGeneration);
        initializeGame();
        replaceCurrentGeneration(seedGeneration);
    }

    private void validateSeedGeneration(Generation seedGeneration) {
        ArgumentValidator.throwIfNotPresentWithTest(seedGeneration, "seedGeneration", "without population",
                () -> !seedGeneration.hasPopulation());
    }

    private Generation replaceCurrentGeneration(Generation generation) {
        currentGeneration = generation;
        return currentGeneration;
    }

    private void initializeGame() {
        isInitialized = true;
    }

    public Generation nextGeneration() {
        validateIfGameIsInitialized();
        Generation nextGeneration = createNextGeneration();
        endGameWhenNoPopulation(nextGeneration);
        return replaceCurrentGeneration(nextGeneration);
    }

    private void validateIfGameIsInitialized() {
        if (!isInitialized) {
            throw new IllegalStateException("Game has not been initialized with seed generation.");
        }
    }

    private Generation createNextGeneration() {
        return generationFactory.createNextGeneration(currentGeneration);
    }

    private void endGameWhenNoPopulation(Generation generation) {
        if (!generation.hasPopulation()) {
            throw new GameOverException("There is no more life to play with.");
        }
    }
}
