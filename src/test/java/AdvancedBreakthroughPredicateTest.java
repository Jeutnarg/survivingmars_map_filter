import org.junit.Test;
import org.sm.jk.application.model.DisplayMap;
import org.sm.jk.application.utils.AdvancedBreakthroughPredicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedBreakthroughPredicateTest {

    @Test
    public void testSimpleBreakthroughPredicate() {
        Set<String> breakthroughs = new HashSet<>();
        breakthroughs.add("Extractor AI");
        breakthroughs.add("Forever Young");
        breakthroughs.add("Superconducting");
        breakthroughs.add("TestOne");
        String expression = "Extractor AI && Superconducting";
        AdvancedBreakthroughPredicate predicate = new AdvancedBreakthroughPredicate(expression, breakthroughs);
        List<String> localBreakthroughs = new ArrayList<>();
        localBreakthroughs.add("Forever Young");
        localBreakthroughs.add("Extractor AI");
        localBreakthroughs.add("Superconducting");
        DisplayMap map = new DisplayMap(localBreakthroughs);
        assert(predicate.test(map));
    }
}
