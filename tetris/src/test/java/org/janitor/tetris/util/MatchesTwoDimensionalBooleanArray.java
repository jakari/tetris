package org.janitor.tetris.util;

import org.mockito.ArgumentMatcher;
import java.util.Arrays;

public class MatchesTwoDimensionalBooleanArray implements ArgumentMatcher
{
    private boolean[][] expected;

    public MatchesTwoDimensionalBooleanArray(boolean[][] expected) {
        super();

        this.expected = expected;
    }

    @Override
    public boolean matches(Object o) {
        if (!o.getClass().equals(expected.getClass())) {
            return false;
        }

        boolean[][] m = (boolean[][]) o;

        if (m.length != expected.length) {
            return false;
        }

        for (int a = 0; a < m.length; a++) {
            if (!Arrays.equals(expected[a], m[a])) {
                return false;
            }
        }

        return true;
    }
}
