package coderetreat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourResolverTest {

    private NeighbourResolver neighbourResolver;

    @BeforeEach
    void setup() {
        neighbourResolver = new NeighbourResolver();
    }

    @Test
    void shouldCreateNewInstanceTest() {
        assertNotNull(neighbourResolver);
    }

    @Test
    void shouldResolveAllNeighboursTest() {
        Set<Neighbour> neighbours = neighbourResolver.resolveAll(new Life(5, 5));

        assertTrue(neighbours.contains(new Neighbour(4, 4)));
        assertTrue(neighbours.contains(new Neighbour(4, 5)));
        assertTrue(neighbours.contains(new Neighbour(4, 6)));
        assertTrue(neighbours.contains(new Neighbour(5, 4)));
        assertTrue(neighbours.contains(new Neighbour(5, 6)));
        assertTrue(neighbours.contains(new Neighbour(6, 4)));
        assertTrue(neighbours.contains(new Neighbour(6, 5)));
        assertTrue(neighbours.contains(new Neighbour(6, 6)));
    }

    @Test
    void shouldResolveNeighboursAtNegativePositionTest() {
        Set<Neighbour> neighbours = neighbourResolver.resolveAll(new Life(0, 0));

        assertTrue(neighbours.contains(new Neighbour(-1, -1)));
        assertTrue(neighbours.contains(new Neighbour(-1, 0)));
        assertTrue(neighbours.contains(new Neighbour(-1, 1)));
        assertTrue(neighbours.contains(new Neighbour(0, -1)));
        assertTrue(neighbours.contains(new Neighbour(0, 1)));
        assertTrue(neighbours.contains(new Neighbour(1, -1)));
        assertTrue(neighbours.contains(new Neighbour(1, 0)));
        assertTrue(neighbours.contains(new Neighbour(1, 1)));
    }

    @Test
    void shouldNotAcceptNullAsArgumentForResolveNeighboursTest() {
        assertThrows(IllegalArgumentException.class, () -> new NeighbourResolver().resolveAll(null));
    }

    @Test
    void shouldResolvePopulatedNeighboursTest() {
        Set<Neighbour> neighbours = neighbourResolver.resolvePopulated(new Life(0, 0), GenerationFixture.threeNeighbours());

        assertEquals(3, neighbours.size());
        assertEquals(Stream.of(new Neighbour(-1, 1), new Neighbour(-1, 0), new Neighbour(-1, -1)).collect(Collectors.toSet()), neighbours);
    }

    @Test
    void shouldAcceptOnlyValidArgumentsTest() {
        assertThrows(IllegalArgumentException.class, () -> new NeighbourResolver().resolvePopulated(new Life(0, 0), null));
        assertThrows(IllegalArgumentException.class, () -> new NeighbourResolver().resolvePopulated(null, new Generation()));
    }

    @Test
    void shouldResolveUnpopulatedNeighboursTest() {
        Set<Neighbour> neighbours = neighbourResolver.resolveUnpopulated(new Life(0, 0), GenerationFixture.fiveNeighbours());
        Set<Neighbour> expected = Stream.of(new Neighbour(1, -1), new Neighbour(1, 0), new Neighbour(1, 1))
                .collect(Collectors.toSet());

        assertEquals(expected, neighbours);
    }

    @Test
    void shouldAcceptOnlyValidArgumentsResolveUnpopulatedTest() {
        assertThrows(IllegalArgumentException.class, () -> new NeighbourResolver().resolveUnpopulated(new Life(0, 0), null));
        assertThrows(IllegalArgumentException.class, () -> new NeighbourResolver().resolveUnpopulated(null, new Generation()));
    }
}
