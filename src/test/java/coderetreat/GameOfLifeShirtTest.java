package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Game simulation from image on t-shirt that I got on Coderetreat.
 */
class GameOfLifeShirtTest {

    @Test
    void shouldSatisfyPatternsFromCoderetreatShirtTest() {
        GameOfLife game = new GameOfLife();
        Generation seedGeneration = new Generation();

        //  #
        // ###
        //  #
        seedGeneration.addLife(new Life(0, 0));
        seedGeneration.addLife(new Life(0, -1));
        seedGeneration.addLife(new Life(0, 1));
        seedGeneration.addLife(new Life(-1, 0));
        seedGeneration.addLife(new Life(1, 0));

        game.initialize(seedGeneration);

        assertEquals(firstGeneration(), game.nextGeneration());
        assertEquals(secondGeneration(), game.nextGeneration());
        assertEquals(thirdGeneration(), game.nextGeneration());
        assertEquals(fourthGeneration(), game.nextGeneration());
        assertEquals(fifthGeneration(), game.nextGeneration());
        assertEquals(sixthGeneration(), game.nextGeneration());
        assertEquals(seventhGeneration(), game.nextGeneration());
        assertEquals(eighthGeneration(), game.nextGeneration());
    }

    private Generation firstGeneration() {
        Generation generation = new Generation(1);

        generation.addLife(new Life(-1, -1));
        generation.addLife(new Life(0, -1));
        generation.addLife(new Life(1, -1));
        generation.addLife(new Life(-1, 0));
        generation.addLife(new Life(1, 0));
        generation.addLife(new Life(-1, 1));
        generation.addLife(new Life(0, 1));
        generation.addLife(new Life(1, 1));

        return generation;
    }

    private Generation secondGeneration() {
        Generation generation = new Generation(2);

        generation.addLife(new Life(-2, 0));
        generation.addLife(new Life(-1, -1));
        generation.addLife(new Life(0, -2));
        generation.addLife(new Life(1, -1));
        generation.addLife(new Life(2, 0));
        generation.addLife(new Life(1, 1));
        generation.addLife(new Life(0, 2));
        generation.addLife(new Life(-1, 1));

        return generation;
    }

    private Generation thirdGeneration() {
        Generation generation = new Generation(3);

        generation.addLife(new Life(-2, 0));
        generation.addLife(new Life(-1, -1));
        generation.addLife(new Life(0, -2));
        generation.addLife(new Life(1, -1));
        generation.addLife(new Life(2, 0));
        generation.addLife(new Life(1, 1));
        generation.addLife(new Life(0, 2));
        generation.addLife(new Life(-1, 1));
        generation.addLife(new Life(0, -1));
        generation.addLife(new Life(0, 1));
        generation.addLife(new Life(-1, 0));
        generation.addLife(new Life(1, 0));

        return generation;
    }

    private Generation fourthGeneration() {
        Generation generation = new Generation(4);

        generation.addLife(new Life(-1, -2));
        generation.addLife(new Life(0, -2));
        generation.addLife(new Life(1, -2));
        generation.addLife(new Life(2, -1));
        generation.addLife(new Life(2, 0));
        generation.addLife(new Life(2, 1));
        generation.addLife(new Life(1, 2));
        generation.addLife(new Life(0, 2));
        generation.addLife(new Life(-1, 2));
        generation.addLife(new Life(-2, 1));
        generation.addLife(new Life(-2, 0));
        generation.addLife(new Life(-2, -1));

        return generation;
    }

    private Generation fifthGeneration() {
        Generation generation = new Generation(5);

        generation.addLife(new Life(-1, -2));
        generation.addLife(new Life(0, -2));
        generation.addLife(new Life(1, -2));
        generation.addLife(new Life(2, -1));
        generation.addLife(new Life(2, 0));
        generation.addLife(new Life(2, 1));
        generation.addLife(new Life(1, 2));
        generation.addLife(new Life(0, 2));
        generation.addLife(new Life(-1, 2));
        generation.addLife(new Life(-2, 1));
        generation.addLife(new Life(-2, 0));
        generation.addLife(new Life(-2, -1));
        generation.addLife(new Life(0, -1));
        generation.addLife(new Life(0, 1));
        generation.addLife(new Life(-1, 0));
        generation.addLife(new Life(1, 0));
        generation.addLife(new Life(-3, 0));
        generation.addLife(new Life(0, -3));
        generation.addLife(new Life(3, 0));
        generation.addLife(new Life(0, 3));

        return generation;
    }

    private Generation sixthGeneration() {
        Generation generation = new Generation(6);

        generation.addLife(new Life(-1, -3));
        generation.addLife(new Life(0, -3));
        generation.addLife(new Life(1, -3));
        generation.addLife(new Life(3, -1));
        generation.addLife(new Life(3, 0));
        generation.addLife(new Life(3, 1));
        generation.addLife(new Life(1, 3));
        generation.addLife(new Life(0, 3));
        generation.addLife(new Life(-1, 3));
        generation.addLife(new Life(-3, 1));
        generation.addLife(new Life(-3, 0));
        generation.addLife(new Life(-3, -1));

        return generation;
    }

    private Generation seventhGeneration() {
        Generation generation = new Generation(7);

        generation.addLife(new Life(0, -2));
        generation.addLife(new Life(0, -3));
        generation.addLife(new Life(0, -4));
        generation.addLife(new Life(-2, 0));
        generation.addLife(new Life(-3, 0));
        generation.addLife(new Life(-4, 0));
        generation.addLife(new Life(0, 2));
        generation.addLife(new Life(0, 3));
        generation.addLife(new Life(0, 4));
        generation.addLife(new Life(2, 0));
        generation.addLife(new Life(3, 0));
        generation.addLife(new Life(4, 0));

        return generation;
    }

    private Generation eighthGeneration() {
        Generation generation = new Generation(8);

        generation.addLife(new Life(-1, -3));
        generation.addLife(new Life(0, -3));
        generation.addLife(new Life(1, -3));
        generation.addLife(new Life(3, -1));
        generation.addLife(new Life(3, 0));
        generation.addLife(new Life(3, 1));
        generation.addLife(new Life(1, 3));
        generation.addLife(new Life(0, 3));
        generation.addLife(new Life(-1, 3));
        generation.addLife(new Life(-3, 1));
        generation.addLife(new Life(-3, 0));
        generation.addLife(new Life(-3, -1));

        return generation;
    }
}
