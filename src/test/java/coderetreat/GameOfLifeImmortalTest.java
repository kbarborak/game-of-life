package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example of extending game when game simulation is dealing with immortal life.
 */
class GameOfLifeImmortalTest {

    private GameOfLife game;

    @BeforeEach
    void setup() {
        RuleChain chain = new RuleChain();

        chain.addRule(new ReproductionRule());
        chain.addRule(new ImmortalLifeRule());
        chain.addRule(new SurvivalRule());

        game = new GameOfLife(new GenerationFactory(chain, new NeighbourResolver()));
    }

    @Test
    @Disabled
    void shouldNothing() {
        fail("");
    }
}
