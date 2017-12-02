package coderetreat;

/**
 * Generation data fixtures for testing with ease. It returns Generation instance that creates required amount of live
 * neighbours around position at [0, 0]. For including life itself wrap selected method to withLife().
 */
class GenerationFixture {

    static Generation withLife(Generation generation) {
        generation.addLife(new Life(0, 0));
        return generation;
    }

    static Generation oneNeighbour() {
        Generation generation = new Generation();
        generation.addLife(new Life(-1, -1));
        return generation;
    }

    static Generation twoNeighbours() {
        Generation generation = oneNeighbour();
        generation.addLife(new Life(-1, 0));
        return generation;
    }

    static Generation threeNeighbours() {
        Generation generation = twoNeighbours();
        generation.addLife(new Life(-1, 1));
        return generation;
    }

    static Generation fourNeighbours() {
        Generation generation = threeNeighbours();
        generation.addLife(new Life(0, -1));
        return generation;
    }

    static Generation fiveNeighbours() {
        Generation generation = fourNeighbours();
        generation.addLife(new Life(0, 1));
        return generation;
    }

    static Generation sixNeighbours() {
        Generation generation = fiveNeighbours();
        generation.addLife(new Life(1, -1));
        return generation;
    }

    static Generation sevenNeighbours() {
        Generation generation = sixNeighbours();
        generation.addLife(new Life(1, 0));
        return generation;
    }

    static Generation eightNeighbours() {
        Generation generation = sevenNeighbours();
        generation.addLife(new Life(1, 1));
        return generation;
    }
}
