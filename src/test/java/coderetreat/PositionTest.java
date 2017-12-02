package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void constructorShouldNotAcceptNull() {
        assertThrows(IllegalArgumentException.class, () -> new Position(null, 6));
        assertThrows(IllegalArgumentException.class, () -> new Position(5, null));
        assertThrows(IllegalArgumentException.class, () -> new Position(null, null));
    }

    @Test
    void shouldHaveGettersForXAndY() {
        Position position = new Position(2, 5);

        assertEquals(Integer.valueOf(2), position.getX());
        assertEquals(Integer.valueOf(5), position.getY());
    }

    @Test
    void shouldReturnToStringTest() {
        assertEquals("Position [0, 0]", new Position(0, 0).toString());
    }

    @Test
    void shouldReturnSameHashCodeForSameLifeTest() {
        assertEquals(new Position(0, 0).hashCode(), new Position(0, 0).hashCode());
    }

    @Test
    void shouldNotReturnSameHashCodeForDifferentLifeTest() {
        assertNotEquals(new Position(0, 0).hashCode(), new Position(1, 5).hashCode());
    }

    @Test
    void shouldEqualForSameLifeTest() {
        assertTrue(new Position(0, 0).equals(new Position(0, 0)));
    }

    @Test
    void shouldNotEqualForDifferentLifeTest() {
        assertFalse(new Position(0, 0).equals(new Position(1, 5)));
    }
}
