package math;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.math.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private Component initial;
    private Component expected;
    private Component actual;

    @Before
    public void setInitialComponent() {
        Component firstComponent = Lexeme.word("Expression");
        Component secondComponent = Lexeme.expression("2 7 + 3 * 4 -");

        initial = new Composite();

        initial.add(firstComponent);
        initial.add(secondComponent);

    }

    @Before
    public void setExpectedComponent() {
        Component firstComponent = Lexeme.word("Expression");
        Component secondComponent = Lexeme.word("23");

        expected = new Composite();

        expected.add(firstComponent);
        expected.add(secondComponent);
    }

    @Test
    public void shouldCalculateExpressionsInComponent() {
        // given
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();

        // when
        actual = expressionCalculator.calculateExpressions(initial);
        Assert.assertEquals(expected.getValue(), actual.getValue());
    }
}