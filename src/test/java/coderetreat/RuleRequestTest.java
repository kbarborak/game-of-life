package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleRequestTest {

    @Test
    void shouldHaveGettersForValuesTest() {
        RuleRequest request = new RuleRequest(new Life(0, 0), new Generation(), new NeighbourResolver());

        assertEquals(new Life(0, 0), request.getLife());
        assertEquals(new Generation(), request.getCurrentGeneration());
        assertTrue(request.getNeighbourResolver() instanceof NeighbourResolver);
    }

    @Test
    void shouldHaveBeCreatedValidObjectTest() {
        assertThrows(IllegalArgumentException.class, () -> new RuleRequest(null, new Generation(), new NeighbourResolver()));
        assertThrows(IllegalArgumentException.class, () -> new RuleRequest(new Life(0, 0), null, new NeighbourResolver()));
        assertThrows(IllegalArgumentException.class, () -> new RuleRequest(new Life(0, 0), new Generation(), null));
    }
}
