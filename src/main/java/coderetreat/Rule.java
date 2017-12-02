package coderetreat;

import java.util.Set;

public abstract class Rule {
    public abstract Boolean breakChain();
    public abstract Set<Life> handle(RuleRequest request);
}
