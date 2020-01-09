package com.epam.infoHandling.math;

import java.util.ArrayDeque;

public class MathValuesStack {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<Integer>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}
