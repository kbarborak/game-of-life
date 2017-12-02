package coderetreat;

import java.util.HashSet;
import java.util.Set;

class BreakChainRule extends Rule {

    @Override
    public Boolean breakChain() {
        return true;
    }

    @Override
    public Set<Life> handle(RuleRequest request) {
        return new HashSet<>();
    }
}
