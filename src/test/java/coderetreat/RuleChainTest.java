package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RuleChainTest {

    private RuleChain defaultRuleChain;

    @BeforeEach
    void setup() {
        defaultRuleChain = new RuleChain();

        defaultRuleChain.addRule(new ReproductionRule());
        defaultRuleChain.addRule(new SurvivalRule());
    }

    @Test
    void shouldApplyRulesOnLifeTest() {
        RuleChain ruleChain = new RuleChain();

        ReproductionRule reproduction = mock(ReproductionRule.class);
        SurvivalRule survival = mock(SurvivalRule.class);

        when(reproduction.handle(any())).thenReturn(new HashSet<>());
        when(survival.handle(any())).thenReturn(new HashSet<>());

        ruleChain.addRule(reproduction);
        ruleChain.addRule(survival);

        Set<Life> result = ruleChain.apply(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));

        verify(reproduction, times(1)).handle(any());
        verify(survival, times(1)).handle(any());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldAddRuleTest() {
        assertEquals(Integer.valueOf(0), new RuleChain().count());
        assertEquals(Integer.valueOf(2), defaultRuleChain.count());
    }

    @Test
    void addRuleShouldThrowExceptionWhenHandlerIsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> new RuleChain().addRule(null));
    }

    @Test
    void applyShouldThrowExceptionWhenNoRulesWerePassedTest() {
        assertThrows(IllegalStateException.class, () ->
                new RuleChain().apply(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()))
        );
    }

    @Test
    void applyShouldThrowExceptionWhenRequestIsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> defaultRuleChain.apply(null));
    }

    @Test
    void shouldBeAbleToBreakChainAfterRuleTest() {
        RuleChain chain = new RuleChain();

        ReproductionRule reproduction = mock(ReproductionRule.class);
        SurvivalRule survival = mock(SurvivalRule.class);
        BreakChainRule breakChain = mock(BreakChainRule.class);

        when(reproduction.handle(any())).thenReturn(new HashSet<>());
        when(breakChain.handle(any())).thenReturn(new HashSet<>());
        when(survival.handle(any())).thenReturn(new HashSet<>());

        when(reproduction.breakChain()).thenReturn(false);
        when(breakChain.breakChain()).thenReturn(true);
        when(survival.breakChain()).thenReturn(false);

        chain.addRule(reproduction);
        chain.addRule(breakChain);
        chain.addRule(survival);

        Set<Life> result = chain.apply(new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver()));

        verify(reproduction, times(1)).handle(any());
        verify(breakChain, times(1)).handle(any());
        verify(survival, never()).handle(any());
        assertTrue(result.isEmpty());
    }

    @Test
    void lifeWithFewerThanTwoLiveNeighboursShouldDieTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.oneNeighbour()),
                new NeighbourResolver()));

        assertTrue(result.isEmpty());
    }

    @Test
    void lifeWithTwoLiveNeighboursShouldStayAliveTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.twoNeighbours()),
                new NeighbourResolver()));

        assertTrue(result.contains(new Life(0, 0)));
    }

    @Test
    void lifeWithThreeLiveNeighboursShouldStayAliveTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.threeNeighbours()),
                new NeighbourResolver()));

        assertTrue(result.contains(new Life(0, 0)));
    }

    @Test
    void lifeWithFourLiveNeighboursShouldDieTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(0, 0), GenerationFixture.withLife(GenerationFixture.fourNeighbours()),
                new NeighbourResolver()));

        assertFalse(result.contains(new Life(0, 0)));
    }

    @Test
    void noLifeWithThreeLiveNeighboursShouldBeReproducedTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(0, 0), GenerationFixture.threeNeighbours(),
                new NeighbourResolver()));

        assertTrue(result.contains(new Life(0, 0)));
    }

    @Test
    void noLifeWithTwoNeighboursShouldNotBeReproducedTest() {
        Set<Life> result = defaultRuleChain.apply(new RuleRequest(new Life(-1, 0), GenerationFixture.twoNeighbours(),
                new NeighbourResolver()));

        assertTrue(result.isEmpty());
    }
}
