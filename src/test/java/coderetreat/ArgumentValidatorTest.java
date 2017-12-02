package coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArgumentValidatorTest {

    @Test
    void shouldThrowExceptionIfArgumentIsNullTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> ArgumentValidator.throwIfNotPresent(null, "myName"));
        assertEquals("Argument myName cannot be null.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWithNoNameInMessageTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> ArgumentValidator.throwIfNotPresent(null, null));
        assertEquals("Argument cannot be null.", exception.getMessage());
    }

    @Test
    void shouldDoNothingIfArgumentIsNotNullTest() {
        ArgumentValidator.throwIfNotPresent(Integer.valueOf(8), "myName");
    }

    @Test
    void shouldThrowExceptionWithArgumentNameInMessageWithUselessConditionTest() {
        Generation generation = new Generation();

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ArgumentValidator.throwIfNotPresentWithTest(null, "generation", "negative number", () -> !generation.hasPopulation()));
        assertEquals("Argument generation cannot be null.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWithArgumentNameInMessageWithAdditionalConditionTest() {
        Generation generation = new Generation();

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ArgumentValidator.throwIfNotPresentWithTest(generation, "generation", "negative number", () -> !generation.hasPopulation()));
        assertEquals("Argument generation cannot be null or negative number.", exception.getMessage());
    }

    @Test
    void shouldDoNothingIfArgumentIsNotNullAndConditionFalseTest() {
        Generation generation = new Generation();
        generation.addLife(new Life(0, 0));

        ArgumentValidator.throwIfNotPresentWithTest(generation, "generation", "negative number", () -> !generation.hasPopulation());
    }
}
