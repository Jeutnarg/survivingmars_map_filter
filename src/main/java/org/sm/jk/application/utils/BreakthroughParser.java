package org.sm.jk.application.utils;

import org.sm.jk.application.model.Breakthrough;

public class BreakthroughParser {
    public static Breakthrough parse(String part) {
        Breakthrough breakthrough = new Breakthrough();
        breakthrough.setName(part);
        return breakthrough;
    }
}
