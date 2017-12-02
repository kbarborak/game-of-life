package coderetreat;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SurvivalRuleTest {

    @Test
    void shouldHandleRequestTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));
        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnLifeWhenTwoLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.twoNeighbours()),
                new NeighbourResolver()));

        assertEquals(1, response.size());
        assertTrue(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldReturnLifeWhenThreeLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0),  GenerationFixture.withLife(GenerationFixture.threeNeighbours()),
                new NeighbourResolver()));

        assertEquals(1, response.size());
        assertTrue(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldReturnNothingWhenOneLiveNeighbourTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.oneNeighbour()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnNothingWhenFourLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.fourNeighbours()),
                new NeighbourResolver()));
        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnNothingWhenFiveLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.fiveNeighbours()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnNothingWhenSixLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.sixNeighbours()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnNothingWhenSevenLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.sevenNeighbours()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldReturnNothingWhenEightLiveNeighboursTest() {
        Set<Life> response = new SurvivalRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.eightNeighbours()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldNotBreakChain() {
        assertFalse(new SurvivalRule().breakChain());
    }
}
