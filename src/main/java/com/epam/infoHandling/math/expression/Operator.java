package com.epam.infoHandling.math.expression;


import com.epam.infoHandling.math.MathValuesStack;

public abstract class Operator {
    public abstract void interpret(MathValuesStack mathValuesStack);
}
