package functional;


import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.functional.ComponentPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrinterTest {
    private static final String EXPECTED_TEXT = "\tFirst sentence. 1 1 + sentence?\n" +
            "\tThird sentence. Fourth sentence 2 3 * 4 + ok?\n" +
            "\tBye...\n\t";

    private Component component;

    @Before
    public void init() {
        Component lexeme1 = Lexeme.word("First");
        Component lexeme2 = Lexeme.word("sentence.");
        Component lexeme3 = Lexeme.expression("1 1 +");
        Component lexeme4 = Lexeme.word("sentence?");
        Component lexeme5 = Lexeme.word("Third");
        Component lexeme7 = Lexeme.word("Fourth");
        Component lexeme6 = Lexeme.word("sentence.");
        Component lexeme8 = Lexeme.word("sentence");
        Component lexeme9 = Lexeme.expression("2 3 * 4 +");
        Component lexeme10 = Lexeme.word("ok?");
        Component lexeme11 = Lexeme.word("Bye...");

        Component sentence1 = new Composite();
        Component sentence2 = new Composite();
        Component sentence3 = new Composite();
        Component sentence4 = new Composite();
        Component sentence5 = new Composite();

        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        sentence2.add(lexeme3);
        sentence2.add(lexeme4);

        sentence3.add(lexeme5);
        sentence3.add(lexeme6);

        sentence4.add(lexeme7);
        sentence4.add(lexeme8);
        sentence4.add(lexeme9);
        sentence4.add(lexeme10);

        sentence5.add(lexeme11);

        Component paragraph1 = new Composite();
        Component paragraph2 = new Composite();
        Component paragraph3 = new Composite();

        paragraph1.add(sentence1);
        paragraph1.add(sentence2);

        paragraph2.add(sentence3);
        paragraph2.add(sentence4);

        paragraph3.add(sentence5);

        component = new Composite();
        component.add(paragraph1);
        component.add(paragraph2);
        component.add(paragraph3);
    }

    @Test
    public void shouldParseComponentToText() {
        // given
        ComponentPrinter componentPrinter = new ComponentPrinter();

        // when
        String actualText = componentPrinter.parseToString(component);

        // then
        Assert.assertEquals(EXPECTED_TEXT, actualText);
    }
}