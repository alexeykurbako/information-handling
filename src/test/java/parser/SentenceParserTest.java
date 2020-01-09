package parser;

import com.epam.infoHandling.composite.Component;
import com.epam.infoHandling.composite.Composite;
import com.epam.infoHandling.composite.Lexeme;
import com.epam.infoHandling.parser.AbstractParser;
import com.epam.infoHandling.parser.SentenceParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceParserTest {
    private static final String TEXT = "Hello 8 + 3 * 1";

    private Component expectedComponent;

    @Before
    public void init() {
        Component firstComponent = Lexeme.word("Hello");
        Component secondComponent = Lexeme.expression("8 + 3 * 1");
        expectedComponent = new Composite();

        expectedComponent.add(firstComponent);
        expectedComponent.add(secondComponent);
    }

    @Test
    public void shouldParseSentenceToComponent() {
        // given
        AbstractParser sentenceParser = new SentenceParser();

        // when
        Component actualComponent = sentenceParser.parse(TEXT);

        // then
        Assert.assertEquals(expectedComponent.getValue(), actualComponent.getValue());
    }
}