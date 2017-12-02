package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationFactoryTest {

    private GenerationFactory generationFactory;

    @BeforeEach
    void setup() {
        generationFactory = new GenerationFactory();
    }

    @Test
    void shouldNotAcceptNullTest() {
        assertThrows(IllegalArgumentException.class, () -> generationFactory.createNextGeneration(null));
    }

    @Test
    void shouldIncreaseAgeTest() {
        Generation generation = generationFactory.createNextGeneration(new Generation(5));

        assertEquals(Integer.valueOf(6), generation.getAge());
    }

    @Test
    void lifeWithFewerThanTwoLiveNeighboursShouldDieTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.withLife(GenerationFixture.oneNeighbour()));

        assertFalse(generation.hasPopulation());
    }

    @Test
    void lifeWithTwoLiveNeighboursShouldStayAliveTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.withLife(GenerationFixture.twoNeighbours()));

        assertTrue(generation.containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithThreeLiveNeighboursShouldStayAliveTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.withLife(GenerationFixture.threeNeighbours()));

        assertTrue(generation.containsLife(new Life(0, 0)));
    }

    @Test
    void lifeWithFourLiveNeighboursShouldDieTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.withLife(GenerationFixture.fourNeighbours()));

        assertFalse(generation.containsLife(new Life(0, 0)));
    }

    @Test
    void noLifeWithThreeLiveNeighboursShouldBeReproducedTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.threeNeighbours());

        assertTrue(generation.containsLife(new Life(0, 0)));
    }

    @Test
    void noLifeWithTwoLiveNeighboursShouldNotBeReproducedTest() {
        Generation generation = generationFactory.createNextGeneration(GenerationFixture.twoNeighbours());

        assertFalse(generation.hasPopulation());
    }

    @Test
    void shouldHaveConstructorForChangingBehaviourTest() {
        NeighbourResolver resolver = new NeighbourResolver();
        RuleChain ruleChain = new RuleChain();

        ruleChain.addRule(new SurvivalRule());

        new GenerationFactory(ruleChain, resolver);
    }

    @Test
    void constructorShouldThrowExceptionWhenArgumentIsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> new GenerationFactory(new RuleChain(), null));
        assertThrows(IllegalArgumentException.class, () -> new GenerationFactory(null, new NeighbourResolver()));
    }
}
