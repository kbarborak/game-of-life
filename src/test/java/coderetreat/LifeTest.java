package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifeTest {

    @Test
    void constructorShouldNotAcceptNull() {
        assertThrows(IllegalArgumentException.class, () -> new Life(null, 6));
        assertThrows(IllegalArgumentException.class, () -> new Life(5, null));
        assertThrows(IllegalArgumentException.class, () -> new Life(null, null));
    }

    @Test
    void shouldHaveGettersForXAndY() {
        Life life = new Life(2, 5);

        assertEquals(Integer.valueOf(2), life.getX());
        assertEquals(Integer.valueOf(5), life.getY());
    }

    @Test
    void shouldReturnToStringTest() {
        assertEquals("Life [10, 0]", new Life(10, 0).toString());
    }

    @Test
    void shouldReturnSameHashCodeForSameLifeTest() {
        assertEquals(new Life(0, 0).hashCode(), new Life(0, 0).hashCode());
    }

    @Test
    void shouldNotReturnSameHashCodeForDifferentLifeTest() {
        assertNotEquals(new Life(0, 0).hashCode(), new Life(1, 5).hashCode());
    }

    @Test
    void shouldEqualForSameLifeTest() {
        assertTrue(new Life(0, 0).equals(new Life(0, 0)));
    }

    @Test
    void shouldNotEqualForDifferentLifeTest() {
        assertFalse(new Life(0, 0).equals(new Life(1, 5)));
    }
}
