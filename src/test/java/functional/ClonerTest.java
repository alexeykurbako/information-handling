package functional;


import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.functional.ComponentCloner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClonerTest {
    private Component initialComponent = new Composite();

    @Before
    public void setInitialComponent() {
        Component firstComponent = Lexeme.word("First");
        Component secondComponent = Lexeme.word("sentence.");

        Component firstSentence = new Composite(); // sentence
        firstSentence.add(firstComponent);
        firstSentence.add(secondComponent);

        Component thirdComponent = Lexeme.word("Second,");
        Component fourthComponent = Lexeme.word("sentence!");

        Component secondSentence = new Composite(); // sentence
        secondSentence.add(thirdComponent);
        secondSentence.add(fourthComponent);

        Component fifthComponent = Lexeme.expression("2 2 +");
        Component sixthComponent = Lexeme.word("sentence?");

        Component thirdSentence = new Composite(); // sentence
        thirdSentence.add(fifthComponent);
        thirdSentence.add(sixthComponent);


        initialComponent.add(firstSentence);
        initialComponent.add(secondSentence);
        initialComponent.add(thirdSentence);
    }

    @Test
    public void shouldCloneExistingComponent() {
        // given
        ComponentCloner componentCloner = new ComponentCloner();

        // when
        Component cloningComponent = componentCloner.clone(initialComponent);

        // then
        Assert.assertEquals(initialComponent, cloningComponent);
    }
}