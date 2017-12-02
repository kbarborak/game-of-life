package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    private GameOfLife game;

    @BeforeEach
    void setup() {
        game = new GameOfLife();
    }

    @Test
    void shouldRunGameTest() {
        Generation seedGeneration = new Generation();
        seedGeneration.addLife(new Life(0, 0));

        game.initialize(seedGeneration);

        assertThrows(GameOverException.class, () -> game.nextGeneration());
    }

    @Test
    void shouldThrowExceptionWhenNotInitializedTest() {
        assertThrows(IllegalStateException.class, () -> new GameOfLife().nextGeneration());
    }

    @Test
    void initializationShouldThrowExceptionWhenNullOrEmptyGenerationGivenTest() {
        assertThrows(IllegalArgumentException.class, () -> new GameOfLife().initialize(null));
        assertThrows(IllegalArgumentException.class, () -> new GameOfLife().initialize(new Generation()));
    }

    @Test
    void aloneLifeShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.oneNeighbour()));

        assertThrows(GameOverException.class, () -> game.nextGeneration());
    }

    @Test
    void lifeWithTwoLiveNeighboursShouldStayAliveTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.twoNeighbours()));

        assertTrue(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithThreeLiveNeighboursShouldStayAliveTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.threeNeighbours()));

        assertTrue(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithFourLiveNeighboursShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.fourNeighbours()));

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithFiveLiveNeighboursShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.fiveNeighbours()));

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithSixLiveNeighboursShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.sixNeighbours()));

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithSevenLiveNeighboursShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.sevenNeighbours()));

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithEightLiveNeighboursShouldDieTest() {
        game.initialize(GenerationFixture.withLife(GenerationFixture.eightNeighbours()));

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithThreeLiveNeighboursShouldBeReproducedTest() {
        game.initialize(GenerationFixture.threeNeighbours());

        assertTrue(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithFewerThanThreeLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.twoNeighbours());

        assertThrows(GameOverException.class, () -> game.nextGeneration());
    }

    @Test
    void positionWithFourLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.fourNeighbours());

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithFiveLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.fiveNeighbours());

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithSixLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.sixNeighbours());

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithSevenLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.sevenNeighbours());

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void positionWithEightLiveNeighboursShouldNotBeReproducedTest() {
        game.initialize(GenerationFixture.eightNeighbours());

        assertFalse(game.nextGeneration().containsLife(new Life(0, 0)));
    }

    @Test
    void shouldHaveConstructorForSettingGenerationFactoryTest() {
        new GameOfLife(new GenerationFactory(new RuleChain(), new NeighbourResolver()));
    }

    @Test
    void shouldThrowExceptionWhenGenerationFactoryIsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> new GameOfLife(null));
    }
}
