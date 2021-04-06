package org.sm.jk.application.utils;

import java.util.Set;

public class AdvancedBreakthroughParserUtil {

    public static AdvancedBreakthroughPredicate parseAdvancedBreakthroughs(String breakthroughText, Set<String> breakthroughs) {
        //do more advanced stuff later here?
        return new AdvancedBreakthroughPredicate(breakthroughText, breakthroughs);
    }

}
