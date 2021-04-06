package org.sm.jk.application.utils;

import org.mvel2.MVEL;
import org.sm.jk.application.model.DisplayMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdvancedBreakthroughPredicate {

    private final String expression;
    private final Set<String> allBreakthroughs;
    private final Map<String, Object> emptyContext;

    public AdvancedBreakthroughPredicate(String expression, Set<String> breakthroughs) {
        this.expression = expression;
        this.allBreakthroughs = breakthroughs;
        this.emptyContext = new HashMap<>();
    }

    public boolean test(DisplayMap map) {
        Map<String, Boolean> context = genContext(map);
        String expr = expression;
        for(String string : context.keySet()) {
            expr = expr.replace(string, Boolean.toString(context.get(string)));
        }
        return (boolean) MVEL.eval(expr, emptyContext);
    }

    private Map<String, Boolean> genContext(DisplayMap map) {
        Map<String, Boolean> result = new HashMap<>();
        for(String breakthrough : allBreakthroughs) {
            result.put(breakthrough, map.getBreakthroughs().contains(breakthrough));
        }
        return result;
    }
}
