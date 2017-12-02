package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    private Generation generation;

    @BeforeEach
    void setup() {
        generation = new Generation();
    }

    @Test
    void shouldCreateNewInstanceTest() {
        assertEquals(Integer.valueOf(0), generation.getAge());
        assertEquals(Integer.valueOf(0), generation.countPopulation());
    }

    @Test
    void shouldCountAmountOfPopulationTest() {
        generation.addLife(new Life(0, 0));

        assertEquals(Integer.valueOf(1), generation.countPopulation());
    }

    @Test
    void shouldNotAcceptNullWhenNewLifeIsAddedTest() {
        assertThrows(IllegalArgumentException.class, () -> new Generation().addLife(null));
    }

    @Test
    void shouldNotAcceptDuplicatesWhenNewLifeIsAddedTest() {
        generation.addLife(new Life(0, 0));
        generation.addLife(new Life(0, 0));
        generation.addLife(new Life(1, 0));

        assertEquals(Integer.valueOf(2), generation.countPopulation());
    }

    @Test
    void shouldContainsLifeTest() {
        generation.addLife(new Life(1, 0));

        assertTrue(generation.containsLife(new Life(1, 0)));
        assertFalse(generation.containsLife(new Life(1, 3)));
    }

    @Test
    void shouldThrowExceptionWhenNullInContainsLifeTest() {
        assertThrows(IllegalArgumentException.class, () -> generation.containsLife(null));
    }

    @Test
    void shouldContainLifeAtParticularPositionTest() {
        generation.addLife(new Life(1, 0));

        assertTrue(generation.containsLifeAt(new Neighbour(1, 0)));
        assertFalse(generation.containsLifeAt(new Neighbour(1, 3)));
    }

    @Test
    void shouldThrowExceptionWhenNullInContainsLifeAtTest() {
        assertThrows(IllegalArgumentException.class, () -> generation.containsLifeAt(null));
    }

    @Test
    void shouldSetAgeTest() {
        assertEquals(Integer.valueOf(8), new Generation(8).getAge());
    }

    @Test
    void shouldNotAcceptNullOrNegativeNumberAsAgeTest() {
        assertThrows(IllegalArgumentException.class, () -> new Generation(-1));
        assertThrows(IllegalArgumentException.class, () -> new Generation(null));
    }

    @Test
    void shouldAnswerTheQuestionIfThereIsPopulationTest() {
        assertFalse(generation.hasPopulation());

        generation.addLife(new Life(0, 0));
        generation.addLife(new Life(1, 0));

        assertTrue(generation.hasPopulation());
    }

    @Test
    void shouldReturnStreamForIterationOverPopulationTest() {
        generation.addLife(new Life(0, 0));
        generation.addLife(new Life(1, 0));

        assertEquals(2, generation.streamPopulation().count());
    }

    @Test
    void shouldReturnToStringTest() {
        generation.addLife(new Life(0, 0));

        assertEquals("Generation 0 [Life [0, 0]]", generation.toString());
    }

    @Test
    void shouldReturnSameHashCodeForSameGenerationTest() {
        Generation one = new Generation(8);

        one.addLife(new Life(5, 8));
        one.addLife(new Life(8, 5));

        Generation two = new Generation(8);

        two.addLife(new Life(8, 5));
        two.addLife(new Life(5, 8));

        assertEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void shouldNotReturnDifferentHashCodeForDifferentGenerationsTest() {
        Generation one = new Generation(8);

        one.addLife(new Life(5, 8));
        one.addLife(new Life(8, 5));

        Generation two = new Generation(7);

        two.addLife(new Life(8, 5));
        two.addLife(new Life(5, 8));

        Generation three = new Generation(8);

        three.addLife(new Life(5, 8));
        three.addLife(new Life(7, 8));

        Generation four = new Generation(8);

        four.addLife(new Life(8, 5));
        four.addLife(new Life(5, 8));

        assertNotEquals(one.hashCode(), two.hashCode());
        assertNotEquals(three.hashCode(), four.hashCode());
    }

    @Test
    void shouldEqualForSameGenerationTest() {
        Generation one = new Generation(8);

        one.addLife(new Life(5, 8));
        one.addLife(new Life(8, 5));

        Generation two = new Generation(8);

        two.addLife(new Life(8, 5));
        two.addLife(new Life(5, 8));

        assertEquals(one, two);
    }

    @Test
    void shouldNotEqualForDifferentGenerationTest() {
        Generation one = new Generation(8);

        one.addLife(new Life(5, 8));
        one.addLife(new Life(1, 5));

        Generation two = new Generation(8);

        two.addLife(new Life(8, 5));
        two.addLife(new Life(5, 8));

        assertNotEquals(one, two);
    }
}
