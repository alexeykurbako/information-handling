package com.epam.infoHandling.math;

import com.epam.infoHandling.math.expression.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathInterpreter {
    private List<Operator> mathExpressions;

    public MathInterpreter(String expression) {
        mathExpressions = new ArrayList<>();
        parse(expression);
    }


    private void parse(String expression) {
        for (String lexeme : expression.split(" ")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            switch (lexeme) {
                case "+":
                    mathExpressions.add(new OperatorPlus());
                    break;
                case "-":
                    mathExpressions.add(new OperatorMinus());
                    break;
                case "*":
                    mathExpressions.add(new OperatorMultiply());
                    break;
                case "/":
                    mathExpressions.add(new OperatorDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        mathExpressions.add(new NonTerminalExpressionNumber(scanner.nextInt()));
                    }
                    break;
            }
        }
    }

    public int calculate() {
        MathValuesStack mathValuesStack = new MathValuesStack();
        for (Operator terminal : mathExpressions) {
            terminal.interpret(mathValuesStack);
        }
        return mathValuesStack.popValue();
    }
}
