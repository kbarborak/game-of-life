package coderetreat;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Utility class for validating method arguments.
 */
public class ArgumentValidator {

    private final static String EMPTY_ADDITIONAL_CONDITION_MESSAGE = "";

    public static <T> void throwIfNotPresent(T testedArgument, String argumentName) {
        Optional.ofNullable(testedArgument).orElseThrow(() ->
                new IllegalArgumentException(createExceptionMessage(argumentName))
        );
    }

    public static <T> void throwIfNotPresentWithTest(T testedArgument, String argumentName, String testMessage,
                                                     Supplier<Boolean> testFunction) {
        throwIfNotPresent(testedArgument, argumentName);

        if (testFunction.get()) {
            throw new IllegalArgumentException(createExceptionMessage(argumentName, testMessage));
        }
    }

    private static String createExceptionMessage(String argumentName) {
        return createExceptionMessage(argumentName, EMPTY_ADDITIONAL_CONDITION_MESSAGE);
    }

    private static String createExceptionMessage(String argumentName, String testMessage) {
        StringBuilder exceptionMessage = new StringBuilder();
        String argumentNameInMessage = Optional.ofNullable(argumentName).orElse("");
        String conditionPartInMessage = Optional.ofNullable(testMessage).orElse("");

        exceptionMessage.append("Argument");

        if (!argumentNameInMessage.isEmpty()) {
            exceptionMessage.append(String.format(" %s ", argumentNameInMessage));
        } else {
            exceptionMessage.append(" ");
        }

        exceptionMessage.append("cannot be null");

        if (!conditionPartInMessage.isEmpty()) {
            exceptionMessage.append(String.format(" or %s", conditionPartInMessage));
        }

        exceptionMessage.append(".");

        return exceptionMessage.toString();
    }

    private ArgumentValidator() {
    }
}
