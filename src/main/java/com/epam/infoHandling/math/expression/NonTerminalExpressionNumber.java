package com.epam.infoHandling.math.expression;


import com.epam.infoHandling.math.MathValuesStack;

public class NonTerminalExpressionNumber extends Operator {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(MathValuesStack mathValuesStack) {
        mathValuesStack.pushValue(number);
    }
}
