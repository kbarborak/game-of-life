package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourTest {

    @Test
    void constructorShouldNotAcceptNull() {
        assertThrows(IllegalArgumentException.class, () -> new Neighbour(null, 6));
        assertThrows(IllegalArgumentException.class, () -> new Neighbour(5, null));
        assertThrows(IllegalArgumentException.class, () -> new Neighbour(null, null));
    }

    @Test
    void shouldHaveGettersForXAndY() {
        Neighbour neighbour = new Neighbour(2, 5);

        assertEquals(Integer.valueOf(2), neighbour.getX());
        assertEquals(Integer.valueOf(5), neighbour.getY());
    }

    @Test
    void shouldReturnToStringTest() {
        assertEquals("Neighbour [10, 0]", new Neighbour(10, 0).toString());
    }

    @Test
    void shouldReturnSameHashCodeForSameNeighboursTest() {
        assertEquals(new Neighbour(0, 0).hashCode(), new Neighbour(0, 0).hashCode());
    }

    @Test
    void shouldNotReturnSameHashCodeForDifferentNeighboursTest() {
        assertNotEquals(new Neighbour(0, 0).hashCode(), new Neighbour(1, 5).hashCode());
    }

    @Test
    void shouldEqualForSameNeighboursTest() {
        assertTrue(new Neighbour(0, 0).equals(new Neighbour(0, 0)));
    }

    @Test
    void shouldNotEqualForDifferentNeighboursTest() {
        assertFalse(new Neighbour(0, 0).equals(new Neighbour(1, 5)));
    }
}
