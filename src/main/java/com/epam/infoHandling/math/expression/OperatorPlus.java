package com.epam.infoHandling.math.expression;

import com.epam.infoHandling.math.MathValuesStack;

public class OperatorPlus extends Operator {
    @Override
    public void interpret(MathValuesStack mathValuesStack) {
        Integer firstValue = mathValuesStack.popValue();
        Integer secondValue = mathValuesStack.popValue();
        mathValuesStack.pushValue(secondValue + firstValue);
    }
}
