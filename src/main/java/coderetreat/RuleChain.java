package coderetreat;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RuleChain {

    private List<Rule> rules = new LinkedList<>();

    public void addRule(Rule rule) {
        ArgumentValidator.throwIfNotPresent(rule, "rule");

        rules.add(rule);
    }

    public Set<Life> apply(RuleRequest request) {
        ArgumentValidator.throwIfNotPresent(request, "request");
        Set<Life> lifeToNextGeneration = new HashSet<>();

        if (rules.isEmpty()) {
            throw new IllegalStateException("There are no rules to apply.");
        }

        for (Rule rule : rules) {
            lifeToNextGeneration.addAll(rule.handle(request));

            if (rule.breakChain()) {
                break;
            }
        }

        return lifeToNextGeneration;
    }

    public Integer count() {
        return rules.size();
    }
}
