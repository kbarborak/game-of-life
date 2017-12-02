package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImmortalLifeRuleTest {

    private ImmortalLifeRule immortalLifeRule;

    @BeforeEach
    void setup() {
        immortalLifeRule = new ImmortalLifeRule();
    }

    @Test
    void shouldHandleRequestTest() {
        Set<Life> response = new ImmortalLifeRule().handle(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));
        assertTrue(response.isEmpty());
    }

    @Test
    void shouldBreakChainForImmortalLifeTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new ImmortalLife(0, 0), new Generation(), new NeighbourResolver()));

        assertTrue(immortalLifeRule.breakChain());
        assertTrue(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotBreakChainForOrdinaryLifeTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertTrue(response.isEmpty());
    }

    @Test
    void shouldConvertLifeToImmortalLifeIfHasExactlyThreeLiveNeighboursAndBreakChainTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.threeNeighbours()),
                new NeighbourResolver()));

        assertTrue(immortalLifeRule.breakChain());
        assertTrue(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForOneLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.oneNeighbour()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForTwoLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.twoNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForFourLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.fourNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForFiveLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.fiveNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForSixLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.sixNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForSevenLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.sevenNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }

    @Test
    void shouldNotConvertLifeToImmortalLifeAndBreakChainForEightLiveNeighboursTest() {
        Set<Life> response = immortalLifeRule.handle(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.eightNeighbours()),
                new NeighbourResolver()));

        assertFalse(immortalLifeRule.breakChain());
        assertFalse(response.contains(new ImmortalLife(0, 0)));
    }
}
