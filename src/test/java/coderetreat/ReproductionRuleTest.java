package coderetreat;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReproductionRuleTest {

    @Test
    void shouldHandleRequestTest() {
        Set<Life> result = new ReproductionRule().handle(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnReproducedLifeWhenExactlyThreeLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(-1, 0), GenerationFixture.threeNeighbours(),
                new NeighbourResolver()));

        assertTrue(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldNotBreakChain() {
        assertFalse(new ReproductionRule().breakChain());
    }

    @Test
    void shouldNotReturnLifeWhenOneLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.oneNeighbour()),
                new NeighbourResolver()));

        assertTrue(response.isEmpty());
    }

    @Test
    void shouldNotReturnLifeWhenTwoLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.twoNeighbours()),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 1)));
    }

    @Test
    void shouldNotReturnLifeWhenFourLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, -1), GenerationFixture.fourNeighbours(),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldNotReturnLifeWhenFiveLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, -1), GenerationFixture.fiveNeighbours(),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldNotReturnLifeWhenSixLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, -1), GenerationFixture.sixNeighbours(),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldNotReturnLifeWhenSeveniveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, -1), GenerationFixture.sevenNeighbours(),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 0)));
    }

    @Test
    void shouldNotReturnLifeWhenEightLiveNeighboursTest() {
        Set<Life> response = new ReproductionRule().handle(new RuleRequest(new Life(0, -1), GenerationFixture.eightNeighbours(),
                new NeighbourResolver()));

        assertFalse(response.contains(new Life(0, 0)));
    }
}
